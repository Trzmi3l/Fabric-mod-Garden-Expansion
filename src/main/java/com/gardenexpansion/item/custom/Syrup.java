package com.gardenexpansion.item.custom;

import com.gardenexpansion.Gardenexpansion;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.minecraft.item.Item;

public class Syrup extends Item {

    static OwoItemSettings s = new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP);

    public Syrup() {
        super(s);
    }



}
