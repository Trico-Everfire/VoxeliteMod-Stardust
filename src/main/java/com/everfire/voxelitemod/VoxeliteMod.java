package com.everfire.voxelitemod;

import net.minecraft.block.Blocks;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.everfire.voxelitemod.init.ModBlocks;
import com.everfire.voxelitemod.init.ModFluids;
import com.everfire.voxelitemod.init.ModItems;

import net.fabricmc.api.ModInitializer;

public class VoxeliteMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "voxelitemod";
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Blocks.ACACIA_LEAVES.asItem().getGroup();
		LOGGER.info("Hello Fabric world!");
		
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		
		ModFluids.register();
	}
	
}
