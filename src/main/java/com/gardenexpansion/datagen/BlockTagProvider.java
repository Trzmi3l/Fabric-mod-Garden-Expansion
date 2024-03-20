package com.gardenexpansion.datagen;

import com.gardenexpansion.block.RegisterBlocks;
import com.gardenexpansion.util.GexTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;


import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(RegisterBlocks.BARK_BLOCK);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(RegisterBlocks.WATER_COLLECTOR)
                .add(RegisterBlocks.CROSS_FENCE)
                .add(RegisterBlocks.MAPLE_SAPLING);


        getOrCreateTagBuilder(GexTags.Blocks.PRUNER_PRUNABLE)
                .forceAddTag(BlockTags.LEAVES);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(RegisterBlocks.MAPLE_PLANKS);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(RegisterBlocks.MAPLE_LOG);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(RegisterBlocks.MAPLE_LEAVES);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(RegisterBlocks.MAPLE_LOG)
                .add(RegisterBlocks.MAPLE_WOOD)
                .add(RegisterBlocks.MAPLE_STRIPPED_LOG)
                .add(RegisterBlocks.MAPLE_STRIPPED_WOOD);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(RegisterBlocks.MAPLE_SAPLING);

        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT)
                .add(RegisterBlocks.MAPLE_SAPLING);

        //getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "pruner_prunable")))
        //        .forceAddTag(BlockTags.LEAVES);
    }
}
