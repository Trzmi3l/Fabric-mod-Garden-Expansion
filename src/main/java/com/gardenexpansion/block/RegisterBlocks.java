package com.gardenexpansion.block;

import com.gardenexpansion.Gardenexpansion;
import com.gardenexpansion.block.custom.*;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.registration.annotations.AssignedName;
import io.wispforest.owo.registration.reflect.BlockRegistryContainer;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;


public class RegisterBlocks implements BlockRegistryContainer {


    //public static final Block WATER_COLLECTOR = new WaterCollectorBlockOld();
    //public static final BlockEntity WATER_COLLECTOR = new WaterCollectorBlockEntity();

    public static final Block WATER_COLLECTOR = new WaterCollectorBlock();

    public static final Block BARK_BLOCK = new BarkBlock();

    public static final Block CROSS_FENCE = new CrossFence();

    // MAPLE GOWNO
    public static final Block MAPLE_LOG = new MapleBlockStack.MapleLog();

    public static final Block MAPLE_STRIPPED_LOG = new MapleBlockStack.MapleStrippedLog();

    public static final Block MAPLE_WOOD = new MapleBlockStack.MapleWood();

    public static final Block MAPLE_STRIPPED_WOOD = new MapleBlockStack.MapleStrippedWood();

    public static final Block MAPLE_PLANKS = new MapleBlockStack.MaplePlanks();

    public static final Block MAPLE_LEAVES = new MapleBlockStack.MapleLeaves();

    public static final Block MAPLE_STAIRS = new MapleBlockStack.MapleThings.MapleStairs();
    public static final Block MAPLE_SLAB= new MapleBlockStack.MapleThings.MapleSlab();
    public static final Block MAPLE_BUTTON = new MapleBlockStack.MapleThings.MapleButton();
    public static final Block MAPLE_DOORS = new MapleBlockStack.MapleThings.MapleDoors();
    public static final Block MAPLE_FENCE = new MapleBlockStack.MapleThings.MapleFence();
    public static final Block MAPLE_PRESSURE_PLATE = new MapleBlockStack.MapleThings.MaplePressurePlate();
    public static final Block MAPLE_GATE = new MapleBlockStack.MapleThings.MapleGate();
    public static final Block MAPLE_TRAPDOOR = new MapleBlockStack.MapleThings.MapleTrapdoor();
    @NoBlockItem
    public static final Block MAPLE_SIGN = new MapleBlockStack.MapleThings.MapleSign();
    @NoBlockItem
    public static final Block MAPLE_WALL_SIGN = new MapleBlockStack.MapleThings.MapleWallSign();
    public static final Block MAPLE_WALL = new MapleBlockStack.MapleThings.MapleWall();

    public static final BlockFamily MAPLE_FAMILY = BlockFamilies.register(RegisterBlocks.MAPLE_PLANKS)
            .door(RegisterBlocks.MAPLE_DOORS)
            .button(RegisterBlocks.MAPLE_BUTTON)
            .fence(RegisterBlocks.MAPLE_FENCE)
            .fenceGate(RegisterBlocks.MAPLE_GATE)
            .pressurePlate(RegisterBlocks.MAPLE_PRESSURE_PLATE)
            .trapdoor(RegisterBlocks.MAPLE_TRAPDOOR)
            .slab(RegisterBlocks.MAPLE_SLAB)
            .stairs(RegisterBlocks.MAPLE_STAIRS)
            .wall(RegisterBlocks.MAPLE_WALL)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final Block MAPLE_SAPLING = new MapleSapling();
    //public static final Block MAPLE_SAPLING = new SaplingBlock(SaplingGenerator.ACACIA, FabricBlockSettings.copyOf(Blocks.OAK_SAPLING));
    //public static final Block SMALL_GRASS = new ShortGrass();

    @Override
    public BlockItem createBlockItem(Block block, String identifier) {
        return new BlockItem(block, new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
    }
}
