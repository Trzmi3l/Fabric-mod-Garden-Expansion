package com.gardenexpansion;

import com.gardenexpansion.item.ItemsReg;
import com.gardenexpansion.item.ModItemGroups;
import com.gardenexpansion.item.ModItems;
import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Gardenexpansion implements ModInitializer {
	public static final String MOD_ID = "gardenexpansion";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final OwoItemGroup ITEM_GROUP = OwoItemGroup
			.builder(new Identifier(Gardenexpansion.MOD_ID, "default"), () -> Icon.of(Items.FLOWERING_AZALEA))
			.build();


	@Override
	public void onInitialize() {
		ITEM_GROUP.initialize();

		FieldRegistrationHandler.register(ItemsReg.class, MOD_ID, false);
	}
}