package com.gardenexpansion.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class BarkBlock extends Block {

    public static final String BARK_BLOCK = "bark_block";

    public static final BlockSoundGroup BARK_BLOCK_SOUNDS = new BlockSoundGroup(1.0f, 1.0f, SoundEvents.BLOCK_MANGROVE_ROOTS_BREAK, SoundEvents.BLOCK_WART_BLOCK_STEP, SoundEvents.BLOCK_WART_BLOCK_PLACE, SoundEvents.BLOCK_WART_BLOCK_HIT, SoundEvents.BLOCK_WART_BLOCK_FALL);
    static FabricBlockSettings BlockSettings = FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BARK_BLOCK_SOUNDS);
    public BarkBlock() {
        super(BlockSettings);
    }
}
