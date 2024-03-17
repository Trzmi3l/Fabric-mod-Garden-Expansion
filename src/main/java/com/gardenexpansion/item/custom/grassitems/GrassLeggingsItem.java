package com.gardenexpansion.item.custom.grassitems;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GrassLeggingsItem extends GrassArmorItem {


    public GrassLeggingsItem(ArmorMaterial material, ArmorItem.Type type , Settings settings){
        super(material, type, settings);
    }
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context){
        tooltip.add(Text.translatable("tooltip.gardenexpansion.grass_leggings.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
