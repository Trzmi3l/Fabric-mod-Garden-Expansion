package com.gardenexpansion.world.gen;

import com.gardenexpansion.Gardenexpansion;
import com.gardenexpansion.world.tree.CustomSaplingsGenerators;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class CustomConfiguredFeatures {

    //public static final RegistryKey<ConfiguredFeature<?,?>> TEMPLATE = registerKey("TEMPLETE");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE_KEY = registerKey("maple_tree");

    public static void boostrap(Registerable<ConfiguredFeature<?,?>> context) {
        Gardenexpansion.LOGGER.debug("registering configured features");

        register(context, MAPLE_KEY , Feature.TREE, CustomSaplingsGenerators.Maple.treeFeatureConfig);

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Gardenexpansion.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


}
