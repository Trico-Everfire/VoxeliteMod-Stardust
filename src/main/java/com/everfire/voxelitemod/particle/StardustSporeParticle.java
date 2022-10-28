package com.everfire.voxelitemod.particle;

import java.awt.Color;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.AscendingParticle;
import net.minecraft.client.particle.BlockFallingDustParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.util.math.Vector3d;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.random.Random;

public class StardustSporeParticle extends SpriteBillboardParticle{

		protected StardustSporeParticle(ClientWorld clientWorld, double d, double e, double f) {
		super(clientWorld, d, e, f);
		// TODO Auto-generated constructor stub
	}

		private float yRotation = 0;

		@Override
		public ParticleTextureSheet getType() {
			// TODO Auto-generated method stub
			return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
		}
		
//	    public ParticleType<DustParticleEffect> getType1() {
//	        return ParticleTypes.DUST;
//	    }
	
	   private StardustSporeParticle(ClientWorld worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double speedIn) {
		      super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, speedIn);
		      float f = this.random.nextFloat() * 0.1F + 0.2F;
//		      this.setSprite(sprite);
		      this.scale(scale * (this.random.nextFloat() * 5.6F + 0.5F));
		      this.velocityX *= xSpeedIn;
		      this.velocityY *= ySpeedIn;
		      this.velocityZ *= speedIn;
		      setColor(f, f, f);

		      this.maxAge = (int)(20.0D / (Math.random() * 0.8D + 0.2D));
		   }
	   
	   
	   
	    @Environment(value=EnvType.CLIENT)
	    public static class Factory
	    implements ParticleFactory<DefaultParticleType> {
	        private final SpriteProvider spriteProvider;

	        public Factory(SpriteProvider spriteProvider) {
	            this.spriteProvider = spriteProvider;
	          
	        }

	        @Override
	        @Nullable
	        public Particle createParticle(DefaultParticleType DustParticleEffect, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
				
	        	
	        	
	        	StardustSporeParticle suspendedStardust = new StardustSporeParticle(worldIn, x, y, z, zSpeed, zSpeed, zSpeed);
	        	suspendedStardust.setSprite(this.spriteProvider);
	        	//suspendedStardust.selectSpriteRandomly(this.spriteSet);
		    //	suspendedStardust.setSize(suspendedStardust.width * 10f, suspendedStardust.height * 10f);
		    	int hex;
		    	switch((int)Random.create().nextBetween(0, 3)){
		    	case 0:
		    	hex = 0xE6E6FA;
		    	case 1:
		    	hex = 0x9370DB;
		    	break;
		    	case 2:
		    	hex = 0x8A2BE2;
		    	break;
		    	case 3:
		    	hex = 0x9400D3;
		    	break;
		    	default:
		    	hex = 0x000000;
		    	break;
		    	}
		    	//hex = 0x000000;
		    	
		    	
//		    	float[] colorData =  ModMathHelper.ParticleColorFromHex(hex);//ModMathHelper.ParticleColorFromRGB(red,green,blue);
		    	 
		    	Color color = new Color(hex);
				float[] Colors = color.getColorComponents(null);
				
				float r = Colors[0];
				float g = Colors[1];
				float b = Colors[2];
		    	//suspendedStardust.width = 10;
		    //	suspendedStardust.height = 10;
		    	//suspendedStardust.multiplyParticleScaleBy(4);
		    	suspendedStardust.setColor(r,g,b);
		    	
		        return suspendedStardust;
	        	
	        	
	        	

	        	//	            BlockState blockState = blockStateParticleEffect.getBlockState();
//	            if (!blockState.isAir() && blockState.getRenderType() == BlockRenderType.INVISIBLE) {
//	                return null;
//	            }
//	            BlockPos blockPos = new BlockPos(d, e, f);
//	            int j = MinecraftClient.getInstance().getBlockColors().getParticleColor(blockState, clientWorld, blockPos);
//	            if (blockState.getBlock() instanceof FallingBlock) {
//	                j = ((FallingBlock)blockState.getBlock()).getColor(blockState, clientWorld, blockPos);
//	            }
//	            float k = (float)(j >> 16 & 0xFF) / 255.0f;
//	            float l = (float)(j >> 8 & 0xFF) / 255.0f;
//	            float m = (float)(j & 0xFF) / 255.0f;
//	            return new StardustSporeParticle(clientWorld, d, e, f, k, l, m, this.spriteProvider);
	        }
	    }
	   
	   
	   
	   
