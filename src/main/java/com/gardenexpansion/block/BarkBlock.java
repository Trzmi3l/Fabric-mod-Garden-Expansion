package com.gardenexpansion.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;

public class BarkBlock extends Block {

    public static String ITEM_NAME = "bark_block";
    public BarkBlock() {
        super(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.MANGROVE_ROOTS));
    }
}
