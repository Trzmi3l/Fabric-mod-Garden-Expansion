package com.gardenexpansion.item;

import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.item.Item;

public class RegisterItems implements ItemRegistryContainer {
    public static final Item COW_MANURE = new CowManureItem();
    public static final Item OAK_BARK = new OakBarkItem();
/*
    public Item createItem(Item item, String Identifier) {
        return new Item(new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
    }

 */
}

