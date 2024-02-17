package com.gardenexpansion.item;

import com.gardenexpansion.Gardenexpansion;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
public class OakBarkItem extends Item {
    public static final String OAK_BARK = "oak_bark";

    static FabricItemSettings ItemSettings = new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP);
    public OakBarkItem(){
        super(ItemSettings);
    }
}
