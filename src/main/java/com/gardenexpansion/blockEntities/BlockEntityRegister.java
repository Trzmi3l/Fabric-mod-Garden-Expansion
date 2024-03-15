package com.gardenexpansion.blockEntities;

import com.gardenexpansion.block.RegisterBlocks;

import io.wispforest.owo.registration.reflect.AutoRegistryContainer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BlockEntityRegister implements AutoRegistryContainer<BlockEntityType<?>> {

    public static BlockEntityType<WaterCollectorEntity> WATER_COLLECTOR_BLOCK_ENITY = FabricBlockEntityTypeBuilder.create(WaterCollectorEntity::new, RegisterBlocks.WATER_COLLECTOR).build();


    @Override
    public Registry<BlockEntityType<?>> getRegistry() {
        return (Registry<BlockEntityType<?>>) Registries.BLOCK_ENTITY_TYPE;

    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<BlockEntityType<?>> getTargetFieldType() {
        return (Class<BlockEntityType<?>>) (Object) BlockEntityType.class;
    }
}
