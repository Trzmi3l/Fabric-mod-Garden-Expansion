package com.gardenexpansion.block.custom;

import com.gardenexpansion.block.RegisterBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

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

    public static class MapleThings {
        public static class MapleStairs extends StairsBlock {
            public MapleStairs() {
                super(RegisterBlocks.MAPLE_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS));
            }
        }
        public static class MapleSlab extends SlabBlock {
            public MapleSlab() {
                super(FabricBlockSettings.copyOf(Blocks.OAK_SLAB));
            }
        }
        public static class MapleButton extends ButtonBlock {
            public MapleButton() {
                super(BlockSetType.OAK, 10, FabricBlockSettings.copyOf(Blocks.OAK_BUTTON));
            }
        }
        public static class MaplePressurePlate extends PressurePlateBlock {
            public MaplePressurePlate() {
                super(BlockSetType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE));
            }
        }
        public static class MapleFence extends FenceBlock {
            public MapleFence() {
                super(FabricBlockSettings.copyOf(Blocks.OAK_FENCE));
            }
        }
        public static class MapleGate extends FenceGateBlock {
            public MapleGate() {
                super(WoodType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE));
            }
        }
        public static class MapleWall extends WallBlock {
            public MapleWall() {
                super(FabricBlockSettings.copyOf(Blocks.COBBLESTONE_WALL).sounds(BlockSoundGroup.WOOD));
            }
        }
        public static class MapleSign extends SignBlock {
            public MapleSign() {
                super(WoodType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_SIGN));
            }
        }
        public static class MapleWallSign extends WallSignBlock {
            public MapleWallSign() {
                super(WoodType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN));
            }
            @Override
            public String getTranslationKey() {
                return "Maple Wall Sign";
            }
        }
        public static class MapleDoors extends DoorBlock {
            public MapleDoors() {
                super(BlockSetType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_DOOR).nonOpaque());
            }
        }
        public static class MapleTrapdoor extends TrapdoorBlock {
            public MapleTrapdoor() {
                super(BlockSetType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).nonOpaque());
            }
        }
    }

}
