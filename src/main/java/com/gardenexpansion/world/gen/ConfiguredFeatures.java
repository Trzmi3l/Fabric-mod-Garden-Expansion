package com.gardenexpansion.world.gen;

import com.gardenexpansion.Gardenexpansion;
import com.gardenexpansion.block.RegisterBlocks;
import com.gardenexpansion.world.tree.MapleSapling;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.Optional;

public class ConfiguredFeatures {

    //public static final RegistryKey<ConfiguredFeature<?,?>> TEMPLATE = registerKey("TEMPLETE");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE_REGULAR = registerKey("maple_regular");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE_MEGA = registerKey("maple_mega");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE_BEES = registerKey("maple_bees");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE_KEY = registerKey("maple");

    public static void boostrap(Registerable<ConfiguredFeature<?,?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest((BlockTags.STONE_ORE_REPLACEABLES)); // idk jakies gowno do custom orow robie z poradnika ale to raczej suesless bo potrzbuje tego tylko po to zebnyu drzewa generowac

/*
        register(context, MAPLE_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of()
        ))
*/

        register(context, MAPLE_KEY , Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(RegisterBlocks.MAPLE_LOG),
                new StraightTrunkPlacer(5,4,3),

                BlockStateProvider.of(RegisterBlocks.MAPLE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1),1),
                new TwoLayersFeatureSize(1, 0,2)).build());

        register(context, MAPLE_REGULAR , Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(RegisterBlocks.MAPLE_LOG),
                new StraightTrunkPlacer(5,4,3),

                BlockStateProvider.of(RegisterBlocks.MAPLE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1),1),
                new TwoLayersFeatureSize(1, 0,2)).build());

        register(context, MAPLE_MEGA, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(RegisterBlocks.MAPLE_LOG),
                new StraightTrunkPlacer(5,4,3),

                BlockStateProvider.of(RegisterBlocks.MAPLE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1),1),
                new TwoLayersFeatureSize(1, 0,2)).build());

        register(context, MAPLE_BEES, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(RegisterBlocks.MAPLE_LOG),
                new StraightTrunkPlacer(5,4,3),

                BlockStateProvider.of(RegisterBlocks.MAPLE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1),1),
                new TwoLayersFeatureSize(1, 0,2)).build());


    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Gardenexpansion.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?,?>> context,
                RegistryKey<ConfiguredFeature<?,?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


}
