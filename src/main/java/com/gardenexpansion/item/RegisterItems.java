package com.gardenexpansion.item;

import com.gardenexpansion.Gardenexpansion;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.item.Item;

public class RegisterItems implements ItemRegistryContainer {
    public static final Item COW_MANURE = new CowManureItem();
    public static final Item OAK_BARK = new OakBarkItem();
    public static final Item SHIT_INGOT = new Item(new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
    public static final Item PRUNER_ITEM = new PrunerItem();
/*
    public Item createItem(Item item, String Identifier) {
        return new Item(new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
    }

 */
}

