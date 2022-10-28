package com.everfire.voxelitemod.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.SpreadableBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class VoxeliteFluidBlock extends FluidBlock {

	public VoxeliteFluidBlock(FlowableFluid fluid, Settings settings) {
		super(fluid, settings);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean hasRandomTicks(BlockState state) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		// TODO Auto-generated method stub
		if(entity instanceof LivingEntity) {
			entity.damage(DamageSource.DRAGON_BREATH, 2.0f);
		}
		if(entity instanceof ItemEntity) {
			ItemEntity iEntity = (ItemEntity) entity;
			iEntity.setGlowing(true);
		}
		super.onEntityCollision(state, world, pos, entity);
	}
	
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
    		super.randomTick(state, world, pos, random);
            BlockState blockState = this.getDefaultState();
            
            for (int i = 0; i < blockState.getFluidState().getLevel(); ++i) {
                BlockPos blockPos = pos.add(random.nextBetween(-6, 6), random.nextBetween(-3, 3), random.nextBetween(-6, 6));
                if (world.getBlockState(blockPos).isOf(Blocks.AIR) || world.getBlockState(blockPos).isOf(this) || !world.getBlockState(blockPos).isSolidBlock(world, blockPos)) continue;
                world.setBlockState(blockPos, ModBlocks.VOXELIZED_STONE.getDefaultState());
            }
            
    }

}
