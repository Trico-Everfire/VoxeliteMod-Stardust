package com.everfire.voxelitemod.init;

import com.everfire.voxelitemod.VoxeliteMod;
import com.everfire.voxelitemod.block.LockableDoorBlock;
import com.everfire.voxelitemod.block.StardustGrowthBlock;

import com.everfire.voxelitemod.item.LockableDoorBlockItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
	
	public static final Block BLEACHED_BLOCK = registerBlock("bleached_block", new Block( FabricBlockSettings.of(Material.STONE)),ModItemGroup.VOXELITE_Block_GROUP);
	public static final Block AVOKINATE_BLOCK = registerBlock("avokinate_block", new Block(FabricBlockSettings.of(Material.STONE)),ModItemGroup.VOXELITE_Block_GROUP);
	public static final Block VOXELIZED_STONE = registerBlock("voxelized_stone", new Block(FabricBlockSettings.of(Material.GLASS)),ModItemGroup.VOXELITE_Block_GROUP);
	public static final Block STARDUSTGROWTH = registerBlock("stardust_growth", new StardustGrowthBlock(FabricBlockSettings.of(Material.GLASS)),ModItemGroup.VOXELITE_Block_GROUP);
	public static final DoorBlock BLACKSTONEDOOR = (LockableDoorBlock) registerDoorBlock("black_stone_door", new LockableDoorBlock(FabricBlockSettings.of(Material.METAL).resistance(6).hardness(6), ModItems.BLACK_STONE_DUNGEON_KEY), ModItemGroup.VOXELITE_Block_GROUP);
	public static final DoorBlock BLUE_DUNGEON_DOOR = (LockableDoorBlock) registerDoorBlock("blue_dungeon_door", new LockableDoorBlock(FabricBlockSettings.of(Material.METAL).resistance(6).hardness(6), ModItems.BLUE_DUNGEON_KEY), ModItemGroup.VOXELITE_Block_GROUP);

	/*
	public static  final RegistryObject<Block> BLACKSTONEDOOR =  DEFERREDBLOCKS.register("black_stone_door", ()-> new BlockDoorBase(Material.ROCK,null,null,true,false));
	public static  final RegistryObject<Block> BLACKSTONEDOORLOCKED =  DEFERREDBLOCKS.register("black_stone_door_locked", ()-> new BlockDoorBase(Material.ROCK,ModItems.BLACK_STONE_DUNGEON_KEY,BLACKSTONEDOOR,false,true));
	public static  final RegistryObject<Block> BLUE_DUNGEON_DOOR =  DEFERREDBLOCKS.register("blue_dungeon_door", ()-> new BlockDoorBase(Material.ROCK,null,null,true,false));
	public static  final RegistryObject<Block> BLUE_DUNGEON_DOOR_LOCKED =  DEFERREDBLOCKS.register("blue_dungeon_door_locked", ()-> new BlockDoorBase(Material.ROCK,ModItems.BLUE_DUNGEON_KEY,BLUE_DUNGEON_DOOR,false,true));
	 */
	
	
	private static Block registerBlock(String name, Block block, ItemGroup tab) {
		registerBlockItem(name, block, tab);
		return Registry.register(Registry.BLOCK, new Identifier(VoxeliteMod.MOD_ID, name), block);
	}
	
	private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
		return Registry.register(Registry.ITEM, new Identifier(VoxeliteMod.MOD_ID, name), new BlockItem(block, ModItems.SETTINGS.group(tab)));
	}

	private static Block registerDoorBlock(String name, Block block, ItemGroup tab) {

		registerDoorBlockItem(name, block, tab, false);
		registerDoorBlockItem(name + "_locked", block, tab, true);
		return Registry.register(Registry.BLOCK, new Identifier(VoxeliteMod.MOD_ID, name), block);
	}

	private static LockableDoorBlockItem registerDoorBlockItem(String name, Block block, ItemGroup tab, boolean locked) {
		return Registry.register(Registry.ITEM, new Identifier(VoxeliteMod.MOD_ID, name), new LockableDoorBlockItem(block, ModItems.SETTINGS.group(tab),locked));
	}

	public static void registerModBlocks() {
		VoxeliteMod.LOGGER.debug("Registering Voxelite Blocks");
	}
	
}
