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


	@Override
	public void onInitialize() {
		ITEM_GROUP.initialize();


		FieldRegistrationHandler.register(RegisterItems.class, MOD_ID, false);
		FieldRegistrationHandler.register(RegisterBlocks.class, MOD_ID,false);
		FieldRegistrationHandler.register(BlockEntityRegister.class, MOD_ID,false);




























		LOGGER.info("\n"+"Policjant mnie dusi, strach ściska mi gardło,\n" +
				"A w myślach myśl jedna: \"Czy to już piekło?\".\n" +
				"Lecz nagle ocknienie, mixiny działają!\n" +
				"I znika oprawca, a ja znów oddycham.\n" +
				"\n" +
				"W euforii radości, śmiech mój się rozlega,\n" +
				"Lecz nagle czuję, że coś jest nie tak.\n" +
				"W majtkach bulgocze, a smród uderza w nozdrza,\n" +
				"Nasrałem do chleba! Cóż za paskudna zbrodnia!\n" +
				"\n" +
				"Teraz to już pewne, piekło mnie czeka,\n" +
				"Za gówno w chlebie i ucieczkę od pecha.\n" +
				"Lecz mixiny działają, więc może jeszcze jest szansa,\n" +
				"Na odkupienie i życie bez smrodu.\n" +
				"\n" +
				"Więc ruszam przed siebie, z nadzieją w sercu,\n" +
				"Że mixiny mnie uratują od piekielnej czeluści.\n" +
				"I może kiedyś jeszcze zaznam szczęścia,\n" +
				"Bez smrodu gówna i policyjnej pałki.");
	}
}