package com.gardenexpansion.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import com.gardenexpansion.Gardenexpansion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //public static final Item COW_MANURE = registerItem("cow_manure", new Item(new FabricItemSettings()));




    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
      //  entries.add(COW_MANURE);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Gardenexpansion.MOD_ID, name), item);
    }

    public static void registerModItems(){
        //Gardenexpansion.LOGGER.info("Registering Items for: " + Gardenexpansion.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemsToIngredientItemGroup);
    }
}
