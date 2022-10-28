package com.everfire.voxelitemod.particle;

import com.everfire.voxelitemod.VoxeliteMod;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModParticles {

	public static final DefaultParticleType STARDUST_GROWTH_BLOCK_PARTICLE = registerParticles("stardust_growth_block_particle",FabricParticleTypes.simple());
	
	private static DefaultParticleType registerParticles(String name, DefaultParticleType particle) {
		return Registry.register(Registry.PARTICLE_TYPE, new Identifier(VoxeliteMod.MOD_ID, name),particle);
	}
	
	public static void registerParticles() {
		VoxeliteMod.LOGGER.debug("Registering Voxelite Particles");
	}
}
