package com.gardenexpansion.util;

import com.gardenexpansion.block.states.CrossFenceFlowerType;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.gen.placementmodifier.RandomOffsetPlacementModifier;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class FlowersColorProvider implements BlockColorProvider {

    public int getFlowerColor(CrossFenceFlowerType type) {
        switch (type) {
            case AZALEA -> {
                Random rnd = new Random();
            }
        }

        return 0;
    }

    public int getGreenColor(CrossFenceFlowerType type) {
        return 0;
    }

    @Override
    public int getColor(BlockState state, @Nullable BlockRenderView world, @Nullable BlockPos pos, int tintIndex) {
        return 0;
    }
}
