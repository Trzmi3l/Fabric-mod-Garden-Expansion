package com.gardenexpansion.block.custom;

import com.gardenexpansion.util.CustomLeavesColorProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.client.color.block.BlockColorProvider;

public class MapleBlockStack {
    public static class MapleLog extends PillarBlock {
        public MapleLog() {
            super(FabricBlockSettings.copy(Blocks.OAK_LOG));
        }
    }

    public static class MapleStrippedLog extends PillarBlock {
        public MapleStrippedLog() {
            super(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG));
        }
    }

    public static class MapleWood extends PillarBlock {
        public MapleWood() {
            super(FabricBlockSettings.copy(Blocks.OAK_WOOD));
        }
    }

    public static class MapleStrippedWood extends PillarBlock {
        public MapleStrippedWood() {
            super(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD));
        }
    }

    public static class MaplePlanks extends Block {
        public MaplePlanks() {
            super(FabricBlockSettings.copy(Blocks.OAK_PLANKS));
        }

    }

    public static class MapleLeaves extends LeavesBlock {
        public static final BlockColorProvider COLOR_PROVIDER = new CustomLeavesColorProvider();
        public MapleLeaves() {
            super(FabricBlockSettings.copy(Blocks.OAK_LEAVES).nonOpaque());
        }
    }
}
