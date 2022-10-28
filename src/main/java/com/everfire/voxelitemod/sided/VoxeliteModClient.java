package com.everfire.voxelitemod.sided;

import com.everfire.voxelitemod.block.ModBlocks;
import com.everfire.voxelitemod.fluid.ModFluids;
import com.everfire.voxelitemod.particle.ModParticles;
import com.everfire.voxelitemod.particle.StardustSporeParticle;
import com.everfire.voxelitemod.utils.VoxeliteUtils;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.screen.PlayerScreenHandler;

public class VoxeliteModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

 
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STARDUSTGROWTH, RenderLayer.getCutoutMipped());
        /* Registers our particle client-side. 
         * First argument is our particle's instance, created previously on ExampleMod. 
         * Second argument is the particle's factory. The factory controls how the particle behaves. 
         * In this example, we'll use FlameParticle's Factory.*/
        ParticleFactoryRegistry.getInstance().register(ModParticles.STARDUST_GROWTH_BLOCK_PARTICLE, StardustSporeParticle.Factory::new);
    
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_VOXELITE_FLUID, ModFluids.FLOWING_VOXELITE_FLUID, 
        		new SimpleFluidRenderHandler(
        				VoxeliteUtils.identifier("block/liquid_voxelite_still"),
        				VoxeliteUtils.identifier("block/liquid_voxelite_flow")
        		));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),ModFluids.STILL_VOXELITE_FLUID,ModFluids.FLOWING_VOXELITE_FLUID);
    
		ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
		    registry.register(VoxeliteUtils.identifier("block/liquid_voxelite_still"));
		    registry.register(VoxeliteUtils.identifier("block/liquid_voxelite_flow"));
		    registry.register(VoxeliteUtils.identifier("blocks/black_stone_door_top"));
		    registry.register(VoxeliteUtils.identifier("blocks/black_stone_door_bottom"));
		    registry.register(VoxeliteUtils.identifier("blocks/locked_blue_dungeon_door_top"));
		    registry.register(VoxeliteUtils.identifier("blocks/locked_blue_dungeon_door_bottom"));
		    
		});
    }

	
}
