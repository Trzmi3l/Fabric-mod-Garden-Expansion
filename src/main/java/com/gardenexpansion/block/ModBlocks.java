package com.gardenexpansion.block;

import com.gardenexpansion.Gardenexpansion;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Gardenexpansion.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(Gardenexpansion.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        Gardenexpansion.LOGGER.info("Registering mod blocks for" + Gardenexpansion.MOD_ID);
    }

    public static final Block BARK_BLOCK = registerBlock("bark_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.MANGROVE_ROOTS)));
}
