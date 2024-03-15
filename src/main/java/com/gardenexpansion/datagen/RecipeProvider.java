package com.gardenexpansion.datagen;

import com.gardenexpansion.block.RegisterBlocks;
import com.gardenexpansion.item.RegisterItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

public class RecipeProvider extends FabricRecipeProvider {

    public RecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, RegisterItems.OAK_BARK, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.BARK_BLOCK);
        //wszytkie rodzaje lisci craftable z 9 leaves clampow =========================================================
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.OAK_LEAVES, RegisterItems.LEAVES_CLAMP);
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.DARK_OAK_LEAVES, RegisterItems.LEAVES_CLAMP);
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.BIRCH_LEAVES, RegisterItems.LEAVES_CLAMP);
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.SPRUCE_LEAVES, RegisterItems.LEAVES_CLAMP);
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.JUNGLE_LEAVES, RegisterItems.LEAVES_CLAMP);
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.ACACIA_LEAVES, RegisterItems.LEAVES_CLAMP);
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.AZALEA_LEAVES, RegisterItems.LEAVES_CLAMP);
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.FLOWERING_AZALEA_LEAVES, RegisterItems.LEAVES_CLAMP);
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.MANGROVE_LEAVES, RegisterItems.LEAVES_CLAMP);
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHERRY_LEAVES, RegisterItems.LEAVES_CLAMP);
        //=============================================================================================================




        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, RegisterItems.PRUNER, 1)
                .pattern("# #")
                .pattern(" # ")
                .pattern("S S")
                .input('#', Items.IRON_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, "pruner");

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.CROSS_FENCE, 8)
                .pattern("S S")
                .pattern(" S ")
                .pattern("S S")
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, "cross_fence");

        /*
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.CROSS_FENCE, 8)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', RegisterItems.LEAVES_CLAMP)
                .criterion(hasItem(RegisterItems.LEAVES_CLAMP), conditionsFromItem(RegisterItems.LEAVES_CLAMP))
                .offerTo(exporter, new Identifier());

         */
    }
}
