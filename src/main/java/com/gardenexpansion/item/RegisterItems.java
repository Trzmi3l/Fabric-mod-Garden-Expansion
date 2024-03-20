package com.gardenexpansion.item;

import com.gardenexpansion.Gardenexpansion;
import com.gardenexpansion.item.custom.*;
import com.gardenexpansion.item.custom.grassitems.*;
import com.gardenexpansion.item.materials.ArmorMaterials;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class RegisterItems implements ItemRegistryContainer  {
    public static final Item COW_MANURE = new CowManureItem();
    public static final Item OAK_BARK = new OakBarkItem();
    public static final Item SHIT_INGOT = new Item(new OwoItemSettings());
    public static final Item PRUNER = new PrunerItem(); //rzytnia bezglutenowa
    public static final Item LEAVES_CLAMP = new LeavesClampItem();
    public static final Item GRASS_HELMET = new GrassHelmetItem(ArmorMaterials.GRASS, ArmorItem.Type.HELMET, new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
    public static final Item GRASS_CHESTPLATE = new GrassChestplateItem(ArmorMaterials.GRASS, ArmorItem.Type.CHESTPLATE, new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
    public static final Item GRASS_LEGGINGS = new GrassLeggingsItem(ArmorMaterials.GRASS, ArmorItem.Type.LEGGINGS, new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
    public static final Item GRASS_BOOTS = new GrassBootsItem(ArmorMaterials.GRASS, ArmorItem.Type.BOOTS, new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
    public static final Item CLONE_SYRUP = new CloneSyrup(new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP).food(FoodComponents.CLONE_SYRUP));




}

