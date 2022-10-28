package com.everfire.voxelitemod.item;

import com.everfire.voxelitemod.VoxeliteMod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
	
	public static final FabricItemSettings SETTINGS = new FabricItemSettings().group(ModItemGroup.VOXELITE_ITEM_GROUP);
	
	public static final Item PHASER_CRYSTAL = registerItem("phaser_crystal", new Item(SETTINGS));
	public static final Item AVOKINATE_CRYSTAL = registerItem("avokinate_crystal", new Item(SETTINGS));
	public static final Item CHARGED_AVOKINATE_CRYSTAL = registerItem("charged_avokinate_crystal", new Item(SETTINGS));
	
	private static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(VoxeliteMod.MOD_ID, name), item);
	}
	
	public static void registerModItems() {
		VoxeliteMod.LOGGER.debug("Registering Voxelite Items");
	}

}
