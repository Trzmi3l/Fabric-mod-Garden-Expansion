package com.gardenexpansion.item.custom;

import com.gardenexpansion.Gardenexpansion;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GrassTooltips extends Item {

    static FabricItemSettings ItemSettings = new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP);
    static FabricItemSettings settings = new FabricItemSettings().equipmentSlot(stack -> EquipmentSlot.HEAD);
    public GrassTooltips(ArmorMaterial material, ArmorItem.Type type, Settings settings){
        super(ItemSettings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context){
        tooltip.add(Text.translatable("tooltip.gardenexpansion.grass_helmet.tooltip"));
        tooltip.add(Text.translatable("tooltip.gardenexpansion.grass_chestplate.tooltip"));
        tooltip.add(Text.translatable("tooltip.gardenexpansion.grass_leggings.tooltip"));
        tooltip.add(Text.translatable("tooltip.gardenexpansion.grass_boots.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
