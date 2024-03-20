package com.gardenexpansion.item;

import com.gardenexpansion.Gardenexpansion;
import com.gardenexpansion.item.custom.CowManureItem;
import com.gardenexpansion.item.custom.LeavesClampItem;
import com.gardenexpansion.item.custom.OakBarkItem;
import com.gardenexpansion.item.custom.PrunerItem;
import com.gardenexpansion.item.custom.grassitems.GrassArmorItem;
import com.gardenexpansion.item.custom.grassitems.GrassBootsItem;
import com.gardenexpansion.item.custom.grassitems.GrassChestplateItem;
import com.gardenexpansion.item.custom.grassitems.GrassLeggingsItem;
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
    public static final Item GRASS_HELMET = new GrassArmorItem(ArmorMaterials.GRASS, ArmorItem.Type.HELMET, new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
    public static final Item GRASS_CHESTPLATE = new GrassChestplateItem(ArmorMaterials.GRASS, ArmorItem.Type.CHESTPLATE, new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
    public static final Item GRASS_LEGGINGS = new GrassLeggingsItem(ArmorMaterials.GRASS, ArmorItem.Type.LEGGINGS, new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
    public static final Item GRASS_BOOTS = new GrassBootsItem(ArmorMaterials.GRASS, ArmorItem.Type.BOOTS, new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));





}

