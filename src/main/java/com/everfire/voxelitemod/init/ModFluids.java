package com.everfire.voxelitemod.init;

import com.everfire.voxelitemod.block.VoxeliteFluidBlock;
import com.everfire.voxelitemod.fluid.VoxeliteFluid;
import com.everfire.voxelitemod.init.ModItemGroup;
import com.everfire.voxelitemod.utils.VoxeliteUtils;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;

public class ModFluids {

	public static FlowableFluid STILL_VOXELITE_FLUID;
	public static FlowableFluid FLOWING_VOXELITE_FLUID;
	public static Block VOXELITE_FLUID_BLOCK;
	public static Item VOXELITE_BUCKET;
	
	public static void register() {
		STILL_VOXELITE_FLUID = Registry.register(Registry.FLUID, VoxeliteUtils.identifier("liquid_voxelite_still"), new VoxeliteFluid.Still());
		FLOWING_VOXELITE_FLUID = Registry.register(Registry.FLUID, VoxeliteUtils.identifier("liquid_voxelite_flow"), new VoxeliteFluid.Flowing());
		VOXELITE_FLUID_BLOCK = Registry.register(Registry.BLOCK, VoxeliteUtils.identifier("liquid_voxelite"), new VoxeliteFluidBlock(STILL_VOXELITE_FLUID,FabricBlockSettings.copyOf(Blocks.WATER)));
		VOXELITE_BUCKET = Registry.register(Registry.ITEM, VoxeliteUtils.identifier("emerald_bucket_voxelite"), new BucketItem(STILL_VOXELITE_FLUID,new FabricItemSettings().group(ModItemGroup.VOXELITE_ITEM_GROUP).recipeRemainder(Items.BUCKET).maxCount(1)));
	}
	
	
}
