package com.gardenexpansion.block;

import com.gardenexpansion.Gardenexpansion;
import com.gardenexpansion.block.custom.BarkBlock;
import com.gardenexpansion.block.custom.CrossFence;
import com.gardenexpansion.block.custom.MapleBlockStack;
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

    // MAPLE GOWNO
    public static final Block MAPLE_LOG = new MapleBlockStack.MapleLog();

    public static final Block MAPLE_STRIPPED_LOG = new MapleBlockStack.MapleStrippedLog();

    public static final Block MAPLE_WOOD = new MapleBlockStack.MapleWood();

    public static final Block MAPLE_STRIPPED_WOOD = new MapleBlockStack.MapleStrippedWood();

    public static final Block MAPLE_PLANKS = new MapleBlockStack.MaplePlanks();

    public static final Block MAPLE_LEAVES = new MapleBlockStack.MapleLeaves();


    @Override
    public BlockItem createBlockItem(Block block, String identifier) {

        return new BlockItem(block, new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
    }
}
