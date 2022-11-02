package com.everfire.voxelitemod.item;

import com.everfire.voxelitemod.block.LockableDoorBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LockableDoorBlockItem extends BlockItem {

    private boolean Locked;
    public LockableDoorBlockItem(Block block, Settings settings, boolean locked) {
        super(block, settings);
        this.Locked = locked;
    }

    @Override
    protected boolean postPlacement(BlockPos pos, World world, @Nullable PlayerEntity player, ItemStack stack, BlockState state) {
        state.with(LockableDoorBlock.LOCKED,Locked);
        return super.postPlacement(pos, world, player, stack, state);
    }
}