//
//		   public IParticleRenderType getRenderType() {
//		      return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
//		   }
//
//		   public void move(double x, double y, double z) {
//		      this.setBoundingBox(this.getBoundingBox().offset(x, y, z));
//		      this.resetPositionToBB();
//		   }
//
//		   public void tick() {
//		      this.prevPosX = this.posX;
//		      this.prevPosY = this.posY;
//		      this.prevPosZ = this.posZ;
//		      if (this.maxAge-- <= 0) {
//		         this.setExpired();
//		      } else {
//		         this.move(this.motionX, this.motionY, this.motionZ);
//		         this.motionX *= 0.99D;
//		         this.motionY *= 0.99D;
//		         this.motionZ *= 0.99D;
//		      }
//		   }
		   
//		   @Override
//		public void renderParticle(IVertexBuilder buffer, ActiveRenderInfo renderInfo, float partialTicks) {
//			// TODO Auto-generated method stub
////			   float x = renderInfo.getRotation().getX();
////			   float y = renderInfo.getRotation().getY();
////			   float z = renderInfo.getRotation().getZ();
////			   float w = renderInfo.getRotation().getW();
////			   
//////			   renderInfo.getRotation().multiply(2.0f);
////			//System.out.println(renderInfo.getBlockAtCamera());
////			 // renderInfo.getRotation().set(x, y + 1f, z, w);
////			super.renderParticle(buffer, renderInfo, partialTicks);
//			   
//			   
//			   
//			   Vector3d vector3d = renderInfo.getProjectedView();
//			  // vector3d.add(10, 10, 10);
//			 //  vector3d.add(10d, 4d, 0);
//			      float f = (float)(MathHelper.lerp((double)partialTicks, this.prevPosX, this.posX) - vector3d.getX());
//			      float f1 = (float)(MathHelper.lerp((double)partialTicks, this.prevPosY, this.posY) - vector3d.getY());
//			      float f2 = (float)(MathHelper.lerp((double)partialTicks, this.prevPosZ, this.posZ) - vector3d.getZ());
//			      Quaternion quaternion;
//			     // this.particleAngle =+ 0.4f;
//			      this.yRotation += 0.001f;
//			      if(this.yRotation > 0.05f ) {
//			    	  this.yRotation = 0;
//			      }
//			      if (this.particleAngle == 0.0F) {
//			    	 // System.out.println("sauce");
//			         quaternion = renderInfo.getRotation();
//			      } else {
//			         quaternion = new Quaternion(renderInfo.getRotation());
//			         float f3 = MathHelper.lerp(partialTicks, this.prevParticleAngle, this.particleAngle);
//			         //f3 =+ 4;
//			         quaternion.multiply(Vector3f.ZP.rotation(f3));
//			      }
//			      //quaternion.set(quaternion.getX(), quaternion.getY(), quaternion.getZ()+ this.yRotation , quaternion.getW());
//			      
//			  //    System.out.println(this.yRotation);
//			      Vector3f vector3f1 = new Vector3f(-1.0F, -1.0F, 0.0F);
//			      vector3f1.transform(quaternion);
//			      Vector3f[] avector3f = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};
//			      float f4 = this.getScale(partialTicks);
//
//			      for(int i = 0; i < 4; ++i) {
//			         Vector3f vector3f = avector3f[i];
//			         vector3f.transform(quaternion);
//			         vector3f.mul(f4);
//			         vector3f.add(f, f1, f2);
//			      }
//
//			      float f7 = this.getMinU();
//			      float f8 = this.getMaxU();
//			      float f5 = this.getMinV();
//			      float f6 = this.getMaxV();
//			      int j = this.getBrightnessForRender(partialTicks);
//			      buffer.pos((double)avector3f[0].getX(), (double)avector3f[0].getY(), (double)avector3f[0].getZ()).tex(f8, f6).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j).endVertex();
//			      buffer.pos((double)avector3f[1].getX(), (double)avector3f[1].getY(), (double)avector3f[1].getZ()).tex(f8, f5).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j).endVertex();
//			      buffer.pos((double)avector3f[2].getX(), (double)avector3f[2].getY(), (double)avector3f[2].getZ()).tex(f7, f5).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j).endVertex();
//			      buffer.pos((double)avector3f[3].getX(), (double)avector3f[3].getY(), (double)avector3f[3].getZ()).tex(f7, f6).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j).endVertex();
//			   
//		}
//		   
	


}