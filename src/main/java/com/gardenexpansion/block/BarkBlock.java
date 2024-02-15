package com.gardenexpansion.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

public class BarkBlock extends Block {

    static FabricBlockSettings s = FabricBlockSettings.create();
    public BarkBlock(Settings settings) {
        super(settings);
    }
}
