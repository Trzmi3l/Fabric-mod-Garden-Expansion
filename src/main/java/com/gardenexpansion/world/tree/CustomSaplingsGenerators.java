package com.gardenexpansion.world.tree;

import com.gardenexpansion.block.RegisterBlocks;
import com.gardenexpansion.world.gen.CustomConfiguredFeatures;
import com.gardenexpansion.world.tree.custom.CustomFoliagePlacer;
import com.gardenexpansion.world.tree.custom.CustomTrunkPlacer;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.Optional;

public class CustomSaplingsGenerators {

    public static class Maple {
        public static SaplingGenerator saplingGenerator = new SaplingGenerator("maple_tree", 0f,
                Optional.of(CustomConfiguredFeatures.MAPLE_KEY),
                Optional.of(CustomConfiguredFeatures.MAPLE_KEY),
                Optional.of(CustomConfiguredFeatures.MAPLE_KEY),
                Optional.of(CustomConfiguredFeatures.MAPLE_KEY),
                Optional.of(CustomConfiguredFeatures.MAPLE_KEY),
                Optional.of(CustomConfiguredFeatures.MAPLE_KEY));


        public static TreeFeatureConfig treeFeatureConfig = new TreeFeatureConfig.Builder(
                BlockStateProvider.of(RegisterBlocks.MAPLE_LOG),
                new CustomTrunkPlacer.MapleTrunkPlacer(5,4,3),

                BlockStateProvider.of(RegisterBlocks.MAPLE_LEAVES),
                new CustomFoliagePlacer.MapleFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1),2),

                new TwoLayersFeatureSize(1, 0,2)).build();
    }
    
    /*
    public static final TreeConfiguredFeatures megaVariant = new TreeConfiguredFeatures();
    public static final TreeConfiguredFeatures regularVariant = new TreeConfiguredFeatures();
    public static final TreeConfiguredFeatures beesVariant = new TreeConfiguredFeatures();

    public static final registryConfiguredFeature<?,?>


    /*

    public static final TreeFeatureConfig regularVariant =  new TreeFeatureConfig.Builder(
            BlockStateProvider.of(RegisterBlocks.MAPLE_LOG),
            new StraightTrunkPlacer(5, 4, 3),

            BlockStateProvider.of(RegisterBlocks.MAPLE_LEAVES),
            new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),

            new TwoLayersFeatureSize(1, 0, 2)).build();

    public static final TreeFeatureConfig beesVariant =  new TreeFeatureConfig.Builder(
            BlockStateProvider.of(RegisterBlocks.MAPLE_LOG),
            new StraightTrunkPlacer(5, 4, 3),

            BlockStateProvider.of(RegisterBlocks.MAPLE_LEAVES),
            new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),

            new TwoLayersFeatureSize(1, 0, 2)).build();


    */
}