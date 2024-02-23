package com.gardenexpansion.block;

import com.gardenexpansion.Gardenexpansion;
<<<<<<< HEAD
=======
import io.wispforest.owo.itemgroup.OwoItemSettings;
>>>>>>> origin/Master
import io.wispforest.owo.registration.annotations.AssignedName;
import io.wispforest.owo.registration.reflect.BlockRegistryContainer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;


public class BlockReg implements BlockRegistryContainer {

    @AssignedName("water_collector")
    public static final Block WATER_COLLECTOR = new WaterCollectorBlock();
    public static final Block BARK_BLOCK = new BarkBlock();


    @Override
    public BlockItem createBlockItem(Block block, String identifier) {
<<<<<<< HEAD
        return new BlockItem(block, new owo().group(Gardenexpansion.ITEM_GROUP));
=======
        return new BlockItem(block, new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
>>>>>>> origin/Master
    }

}
