package com.gardenexpansion.blockEntities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class WaterCollectorEntity extends BlockEntity {
    public WaterCollectorEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegister.WATER_COLLECTOR_BLOCK_ENITY, pos, state);
    }



}
