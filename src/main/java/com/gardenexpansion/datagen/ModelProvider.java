package com.gardenexpansion.datagen;

import com.gardenexpansion.block.RegisterBlocks;
import com.gardenexpansion.item.RegisterItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.scoreboard.AbstractTeam;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import javax.swing.text.html.Option;
import java.util.Optional;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
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
        itemModelGenerator.register(RegisterItems.COW_MANURE, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.LEAVES_CLAMP, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.OAK_BARK, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.PRUNER, Models.HANDHELD);
        itemModelGenerator.register(RegisterBlocks.CROSS_FENCE.asItem(), RegisterBlocks.CROSS_FENCE.asItem(), Models.GENERATED);
        itemModelGenerator.register(RegisterItems.SYRUP_TAP, Models.HANDHELD);


        //itemModelGenerator.register(RegisterBlocks.CROSS_FENCE.asItem(),);
        //itemModelGenerator.register(RegisterBlocks.WATER_COLLECTOR.asItem(), Models.GENERATED);
        //itemModelGenerator.register(RegisterBlocks.MAPLE_LEAVES.asItem(), Models.GENERATED);

        //itemModelGenerator.register(RegisterBlocks.MAPLE_LEAVES.asItem(), Models.LEAVES);
        //itemModelGenerator.register(RegisterBlocks.MAPLE_LOG.asItem(),Models.GENERATED);
        //itemModelGenerator.register(RegisterBlocks.MAPLE_STRIPPED_WOOD.asItem(), Models.GENERATED);
        //itemModelGenerator.register(RegisterBlocks.MAPLE_STRIPPED_LOG.asItem(), Models.GENERATED);

    }
}
