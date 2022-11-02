package com.everfire.voxelitemod.datagen;

import com.everfire.voxelitemod.VoxeliteMod;
import com.everfire.voxelitemod.block.LockableDoorBlock;
import com.everfire.voxelitemod.init.ModBlocks;

import com.everfire.voxelitemod.init.ModModels;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;

public class VoxeliteModDataGenEntryPoint implements DataGeneratorEntrypoint {

    class VoxeliteModData extends FabricModelProvider {

        private VoxeliteModData(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            registerDoor(blockStateModelGenerator,ModBlocks.BLACKSTONEDOOR);
            //blockStateModelGenerator.registerDoor(ModBlocks.BLACKSTONEDOORLOCKED);
            registerDoor(blockStateModelGenerator,ModBlocks.BLUE_DUNGEON_DOOR);
            //blockStateModelGenerator.registerDoor(ModBlocks.BLUE_DUNGEON_DOOR_LOCKED);
        }

		public static TextureMap topBottomLocked(Block block) {
			return (new TextureMap()).put(TextureKey.TOP, TextureMap.getSubId(block, "_top_locked")).put(TextureKey.BOTTOM, TextureMap.getSubId(block, "_bottom_locked"));
		}

        private void registerDoor(BlockStateModelGenerator blockStateModelGenerator, Block doorBlock) {
            TextureMap textureMap = TextureMap.topBottom(doorBlock);
            Identifier identifier = Models.DOOR_BOTTOM_LEFT.upload(doorBlock, textureMap, blockStateModelGenerator.modelCollector);
            Identifier identifier2 = Models.DOOR_BOTTOM_LEFT_OPEN.upload(doorBlock, textureMap, blockStateModelGenerator.modelCollector);
            Identifier identifier3 = Models.DOOR_BOTTOM_RIGHT.upload(doorBlock, textureMap, blockStateModelGenerator.modelCollector);
            Identifier identifier4 = Models.DOOR_BOTTOM_RIGHT_OPEN.upload(doorBlock, textureMap, blockStateModelGenerator.modelCollector);
            Identifier identifier5 = Models.DOOR_TOP_LEFT.upload(doorBlock, textureMap, blockStateModelGenerator.modelCollector);
            Identifier identifier6 = Models.DOOR_TOP_LEFT_OPEN.upload(doorBlock, textureMap, blockStateModelGenerator.modelCollector);
            Identifier identifier7 = Models.DOOR_TOP_RIGHT.upload(doorBlock, textureMap, blockStateModelGenerator.modelCollector);
            Identifier identifier8 = Models.DOOR_TOP_RIGHT_OPEN.upload(doorBlock, textureMap, blockStateModelGenerator.modelCollector);
			TextureMap textureMap2 = topBottomLocked(doorBlock);
			Identifier identifier9 = ModModels.DOOR_BOTTOM_LEFT_LOCKED.upload(doorBlock, textureMap2, blockStateModelGenerator.modelCollector);
			Identifier identifier10 = ModModels.DOOR_BOTTOM_LEFT_OPEN_LOCKED.upload(doorBlock, textureMap2, blockStateModelGenerator.modelCollector);
			Identifier identifier11 = ModModels.DOOR_BOTTOM_RIGHT_LOCKED.upload(doorBlock, textureMap2, blockStateModelGenerator.modelCollector);
			Identifier identifier12 = ModModels.DOOR_BOTTOM_RIGHT_OPEN_LOCKED.upload(doorBlock, textureMap2, blockStateModelGenerator.modelCollector);
			Identifier identifier13 = ModModels.DOOR_TOP_LEFT_LOCKED.upload(doorBlock, textureMap2, blockStateModelGenerator.modelCollector);
			Identifier identifier14 = ModModels.DOOR_TOP_LEFT_OPEN_LOCKED.upload(doorBlock, textureMap2, blockStateModelGenerator.modelCollector);
			Identifier identifier15 = ModModels.DOOR_TOP_RIGHT_LOCKED.upload(doorBlock, textureMap2, blockStateModelGenerator.modelCollector);
			Identifier identifier16 = ModModels.DOOR_TOP_RIGHT_OPEN_LOCKED.upload(doorBlock, textureMap2, blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.registerItemModel(doorBlock.asItem());

            blockStateModelGenerator.blockStateCollector.accept(createDoorBlockState(doorBlock, identifier, identifier2, identifier3, identifier4, identifier5, identifier6, identifier7, identifier8,identifier9,identifier10,identifier11,identifier12,identifier13,identifier14,identifier15,identifier16));
        }

        public static BlockStateSupplier createDoorBlockState(Block doorBlock, Identifier bottomModelId, Identifier bottomHingeModelId, Identifier identifier, Identifier identifier2, Identifier identifier3, Identifier identifier4, Identifier identifier5, Identifier identifier6,Identifier identifier7,Identifier identifier8,Identifier identifier9,Identifier identifier10,Identifier identifier11,Identifier identifier12,Identifier identifier13,Identifier identifier14) {
            return VariantsBlockStateSupplier
                    .create(doorBlock)
                    .coordinate(fillDoorVariantMap(fillDoorVariantMap(BlockStateVariantMap
                                                            .create(Properties.HORIZONTAL_FACING,
                                                                    Properties.DOUBLE_BLOCK_HALF,
                                                                    Properties.DOOR_HINGE,
                                                                    Properties.OPEN,
                                                                    LockableDoorBlock.LOCKED),
                                                    DoubleBlockHalf.LOWER,
                                                    bottomModelId,
                                                    bottomHingeModelId,
                                                    identifier,
                                                    identifier2,
													identifier7,
													identifier8,
													identifier9,
													identifier10),
                                    DoubleBlockHalf.UPPER,
                                    identifier3,
                                    identifier4,
                                    identifier5,
                                    identifier6,
									identifier11,
									identifier12,
									identifier13,
									identifier14));
        }

        public static BlockStateVariantMap.QuintupleProperty<Direction, DoubleBlockHalf, DoorHinge, Boolean, Boolean> fillDoorVariantMap(BlockStateVariantMap.QuintupleProperty<Direction, DoubleBlockHalf, DoorHinge, Boolean, Boolean> variantMap, DoubleBlockHalf targetHalf, Identifier identifier, Identifier identifier2, Identifier identifier3, Identifier identifier4,Identifier identifier5,Identifier identifier6,Identifier identifier7,Identifier identifier8) {
            return variantMap.register(Direction.EAST,
                    targetHalf,
                    DoorHinge.LEFT,
                    false,
                    false,
                    BlockStateVariant.create().put(VariantSettings.MODEL,
                            identifier)).register(Direction.SOUTH, targetHalf,
                    DoorHinge.LEFT,
                    false,
                    false,
                    BlockStateVariant.create().put(VariantSettings.MODEL,
                            identifier).put(VariantSettings.Y,
                            VariantSettings.Rotation.R90)).register(Direction.WEST,
                    targetHalf,
                    DoorHinge.LEFT,
                    false,
                    false,
                    BlockStateVariant.create().put(VariantSettings.MODEL,
                            identifier).put(VariantSettings.Y,
                            VariantSettings.Rotation.R180)).register(Direction.NORTH,
                    targetHalf,
                    DoorHinge.LEFT,
                    false,
                    false,
                    BlockStateVariant.create().put(VariantSettings.MODEL,
                            identifier).put(VariantSettings.Y,
                            VariantSettings.Rotation.R270)).register(Direction.EAST,
                    targetHalf,
					DoorHinge.RIGHT,
                    false,
                    false,
					BlockStateVariant.create().put(VariantSettings.MODEL,
                            identifier3)).register(Direction.SOUTH,
                    targetHalf,
					DoorHinge.RIGHT,
                    false,
                    false,
                    BlockStateVariant.create().put(VariantSettings.MODEL,
                            identifier3).put(VariantSettings.Y,
                            VariantSettings.Rotation.R90)).register(Direction.WEST,
                    targetHalf,
					DoorHinge.RIGHT,
					false,
                    false,
                    BlockStateVariant.create().put(VariantSettings.MODEL,
                            identifier3).put(VariantSettings.Y,
                            VariantSettings.Rotation.R180)).register(Direction.NORTH,
					targetHalf,
					DoorHinge.RIGHT,
					false,
                    false,
					BlockStateVariant.create().put(VariantSettings.MODEL,
							identifier3).put(VariantSettings.Y,
							VariantSettings.Rotation.R270)).register(Direction.EAST,
					targetHalf,
					DoorHinge.LEFT,
					true,
                    false,
					BlockStateVariant.create().put(VariantSettings.MODEL,
							identifier2).put(VariantSettings.Y,
							VariantSettings.Rotation.R90)).register(Direction.SOUTH,
					targetHalf,
					DoorHinge.LEFT,
					true,
                    false,
					BlockStateVariant.create().put(VariantSettings.MODEL,
							identifier2).put(VariantSettings.Y,
							VariantSettings.Rotation.R180)).register(Direction.WEST,
					targetHalf,
					DoorHinge.LEFT,
					true,
                    false,
					BlockStateVariant.create().put(VariantSettings.MODEL,
							identifier2).put(VariantSettings.Y,
							VariantSettings.Rotation.R270)).register(Direction.NORTH,
					targetHalf,
					DoorHinge.LEFT,
					true,
                    false,
					BlockStateVariant.create().put(VariantSettings.MODEL,
							identifier2)).register(Direction.EAST,
					targetHalf,
					DoorHinge.RIGHT,
					true,
                    false,
					BlockStateVariant.create().put(VariantSettings.MODEL,
							identifier4).put(VariantSettings.Y,
							VariantSettings.Rotation.R270)).register(Direction.SOUTH,
					targetHalf,
					DoorHinge.RIGHT,
					true,
                    false,
					BlockStateVariant.create().put(VariantSettings.MODEL,
							identifier4)).register(Direction.WEST,
					targetHalf,
					DoorHinge.RIGHT,
					true,
                    false,
					BlockStateVariant.create().put(VariantSettings.MODEL,
							identifier4).put(VariantSettings.Y,
							VariantSettings.Rotation.R90)).register(Direction.NORTH,
					targetHalf,
					DoorHinge.RIGHT,
					true,
                    false,
					BlockStateVariant.create().put(VariantSettings.MODEL,
							identifier4).put(VariantSettings.Y,
							VariantSettings.Rotation.R180))






                    .register(Direction.EAST,
                            targetHalf,
                            DoorHinge.LEFT,
                            false,
                            true,
                            BlockStateVariant.create().put(VariantSettings.MODEL,
                                    identifier5)).register(Direction.SOUTH, targetHalf,
                            DoorHinge.LEFT,
                            false,
                            true,
                            BlockStateVariant.create().put(VariantSettings.MODEL,
                                    identifier5).put(VariantSettings.Y,
                                    VariantSettings.Rotation.R90)).register(Direction.WEST,
                            targetHalf,
                            DoorHinge.LEFT,
                            false,
                            true,
                            BlockStateVariant.create().put(VariantSettings.MODEL,
                                    identifier5).put(VariantSettings.Y,
                                    VariantSettings.Rotation.R180)).register(Direction.NORTH,
                            targetHalf,
                            DoorHinge.LEFT,
                            false,
                            true,
                            BlockStateVariant.create().put(VariantSettings.MODEL,
                                    identifier5).put(VariantSettings.Y,
                                    VariantSettings.Rotation.R270)).register(Direction.EAST,
                            targetHalf,
                            DoorHinge.RIGHT,
                            false,
                            true,
                            BlockStateVariant.create().put(VariantSettings.MODEL,
                                    identifier7)).register(Direction.SOUTH,
                            targetHalf,
                            DoorHinge.RIGHT,
                            false,
                            true,
                            BlockStateVariant.create().put(VariantSettings.MODEL,
                                    identifier7).put(VariantSettings.Y,
                                    VariantSettings.Rotation.R90)).register(Direction.WEST,
                            targetHalf,
                            DoorHinge.RIGHT,
                            false,
                            true,
                            BlockStateVariant.create().put(VariantSettings.MODEL,
                                    identifier7).put(VariantSettings.Y,
                                    VariantSettings.Rotation.R180)).register(Direction.NORTH,
                            targetHalf,
                            DoorHinge.RIGHT,
                            false,
                            true,
                            BlockStateVariant.create().put(VariantSettings.MODEL,
                                    identifier7).put(VariantSettings.Y,
                                    VariantSettings.Rotation.R270)).register(Direction.EAST,
                            targetHalf,
                            DoorHinge.LEFT,
                            true,
                            true,
                            BlockStateVariant.create().put(VariantSettings.MODEL,
                                    identifier6).put(VariantSettings.Y,
                                    VariantSettings.Rotation.R90)).register(Direction.SOUTH,
                            targetHalf,
                            DoorHinge.LEFT,
                            true,
                            true,
                            BlockStateVariant.create().put(VariantSettings.MODEL,
                                    identifier6).put(VariantSettings.Y,
                                    VariantSettings.Rotation.R180)).register(Direction.WEST,
                            targetHalf,
                            DoorHinge.LEFT,
                            true,
                            true,
                            BlockStateVariant.create().put(VariantSettings.MODEL,
                                    identifier6).put(VariantSettings.Y,
                                    VariantSettings.Rotation.R270)).register(Direction.NORTH,
                            targetHalf,
                            DoorHinge.LEFT,
                            true,
                            true,
                            BlockStateVariant.create().put(VariantSettings.MODEL,
                                    identifier6)).register(Direction.EAST,
                            targetHalf,
                            DoorHinge.RIGHT,
                            true,
                            true,
                            BlockStateVariant.create().put(VariantSettings.MODEL,
                                    identifier8).put(VariantSettings.Y,
                                    VariantSettings.Rotation.R270)).register(Direction.SOUTH,
                            targetHalf,
                            DoorHinge.RIGHT,
                            true,
                            true,
                            BlockStateVariant.create().put(VariantSettings.MODEL,
                                    identifier8)).register(Direction.WEST,
                            targetHalf,
                            DoorHinge.RIGHT,
                            true,
                            true,
                            BlockStateVariant.create().put(VariantSettings.MODEL,
                                    identifier8).put(VariantSettings.Y,
                                    VariantSettings.Rotation.R90)).register(Direction.NORTH,
                            targetHalf,
                            DoorHinge.RIGHT,
                            true,
                            true,
                            BlockStateVariant.create().put(VariantSettings.MODEL,
                                    identifier8).put(VariantSettings.Y,
                                    VariantSettings.Rotation.R180))

                    ;
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

