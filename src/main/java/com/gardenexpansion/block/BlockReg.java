package com.gardenexpansion.block;

import com.gardenexpansion.Gardenexpansion;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import io.wispforest.owo.itemgroup.OwoItemSettings;
>>>>>>> origin/Master
=======
import io.wispforest.owo.itemgroup.OwoItemSettings;
=======
>>>>>>> 69565127642a99a6d86003b1dabc5a2492199122
import io.wispforest.owo.registration.annotations.AssignedName;
>>>>>>> origin/pylo_majkraft_odnoga
import io.wispforest.owo.registration.reflect.BlockRegistryContainer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
<<<<<<< HEAD
=======

>>>>>>> origin/pylo_majkraft_odnoga

public class BlockReg implements BlockRegistryContainer {

    @AssignedName("water_collector")
    public static final Block WATER_COLLECTOR = new WaterCollectorBlock();
    public static final Block BARK_BLOCK = new BarkBlock();


    @Override
    public BlockItem createBlockItem(Block block, String identifier) {
<<<<<<< HEAD
<<<<<<< HEAD
        return new BlockItem(block, new owo().group(Gardenexpansion.ITEM_GROUP));
=======
        return new BlockItem(block, new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
>>>>>>> origin/Master
=======
        return new BlockItem(block, new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
=======
        return new BlockItem(block, new owo().group(Gardenexpansion.ITEM_GROUP));
>>>>>>> origin/pylo_majkraft_odnoga
>>>>>>> 69565127642a99a6d86003b1dabc5a2492199122
    }

}
