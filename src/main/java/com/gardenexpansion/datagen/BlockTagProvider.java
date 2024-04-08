package com.gardenexpansion.datagen;

import com.gardenexpansion.block.RegisterBlocks;
import com.gardenexpansion.item.RegisterItems;
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
                .add(RegisterBlocks.MAPLE_SAPLING)
                .add(RegisterBlocks.MAPLE_STAIRS)
                .add(RegisterBlocks.MAPLE_SLAB)
                .add(RegisterBlocks.MAPLE_FENCE)
                .add(RegisterBlocks.MAPLE_GATE)
                .add(RegisterBlocks.MAPLE_WALL)
                .add(RegisterBlocks.MAPLE_BUTTON)
                .add(RegisterBlocks.MAPLE_DOORS)
                .add(RegisterBlocks.MAPLE_SIGN)
                //.add(RegisterBlocks.MAPLE_WALL_SIGN)
                .add(RegisterBlocks.MAPLE_PRESSURE_PLATE)
                .add(RegisterBlocks.MAPLE_TRAPDOOR);


        getOrCreateTagBuilder(GexTags.Blocks.PRUNER_PRUNABLE)
                .forceAddTag(BlockTags.LEAVES);

        getOrCreateTagBuilder(GexTags.Blocks.SYRUP_GATHERABLE)
                .add(RegisterBlocks.MAPLE_LOG);

        getOrCreateTagBuilder(BlockTags.REPLACEABLE)
        //        .add(RegisterBlocks.SMALL_GRASS);
;
        getOrCreateTagBuilder(BlockTags.ENCHANTMENT_POWER_TRANSMITTER)
        //        .add(RegisterBlocks.SMALL_GRASS);
;

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(RegisterBlocks.MAPLE_PLANKS);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(RegisterBlocks.MAPLE_STAIRS);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(RegisterBlocks.MAPLE_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(RegisterBlocks.MAPLE_GATE);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(RegisterBlocks.MAPLE_SLAB);

        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(RegisterBlocks.MAPLE_DOORS);

        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(RegisterBlocks.MAPLE_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(RegisterBlocks.MAPLE_WALL);


        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(RegisterBlocks.MAPLE_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(RegisterBlocks.MAPLE_BUTTON);

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
                //.add(RegisterBlocks.SMALL_GRASS);

        //getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "pruner_prunable")))
        //        .forceAddTag(BlockTags.LEAVES);
    }
}
