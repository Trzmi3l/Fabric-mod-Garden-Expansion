package com.gardenexpansion.block.custom;

import com.gardenexpansion.world.tree.CustomSaplingsGenerators;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class MapleSapling extends SaplingBlock {

    static FabricBlockSettings s = FabricBlockSettings.copyOf(Blocks.OAK_SAPLING);

    public MapleSapling() {
        super(CustomSaplingsGenerators.Maple.saplingGenerator, s);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        //return (double)world.random.nextFloat() < 0.45;
        return true;
    }




}
