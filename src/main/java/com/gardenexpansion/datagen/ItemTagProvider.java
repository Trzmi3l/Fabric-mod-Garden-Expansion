package com.gardenexpansion.datagen;

import java.util.concurrent.CompletableFuture;

import com.gardenexpansion.block.RegisterBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(RegisterBlocks.MAPLE_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(RegisterBlocks.MAPLE_LOG.asItem());

        getOrCreateTagBuilder(ItemTags.LEAVES)
                .add(RegisterBlocks.MAPLE_LEAVES.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(RegisterBlocks.MAPLE_LOG.asItem())
                .add(RegisterBlocks.MAPLE_WOOD.asItem())
                .add(RegisterBlocks.MAPLE_STRIPPED_LOG.asItem())
                .add(RegisterBlocks.MAPLE_STRIPPED_WOOD.asItem());

    }
}
