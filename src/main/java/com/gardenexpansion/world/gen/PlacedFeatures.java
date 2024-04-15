package com.gardenexpansion.world.gen;

import com.gardenexpansion.Gardenexpansion;
import com.gardenexpansion.block.RegisterBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class PlacedFeatures {

    public static final RegistryEntry<PlacedFeature> MAPLEWOOD_PLACED_KEY = (RegistryEntry<PlacedFeature>) registerKey("maplewood_placed");

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

    register(context, (RegistryKey<PlacedFeature>) MAPLEWOOD_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(CustomConfiguredFeatures.MAPLE_KEY),
            VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                    net.minecraft.world.gen.feature.PlacedFeatures.createCountExtraModifier(1,02f,2), RegisterBlocks.MAPLE_SAPLING
                    ));


    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Gardenexpansion.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
