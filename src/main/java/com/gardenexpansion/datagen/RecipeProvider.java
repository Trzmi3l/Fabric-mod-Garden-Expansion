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
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class RecipeProvider extends FabricRecipeProvider {

    public RecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterItems.OAK_BARK, RecipeCategory.MISC, RegisterBlocks.BARK_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterItems.LEAVES_CLAMP, RecipeCategory.MISC, Blocks.OAK_LEAVES);


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, RegisterItems.PRUNER, 1)
                .pattern("#0#")
                .pattern("0#0")
                .pattern("S0S")
                .input('#', Items.IRON_INGOT)
                .input('S', Items.STICK)
                .input('0', Items.AIR)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, "pruner");

    }

}
