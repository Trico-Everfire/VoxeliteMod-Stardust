package com.everfire.voxelitemod.utils;

import com.everfire.voxelitemod.VoxeliteMod;

import net.minecraft.util.Identifier;

public class VoxeliteUtils {

	public static Identifier identifier(String name) {
		return new Identifier(VoxeliteMod.MOD_ID,name);
	}
	
	
}
