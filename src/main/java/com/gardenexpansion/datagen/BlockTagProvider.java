package com.gardenexpansion.datagen;

import com.gardenexpansion.block.RegisterBlocks;
import com.gardenexpansion.util.GexTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

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
                .add(RegisterBlocks.WATER_COLLECTOR);

        //getOrCreateTagBuilder(GexTags.Blocks.PRUNER_PRUNABLE)
        //        .forceAddTag(BlockTags.LEAVES);   (jak tamto nie zadziala to zdekomnetuhj to)

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "pruner_prunable")))
                .forceAddTag(BlockTags.LEAVES);
    }
}
