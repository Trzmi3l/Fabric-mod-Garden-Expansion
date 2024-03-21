package com.gardenexpansion.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PillarBlock;

public class MapleBlockStack {
    public static class MapleLog extends PillarBlock {



        public MapleLog() {
            super(FabricBlockSettings.copyOf(Blocks.OAK_LOG));

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

        public MapleLeaves() {
            super(FabricBlockSettings.copy(Blocks.OAK_LEAVES).nonOpaque());
        }
    }
}
