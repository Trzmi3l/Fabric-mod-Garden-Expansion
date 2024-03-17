package com.gardenexpansion.datagen;

import com.gardenexpansion.item.RegisterItems;
import com.gardenexpansion.util.GexTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(GexTags.Items.GRASS_TIER)
                .add(RegisterItems.GRASS_HELMET)
                .add(RegisterItems.GRASS_CHESTPLATE)
                .add(RegisterItems.GRASS_LEGGINGS)
                .add(RegisterItems.GRASS_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(RegisterItems.GRASS_HELMET)
                .add(RegisterItems.GRASS_CHESTPLATE)
                .add(RegisterItems.GRASS_LEGGINGS)
                .add(RegisterItems.GRASS_BOOTS);
    }
}
