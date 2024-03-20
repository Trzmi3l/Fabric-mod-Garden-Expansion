package com.gardenexpansion.datagen;

import com.gardenexpansion.block.RegisterBlocks;
import com.gardenexpansion.item.RegisterItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
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
        // ^^^^^ zakomentowane bo cos sie sra do gaci ^^^^^^^^^^

        blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.MAPLE_PLANKS);

        blockStateModelGenerator.registerTintableCross(RegisterBlocks.MAPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        //blockStateModelGenerator.registerItemModel(RegisterBlocks.MAPLE_LEAVES);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //itemModelGenerator.register(RegisterItems.COW_MANURE, Models.GENERATED);
        //itemModelGenerator.register(RegisterItems.LEAVES_CLAMP, Models.GENERATED);
        //itemModelGenerator.register(RegisterItems.OAK_BARK, Models.GENERATED);
        //itemModelGenerator.register(RegisterItems.PRUNER, Models.GENERATED);

        //itemModelGenerator.registerArmor((ArmorItem) RegisterItems.GRASS_HELMET);
        //itemModelGenerator.registerArmor((ArmorItem) RegisterItems.GRASS_CHESTPLATE);
        //itemModelGenerator.registerArmor((ArmorItem) RegisterItems.GRASS_LEGGINGS);
        //itemModelGenerator.registerArmor((ArmorItem) RegisterItems.GRASS_BOOTS);
        itemModelGenerator.register(RegisterItems.COW_MANURE, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.LEAVES_CLAMP, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.OAK_BARK, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.CLONE_SYRUP, Models.GENERATED);
        //itemModelGenerator.register(RegisterItems.PRUNER, Models.HANDHELD);
        //itemModelGenerator.register(RegisterBlocks.CROSS_FENCE.asItem(), RegisterBlocks.CROSS_FENCE.asItem(), Models.GENERATED);



        //itemModelGenerator.register(RegisterBlocks.CROSS_FENCE.asItem(),);
        //itemModelGenerator.register(RegisterBlocks.WATER_COLLECTOR.asItem(), Models.GENERATED);
        //itemModelGenerator.register(RegisterBlocks.MAPLE_LEAVES.asItem(), Models.GENERATED);

        //itemModelGenerator.register(RegisterBlocks.MAPLE_LEAVES.asItem(), Models.LEAVES);
        //itemModelGenerator.register(RegisterBlocks.MAPLE_LOG.asItem(),Models.GENERATED);
        //itemModelGenerator.register(RegisterBlocks.MAPLE_STRIPPED_WOOD.asItem(), Models.GENERATED);
        //itemModelGenerator.register(RegisterBlocks.MAPLE_STRIPPED_LOG.asItem(), Models.GENERATED);

    }
}
