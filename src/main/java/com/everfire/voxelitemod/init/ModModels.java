package com.everfire.voxelitemod.init;

import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModels {

    public static final Model DOOR_BOTTOM_LEFT_LOCKED;
    public static final Model DOOR_BOTTOM_LEFT_OPEN_LOCKED;
    public static final Model DOOR_BOTTOM_RIGHT_LOCKED;
    public static final Model DOOR_BOTTOM_RIGHT_OPEN_LOCKED;
    public static final Model DOOR_TOP_LEFT_LOCKED;
    public static final Model DOOR_TOP_LEFT_OPEN_LOCKED;
    public static final Model DOOR_TOP_RIGHT_LOCKED;
    public static final Model DOOR_TOP_RIGHT_OPEN_LOCKED;

    private static Model make(TextureKey... requiredTextureKeys) {
        return new Model(Optional.empty(), Optional.empty(), requiredTextureKeys);
    }

    private static Model block(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier("minecraft", "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model item(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier("minecraft", "item/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model block(String parent, String variant, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier("minecraft", "block/" + parent)), Optional.of(variant), requiredTextureKeys);
    }

    static{
        DOOR_BOTTOM_LEFT_LOCKED = block("door_bottom_left", "_bottom_left_locked", TextureKey.TOP, TextureKey.BOTTOM);
        DOOR_BOTTOM_LEFT_OPEN_LOCKED = block("door_bottom_left_open", "_bottom_left_open_locked", TextureKey.TOP, TextureKey.BOTTOM);
        DOOR_BOTTOM_RIGHT_LOCKED = block("door_bottom_right", "_bottom_right_locked", TextureKey.TOP, TextureKey.BOTTOM);
        DOOR_BOTTOM_RIGHT_OPEN_LOCKED = block("door_bottom_right_open", "_bottom_right_open_locked", TextureKey.TOP, TextureKey.BOTTOM);
        DOOR_TOP_LEFT_LOCKED = block("door_top_left", "_top_left_locked", TextureKey.TOP, TextureKey.BOTTOM);
        DOOR_TOP_LEFT_OPEN_LOCKED = block("door_top_left_open", "_top_left_open_locked", TextureKey.TOP, TextureKey.BOTTOM);
        DOOR_TOP_RIGHT_LOCKED = block("door_top_right", "_top_right_locked", TextureKey.TOP, TextureKey.BOTTOM);
        DOOR_TOP_RIGHT_OPEN_LOCKED = block("door_top_right_open", "_top_right_open_locked", TextureKey.TOP, TextureKey.BOTTOM);

    }
}
