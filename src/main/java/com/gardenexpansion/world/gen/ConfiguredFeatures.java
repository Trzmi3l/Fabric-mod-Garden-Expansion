package com.gardenexpansion.world.gen;

import com.gardenexpansion.Gardenexpansion;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ConfiguredFeatures {

    //public static final RegistryKey<ConfiguredFeature<?,?>> TEMPLATE = registerKey("TEMPLETE");

    public static final RegistryKey<ConfiguredFeature<?,?>> MAPLE_TREE_KEY = registerKey("maple_tree");

    public static void boostrap(Registerable<ConfiguredFeature<?,?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest((BlockTags.STONE_ORE_REPLACEABLES)); // idk jakies gowno do custom orow robie z poradnika ale to raczej suesless bo potrzbuje tego tylko po to zebnyu drzewa generowac

/*
        register(context, MAPLE_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of()
        ))
*/

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Gardenexpansion.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?,?>> context,
                RegistryKey<ConfiguredFeature<?,?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


}
