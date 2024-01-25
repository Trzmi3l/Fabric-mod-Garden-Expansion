package com.gardenexpansion.item;

import com.gardenexpansion.Gardenexpansion;
import com.gardenexpansion.item.CowManureItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup GEX_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Gardenexpansion.MOD_ID, "gexgroup"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.gexgroup"))
                    .icon(() -> new ItemStack(ModItems.COW_MANURE)).entries((displayContext, entries) -> {
            }).build());
    public static void registerItemGroups(){
        Gardenexpansion.LOGGER.info("Registering Creative Item Groups for: "+Gardenexpansion.MOD_ID);
    }
}
