package com.everfire.voxelitemod.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class VoxeliteFluid extends FlowableFluid {

	@Override
	protected boolean isInfinite() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
		// TODO Auto-generated method stub
		final BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
		Block.dropStacks(state, world, pos, blockEntity);
	}
	
	@Override
	protected ParticleEffect getParticle() {
		// TODO Auto-generated method stub
		return ParticleTypes.DRIPPING_WATER;
	}
	
	@Override
	protected int getFlowSpeed(WorldView var1) {
		// TODO Auto-generated method stub
		return 3;
	}
	@Override
	protected int getLevelDecreasePerBlock(WorldView var1) {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public int getTickRate(WorldView var1) {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	protected float getBlastResistance() {
		// TODO Auto-generated method stub
		return 100f;
	}
	
	@Override
	protected boolean canBeReplacedWith(FluidState var1, BlockView var2, BlockPos var3, Fluid var4, Direction var5) {
		// TODO Auto-generated method stub
		return false;
	}
	
    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == ModFluids.STILL_VOXELITE_FLUID || fluid == ModFluids.FLOWING_VOXELITE_FLUID;
    }
	
	@Override
	public Fluid getStill() {
		// TODO Auto-generated method stub
		return ModFluids.STILL_VOXELITE_FLUID;
	}
	
	@Override
	public Fluid getFlowing() {
		// TODO Auto-generated method stub
		return ModFluids.FLOWING_VOXELITE_FLUID;
	}
	
	@Override
	public Item getBucketItem() {
		// TODO Auto-generated method stub
		return ModFluids.VOXELITE_BUCKET;
	}
	
	@Override
	protected BlockState toBlockState(FluidState state) {
		// TODO Auto-generated method stub
		return ModFluids.VOXELITE_FLUID_BLOCK.getDefaultState().with(FluidBlock.LEVEL, VoxeliteFluid.getBlockStateLevel(state));
	}
	
	public static class Flowing extends VoxeliteFluid {
		@Override
		protected void appendProperties(Builder<Fluid, FluidState> builder) {
			// TODO Auto-generated method stub
			super.appendProperties(builder);
			builder.add(LEVEL);
		}
		
        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }
		
		@Override
		public boolean isStill(FluidState var1) {
			// TODO Auto-generated method stub
			return false;
		}

	}
	
	public static class Still extends VoxeliteFluid {
		@Override
		public int getLevel(FluidState var1) {
			// TODO Auto-generated method stub
			return 8;
		}
		@Override
		public boolean isStill(FluidState var1) {
			// TODO Auto-generated method stub
			return true;
		}
	}
	
}
