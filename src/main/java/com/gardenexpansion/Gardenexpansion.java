package com.gardenexpansion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gardenexpansion.block.RegisterBlocks;
import com.gardenexpansion.blockEntities.BlockEntityRegister;
import com.gardenexpansion.item.RegisterItems;

import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class Gardenexpansion implements ModInitializer {
	public static final String MOD_ID = "gardenexpansion";
	//btw item group id to "gexgroup"
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final OwoItemGroup ITEM_GROUP = OwoItemGroup
			.builder(new Identifier(Gardenexpansion.MOD_ID, "default"), () -> Icon.of(Items.FLOWERING_AZALEA))
			.build();

	//public static final OwoItemGroup GRASS_ARMOR_GROUP = OwoItemGroup
			//.builder(new Identifier(Gardenexpansion.MOD_ID, "grass_armor_group"), () -> Icon.of(RegisterItems.GRASS_HELMET))
			//.build();


	@Override
	public void onInitialize() {
		ITEM_GROUP.initialize();
			

		FieldRegistrationHandler.register(RegisterItems.class, MOD_ID, false);
		FieldRegistrationHandler.register(RegisterBlocks.class, MOD_ID,false);
		FieldRegistrationHandler.register(BlockEntityRegister.class, MOD_ID,false);


}