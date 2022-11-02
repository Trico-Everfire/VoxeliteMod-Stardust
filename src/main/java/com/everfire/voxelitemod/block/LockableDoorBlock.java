package com.everfire.voxelitemod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Material;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;

import java.util.ArrayList;

public class LockableDoorBlock extends DoorBlock {

    private Item keyItem;
    public static final BooleanProperty LOCKED;

    public LockableDoorBlock(Settings settings, Item keyItem) {
        super(settings);
        this.keyItem = keyItem;
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)).with(OPEN, false)).with(HINGE, DoorHinge.LEFT)).with(POWERED, false)).with(HALF, DoubleBlockHalf.LOWER).with(LOCKED,this.keyItem != null));
    }

    protected static boolean haveFacingHinges(BlockPos pos1, BlockPos pos2, BlockState state1, BlockState state2) {
       //if(state1.get(FACING) == null || state2.get(FACING) == null) return false;
        Direction facing1 = state1.get(FACING);
        Direction facing2 = state2.get(FACING);
        if (facing1 != facing2)  {
            return false;
        }
        // System.out.println("passed");
        //if(state1.get(HINGE) == null || state2.get(HINGE) == null) return false;
        DoorHinge hingeSide1 = state1.get(HINGE);
        DoorHinge hingeSide2 = state2.get(HINGE);
        Direction hingeDir1 = hingeSide1 == DoorHinge.LEFT ? facing1.rotateYCounterclockwise() : facing1.rotateYClockwise();
        Direction hingeDir2 = hingeSide2 == DoorHinge.LEFT ? facing2.rotateYCounterclockwise() : facing2.rotateYClockwise();

        Direction facingRotY = facing1.rotateYClockwise();
        if (pos1.offset(facingRotY).equals(pos2))
        {
            // pos2 is in the direction of facingRotY
            if (facingRotY != hingeDir2.getOpposite())
            {
                return false;
            }
        }
        else
        {
            // pos1 is in the direction of facingRotY
            if (facingRotY != hingeDir1.getOpposite())
            {
                return false;
            }
        }


        Direction facingRotYCCW = facing1.rotateYCounterclockwise();
        if (pos1.offset(facingRotYCCW).equals(pos2))
        {
            // pos2 is in the direction of facingRotYCCW
            if (facingRotYCCW != hingeDir2.getOpposite())
            {
                return false;
            }
        }
        else
        {
            // pos1 is in the direction of facingRotYCCW
            if (facingRotYCCW != hingeDir1.getOpposite())
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if(player.getStackInHand(hand).getItem() == keyItem && state.get(LOCKED)){
            if(!player.isCreative()) player.getStackInHand(hand).decrement(1);
            state = state.cycle(LOCKED);
            world.setBlockState(pos, state, 10);
            BlockPos altPos = pos.offset(Direction.Axis.Y, ((state.get(HALF) == DoubleBlockHalf.UPPER)) ? -1 : 1);
            BlockState altState = world.getBlockState(altPos);
            altState = altState.cycle(LOCKED);
            world.setBlockState(altPos, altState, 10);

            ArrayList<BlockPos> posArray = new ArrayList<>();
            posArray.add(pos.north());
            posArray.add(pos.east());
            posArray.add(pos.south());
            posArray.add(pos.west());

            for(int j = 0; j < 4; j++){
                BlockState currentState = state;
                BlockState counterDoorState = world.getBlockState(posArray.get(j));
                if(!(counterDoorState.getBlock() instanceof LockableDoorBlock)) continue;
                LockableDoorBlock otherDoorBlock = (LockableDoorBlock) counterDoorState.getBlock();
                if(otherDoorBlock.keyItem != keyItem) continue;
                boolean isSameFacing = haveFacingHinges(pos,posArray.get(j),counterDoorState,currentState);
                if(isSameFacing){
                    BlockPos otherPos = posArray.get(j).offset(Direction.Axis.Y,((counterDoorState.get(HALF) == DoubleBlockHalf.UPPER)) ? -1 : 1);
                    counterDoorState = counterDoorState.cycle(LOCKED);
                    counterDoorState = counterDoorState.cycle(OPEN);
                    world.setBlockState(posArray.get(j), counterDoorState, 10);
                    BlockState counterDoorStateOther = world.getBlockState(otherPos);
                    counterDoorStateOther = counterDoorStateOther.cycle(LOCKED);
                    world.setBlockState(otherPos, counterDoorStateOther, 10);

                }
            }

        }



        if(!state.get(LOCKED)){
            state = state.cycle(OPEN);
            world.setBlockState(pos, state, 10);
            world.syncWorldEvent(player, state.get(OPEN) ? this.getOpenSoundEventId() : this.getCloseSoundEventId(), pos, 0);
            world.emitGameEvent(player, this.isOpen(state) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            return ActionResult.success(world.isClient);
        }
        return ActionResult.PASS;

    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        if(!world.getBlockState(pos).get(LOCKED))
            super.onDestroyedByExplosion(world, pos, explosion);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if(!state.get(LOCKED))
            super.onBreak(world, pos, state, player);

    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(LOCKED);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if(!state.get(LOCKED))
            super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }

    private void playOpenCloseSound(World world, BlockPos pos, boolean open) {
        world.syncWorldEvent((PlayerEntity)null, open ? this.getOpenSoundEventId() : this.getCloseSoundEventId(), pos, 0);
    }

    private int getCloseSoundEventId() {
        return this.material == Material.METAL ? 1011 : 1012;
    }

    private int getOpenSoundEventId() {
        return this.material == Material.METAL ? 1005 : 1006;
    }

    static {
        LOCKED = BooleanProperty.of("locked");
    }

}
