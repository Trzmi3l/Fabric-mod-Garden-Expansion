package com.gardenexpansion.item.custom;

import com.gardenexpansion.Gardenexpansion;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
@Deprecated
public class GrassLeggings extends Item {

    static FabricItemSettings ItemSettings = new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP);
    public GrassLeggings(ArmorMaterial material, ArmorItem.Type type, Item.Settings settings){
        super(ItemSettings);
    }
}
