package com.gardenexpansion;

import com.gardenexpansion.datagen.*;
import com.gardenexpansion.world.gen.ConfiguredFeatures;
import com.gardenexpansion.world.gen.PlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class GardenexpansionDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(BlockTagProvider::new);
		pack.addProvider(ItemTagProvider::new);
		pack.addProvider(LootTableProvider::new);
		pack.addProvider(ModelProvider::new);
		pack.addProvider(RecipeProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeatures::boostrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeatures::boostrap);
	}
}
