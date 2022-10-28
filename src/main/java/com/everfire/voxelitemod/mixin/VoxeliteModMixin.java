package com.everfire.voxelitemod.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.everfire.voxelitemod.VoxeliteMod;

@Mixin(TitleScreen.class)
public class VoxeliteModMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		VoxeliteMod.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
