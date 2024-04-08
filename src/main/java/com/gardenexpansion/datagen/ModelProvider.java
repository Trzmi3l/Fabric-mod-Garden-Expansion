package com.gardenexpansion.datagen;

import com.gardenexpansion.block.RegisterBlocks;
import com.gardenexpansion.item.RegisterItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
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
        //blockStateModelGenerator.registerBuiltin(new Identifier("block/cross_fence"), RegisterBlocks.CROSS_FENCE);


        blockStateModelGenerator.registerLog(RegisterBlocks.MAPLE_LOG).log(RegisterBlocks.MAPLE_LOG).wood(RegisterBlocks.MAPLE_WOOD);
        blockStateModelGenerator.registerLog(RegisterBlocks.MAPLE_STRIPPED_LOG).log(RegisterBlocks.MAPLE_STRIPPED_LOG).wood(RegisterBlocks.MAPLE_STRIPPED_WOOD);

        //blockStateModelGenerator.registerTintableCross(RegisterBlocks.SMALL_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);


        blockStateModelGenerator.registerSingleton(RegisterBlocks.MAPLE_LEAVES, TexturedModel.LEAVES);


        //blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.MAPLE_PLANKS);

        blockStateModelGenerator.registerTintableCross(RegisterBlocks.MAPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        BlockStateModelGenerator.BlockTexturePool maplePool = blockStateModelGenerator.registerCubeAllModelTexturePool(RegisterBlocks.MAPLE_PLANKS);

        maplePool.family(RegisterBlocks.MAPLE_FAMILY);

        /*

        maplePool.button(RegisterBlocks.MAPLE_BUTTON);
        maplePool.customFence(RegisterBlocks.MAPLE_FENCE);
        maplePool.customFenceGate(RegisterBlocks.MAPLE_GATE);
        maplePool.pressurePlate(RegisterBlocks.MAPLE_PRESSURE_PLATE);
        //maplePool.sign(RegisterBlocks.MAPLE_SIGN);
        maplePool.slab(RegisterBlocks.MAPLE_SLAB);
        maplePool.stairs(RegisterBlocks.MAPLE_STAIRS);
        maplePool.wall(RegisterBlocks.MAPLE_WALL);

        blockStateModelGenerator.registerDoor(RegisterBlocks.MAPLE_DOORS);
        blockStateModelGenerator.registerTrapdoor(RegisterBlocks.MAPLE_TRAPDOOR);

        */

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(RegisterItems.COW_MANURE, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.LEAVES_CLAMP, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.OAK_BARK, Models.GENERATED);

        itemModelGenerator.register(RegisterItems.SYRUP_TAP, Models.HANDHELD);

        itemModelGenerator.register(RegisterItems.CLONE_SYRUP, Models.GENERATED);

        itemModelGenerator.register(RegisterBlocks.MAPLE_WALL_SIGN.asItem(), Models.GENERATED);



    }
}
