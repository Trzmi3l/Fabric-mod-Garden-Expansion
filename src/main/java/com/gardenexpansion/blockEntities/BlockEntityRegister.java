package com.gardenexpansion.blockEntities;

import com.gardenexpansion.block.RegisterBlocks;
import io.wispforest.owo.registration.reflect.AutoRegistryContainer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.stream.Stream;

public class BlockEntityRegister implements AutoRegistryContainer<BlockEntityType<?>> {

    public static BlockEntityType<WaterCollectorEntity> WATER_COLLECTOR_BLOCK_ENITY = FabricBlockEntityTypeBuilder.create(WaterCollectorEntity::new, RegisterBlocks.WATER_COLLECTOR).build();


    @Override
    public Registry<BlockEntityType<?>> getRegistry() {
        return (Registry<BlockEntityType<?>>) Registries.BLOCK_ENTITY_TYPE;

    }

    @Override
    public Class<BlockEntityType<?>> getTargetFieldType() {
        return (Class<BlockEntityType<?>>) (Object) BlockEntityType.class;
    }
}
