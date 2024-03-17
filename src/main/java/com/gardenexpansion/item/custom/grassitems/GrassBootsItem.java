package com.gardenexpansion.item.custom.grassitems;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class GrassBootsItem extends GrassArmorItem {

    static FabricItemSettings ItemSettings = new OwoItemSettings();
    public GrassBootsItem(ArmorMaterial material, ArmorItem.Type type, Item.Settings settings){
        super(material, type, settings);
    }
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context){
        //tooltip.add(Text.translatable("tooltip.gardenexpansion.grass_helmet.tooltip"));
        //tooltip.add(Text.translatable("tooltip.gardenexpansion.grass_chestplate.tooltip"));
        //tooltip.add(Text.translatable("tooltip.gardenexpansion.grass_leggings.tooltip"));
        tooltip.add(Text.translatable("tooltip.gardenexpansion.grass_boots.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
