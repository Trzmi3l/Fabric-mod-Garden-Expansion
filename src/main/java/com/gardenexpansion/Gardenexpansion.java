package com.gardenexpansion;

import com.gardenexpansion.item.ModItemGroups;
import com.gardenexpansion.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Gardenexpansion implements ModInitializer {
	public static final String MOD_ID = "gardenexpansion";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}