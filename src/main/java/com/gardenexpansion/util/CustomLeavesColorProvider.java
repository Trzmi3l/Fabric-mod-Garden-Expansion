package com.gardenexpansion.util;

import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.biome.BuiltinBiomes;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.Random;

public class CustomLeavesColorProvider implements BlockColorProvider {
    @Override
    public int getColor(BlockState state, @Nullable BlockRenderView world, @Nullable BlockPos pos, int tintIndex) {
            return 0xDC143C;
            /*
        Random rnd = new Random();
        int r = rnd.nextInt(5);
        switch (r) {
            case 0:
                    return 0x32CD32;

            case 1:
                    return 0xFFD700; // klon zimowy

            case 2:
                return 0xFF4500;

            case 3:
                return 0xDC143C;

            case 4:
                return 0x6B233B;

            case 5:
                return 0x4B0082;
        }

        return r;

             */
    }
    public int getColor() {
        return 0xDC143C;
    };
}
