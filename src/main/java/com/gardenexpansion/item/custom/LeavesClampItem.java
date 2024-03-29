package com.gardenexpansion.item.custom;

import com.gardenexpansion.Gardenexpansion;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.minecraft.item.Item;

public class LeavesClampItem extends Item {

    static OwoItemSettings itemSettings = new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP).maxCount(64);

    public LeavesClampItem(){
        super(itemSettings);
    }
}
