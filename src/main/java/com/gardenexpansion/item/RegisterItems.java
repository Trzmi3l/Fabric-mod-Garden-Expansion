package com.gardenexpansion.item;

import com.gardenexpansion.item.custom.CowManureItem;
import com.gardenexpansion.item.custom.LeavesClampItem;
import com.gardenexpansion.item.custom.OakBarkItem;
import com.gardenexpansion.item.custom.PrunerItem;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.item.Item;

public class RegisterItems implements ItemRegistryContainer {
    public static final Item COW_MANURE = new CowManureItem();
    public static final Item OAK_BARK = new OakBarkItem();
    public static final Item SHIT_INGOT = new Item(new OwoItemSettings());
    public static final Item PRUNER = new PrunerItem(); //rzytnia bezglutenowa
    public static final Item LEAVES_CLAMP = new LeavesClampItem();

/*
    public Item createItem(Item item, String Identifier) {
        return new Item(new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
    }

 */
}

