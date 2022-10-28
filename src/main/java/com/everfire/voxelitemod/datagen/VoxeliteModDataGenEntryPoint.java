package com.everfire.voxelitemod.datagen;

import com.everfire.voxelitemod.block.ModBlocks;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class VoxeliteModDataGenEntryPoint implements DataGeneratorEntrypoint {

	class VoxeliteModData extends FabricModelProvider {
		
		private VoxeliteModData(FabricDataGenerator dataGenerator) {
			super(dataGenerator);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
			// TODO Auto-generated method stub
			blockStateModelGenerator.registerDoor(ModBlocks.BLACKSTONEDOOR);
			blockStateModelGenerator.registerDoor(ModBlocks.BLACKSTONEDOORLOCKED);
			blockStateModelGenerator.registerDoor(ModBlocks.BLUE_DUNGEON_DOOR);
			blockStateModelGenerator.registerDoor(ModBlocks.BLUE_DUNGEON_DOOR_LOCKED);
			
		}
		
		@Override
		public void generateItemModels(ItemModelGenerator itemModelGenerator) {
			// TODO Auto-generated method stub
			
		}

	}

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		// TODO Auto-generated method stub
		fabricDataGenerator.addProvider(VoxeliteModData::new);
	}

}

