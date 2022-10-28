package com.everfire.voxelitemod.block;

import java.util.SplittableRandom;

import com.everfire.voxelitemod.particle.ModParticles;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class StardustGrowthBlock extends Block {

	public StardustGrowthBlock(Settings settings) {
		super(settings);

		// TODO Auto-generated constructor stub
	}
	
	   @Override
	   public void randomDisplayTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
	      super.randomDisplayTick(stateIn, worldIn, pos, rand);
	      if (rand.nextInt(3) == 0) {
	         worldIn.addParticle(ModParticles.STARDUST_GROWTH_BLOCK_PARTICLE, (double)pos.getX() + (double)rand.nextFloat(), (double)pos.getY() + 1.1D, (double)pos.getZ() + (double)rand.nextFloat(), 0.02D, 0.02D, 0.02D);
	      }

	   }
	   
	   @Override
	public boolean hasSidedTransparency(BlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	   

	   @Override
		public void onLandedUpon(World worldIn, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
			// TODO Auto-generated method stub
		   
			if(worldIn.isClient) {
				
//				  double step = 2*Math.PI/60;  // see note 1
//				  double h = 0d; 
//				  double k = 0d;
//				  double r = 2;Random.
				
				//System.out.println(fallDistance * 2);
				//System.out.println(2*Math.PI);
			    for(double theta=0;  theta < fallDistance;  theta+=0.05){ 

			    	SplittableRandom random = new SplittableRandom();
			    	
			    	//double distanceFly = fallDistance / 4;
			    	boolean r = random.nextInt(2) == 1;
			    	double randomResultX = r ? 0.3 * (fallDistance / 4) : -0.3 * -(fallDistance / 4);//random.nextDouble(-1.6, 1.2);
			    	double randomResultZ = r ? 0.3 * (fallDistance / 4) : -0.3 * -(fallDistance / 4);//random.nextDouble(-1.6, 1.2);
			    	
			    	 fallDistance = fallDistance >= 5 ? 5f : fallDistance;
			    	//System.out.println(distanceFly);
			    	worldIn.addParticle((ParticleEffect) ModParticles.STARDUST_GROWTH_BLOCK_PARTICLE, (double)pos.getX() + (double)Random.create().nextFloat(), (double)pos.getY() + 1.1D, (double)pos.getZ() + (double)Random.create().nextFloat(), randomResultX, fallDistance / 2, randomResultZ);
			     }
			}
			super.onLandedUpon(worldIn, state, pos, entity, fallDistance);
		}

}
