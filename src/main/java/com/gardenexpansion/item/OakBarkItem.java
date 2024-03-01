package com.gardenexpansion.item;

import com.gardenexpansion.Gardenexpansion;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
public class OakBarkItem extends Item {

    static FabricItemSettings ItemSettings = new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP);
    public OakBarkItem(){
        super(ItemSettings);
    }
}
