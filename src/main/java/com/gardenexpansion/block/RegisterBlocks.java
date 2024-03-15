package com.gardenexpansion.block;

import com.gardenexpansion.Gardenexpansion;
import com.gardenexpansion.block.custom.BarkBlock;
import com.gardenexpansion.block.custom.CrossFence;
import com.gardenexpansion.block.custom.WaterCollectorBlock;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.registration.reflect.BlockRegistryContainer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;


public class RegisterBlocks implements BlockRegistryContainer {


    //public static final Block WATER_COLLECTOR = new WaterCollectorBlockOld();
    //public static final BlockEntity WATER_COLLECTOR = new WaterCollectorBlockEntity();

    public static final Block WATER_COLLECTOR = new WaterCollectorBlock();

    public static final Block BARK_BLOCK = new BarkBlock();

    public static final Block CROSS_FENCE = new CrossFence();


    @Override
    public BlockItem createBlockItem(Block block, String identifier) {

        return new BlockItem(block, new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
    }
}
