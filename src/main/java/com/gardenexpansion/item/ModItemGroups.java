package com.gardenexpansion.item;

import com.gardenexpansion.Gardenexpansion;

import com.gardenexpansion.item.CowManureItem;
import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.FlowerBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {


    public static final ItemGroup GEX_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Gardenexpansion.MOD_ID, "gardenexpansion"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.gardenexpansion.default"))

                    .icon(() -> new ItemStack(Items.ACACIA_FENCE_GATE)).entries((displayContext, entries) -> {

                    //tutaj mozna wpierdalac rzeczy do Gex grupki i w takiej kolejnosci jak zrobisz enrty w takiej beda w zakladce :3

                        entries.add(new CowManureItem()); // krwoie gowno


                    })

                    .icon(() -> new ItemStack(ItemsReg.COW_MANURE)).entries((displayContext, entries) -> {
            }).build());

    public static void registerItemGroups(){
        Gardenexpansion.LOGGER.info("Registering Creative Item Groups for: "+Gardenexpansion.MOD_ID);
    }





}
