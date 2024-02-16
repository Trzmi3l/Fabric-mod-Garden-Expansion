package com.gardenexpansion.block;

import io.wispforest.owo.registration.annotations.AssignedName;
import io.wispforest.owo.registration.reflect.BlockRegistryContainer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;



public class BlockReg implements BlockRegistryContainer {

    @AssignedName("water_collector")
    public static final Block WATER_COLLECTOR = new WaterCollectorBlock();
   // public static final Block BARK_BLOCK = new BarkBlock();

    @Override
    public BlockItem createBlockItem(Block block, String identifier) {
        return BlockRegistryContainer.super.createBlockItem(block, identifier);

    }
}
