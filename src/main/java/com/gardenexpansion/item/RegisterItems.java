package com.gardenexpansion.item;

import com.gardenexpansion.Gardenexpansion;
import com.gardenexpansion.item.Materials.ArmorMaterials;
import com.gardenexpansion.item.custom.*;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class RegisterItems implements ItemRegistryContainer {
    public static final Item COW_MANURE = new CowManureItem();
    public static final Item OAK_BARK = new OakBarkItem();
    public static final Item SHIT_INGOT = new Item(new OwoItemSettings());
    public static final Item PRUNER = new PrunerItem(); //rzytnia bezglutenowa
    public static final Item LEAVES_CLAMP = new LeavesClampItem();
    public static final Item GRASS_HELMET = new GrassArmorItem(ArmorMaterials.GRASS, ArmorItem.Type.HELMET, new OwoItemSettings().group(Gardenexpansion.GRASS_ARMOR_GROUP));
    public static final Item GRASS_CHESTPLATE = new GrassArmorItem(ArmorMaterials.GRASS, ArmorItem.Type.CHESTPLATE, new OwoItemSettings().group(Gardenexpansion.GRASS_ARMOR_GROUP));
    public static final Item GRASS_LEGGINGS = new GrassArmorItem(ArmorMaterials.GRASS, ArmorItem.Type.LEGGINGS, new OwoItemSettings().group(Gardenexpansion.GRASS_ARMOR_GROUP));
    public static final Item GRASS_BOOTS = new GrassArmorItem(ArmorMaterials.GRASS, ArmorItem.Type.BOOTS, new OwoItemSettings().group(Gardenexpansion.GRASS_ARMOR_GROUP));




}

