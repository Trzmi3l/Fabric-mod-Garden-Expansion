package com.gardenexpansion.datagen;

import com.gardenexpansion.block.RegisterBlocks;
import com.gardenexpansion.item.RegisterItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.util.Identifier;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.BARK_BLOCK);
        //blockStateModelGenerator.registerBuiltin(new Identifier("block/cross_fence"), RegisterBlocks.CROSS_FENCE);

        blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.BARK_BLOCK);
        blockStateModelGenerator.registerBuiltin(new Identifier("block/cross_fence"), RegisterBlocks.CROSS_FENCE);


        blockStateModelGenerator.registerLog(RegisterBlocks.MAPLE_LOG).log(RegisterBlocks.MAPLE_LOG).wood(RegisterBlocks.MAPLE_WOOD);
        blockStateModelGenerator.registerLog(RegisterBlocks.MAPLE_STRIPPED_LOG).log(RegisterBlocks.MAPLE_STRIPPED_LOG).wood(RegisterBlocks.MAPLE_STRIPPED_WOOD);


        //blockStateModelGenerator.registerSingleton(RegisterBlocks.MAPLE_LEAVES, TexturedModel.LEAVES);


        blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.MAPLE_PLANKS);

        blockStateModelGenerator.registerTintableCross(RegisterBlocks.MAPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);



    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(RegisterItems.COW_MANURE, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.LEAVES_CLAMP, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.OAK_BARK, Models.GENERATED);

        itemModelGenerator.register(RegisterItems.SYRUP_TAP, Models.HANDHELD);

        itemModelGenerator.register(RegisterItems.CLONE_SYRUP, Models.GENERATED);


    }
}
