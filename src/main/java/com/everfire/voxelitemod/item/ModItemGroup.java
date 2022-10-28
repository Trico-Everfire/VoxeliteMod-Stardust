package com.everfire.voxelitemod.item;

import com.everfire.voxelitemod.VoxeliteMod;
import com.everfire.voxelitemod.block.ModBlocks;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
	public static final ItemGroup VOXELITE_ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(VoxeliteMod.MOD_ID, "voxelitemod_items"), ()-> new ItemStack(ModItems.AVOKINATE_CRYSTAL));
	public static final ItemGroup VOXELITE_Block_GROUP = FabricItemGroupBuilder.build(
			new Identifier(VoxeliteMod.MOD_ID, "voxelitemod_blocks"), ()-> new ItemStack(ModBlocks.AVOKINATE_BLOCK));
	public static final ItemGroup VOXELITE_FOOD_GROUP = FabricItemGroupBuilder.build(
			new Identifier(VoxeliteMod.MOD_ID, "voxelitemod_foods"), ()-> new ItemStack(ModItems.AVOKINATE_CRYSTAL));
}
