package com.gardenexpansion.datagen;

import com.gardenexpansion.block.RegisterBlocks;
import com.gardenexpansion.item.RegisterItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.scoreboard.AbstractTeam;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

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
        //blockStateModelGenerator.(RegisterBlocks.MAPLE_LEAVES, BlockStateModelGenerator.TintType.TINTED, TextureMap.texture(Blocks.OAK_LEAVES));
        blockStateModelGenerator.registerSingleton(RegisterBlocks.MAPLE_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.MAPLE_PLANKS);
        blockStateModelGenerator.registerTintableCross(RegisterBlocks.MAPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(RegisterItems.COW_MANURE, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.LEAVES_CLAMP, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.OAK_BARK, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.PRUNER, Models.GENERATED);
        itemModelGenerator.register(RegisterBlocks.CROSS_FENCE.asItem(), Models.GENERATED);
        itemModelGenerator.register(RegisterBlocks.MAPLE_STRIPPED_WOOD.asItem(), Models.GENERATED);
        itemModelGenerator.register(RegisterBlocks.MAPLE_STRIPPED_LOG.asItem(), Models.GENERATED);
        itemModelGenerator.register(RegisterBlocks.WATER_COLLECTOR.asItem(), Models.GENERATED);
       // itemModelGenerator.register(RegisterBlocks.MAPLE_LEAVES.asItem(), Models.LEAVES);

    }
}
