package com.gardenexpansion.datagen;

import com.gardenexpansion.block.RegisterBlocks;
import com.gardenexpansion.item.RegisterItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;


public class RecipeProvider extends FabricRecipeProvider {

    public RecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, RegisterItems.OAK_BARK, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.BARK_BLOCK);
        //wszytkie rodzaje lisci craftable z 9 leaves clampow =========================================================
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.OAK_LEAVES, RegisterItems.LEAVES_CLAMP);
        //offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.DARK_OAK_LEAVES, RegisterItems.LEAVES_CLAMP);
        //offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.BIRCH_LEAVES, RegisterItems.LEAVES_CLAMP);
        //offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.SPRUCE_LEAVES, RegisterItems.LEAVES_CLAMP);
        //offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.JUNGLE_LEAVES, RegisterItems.LEAVES_CLAMP);
        //offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.ACACIA_LEAVES, RegisterItems.LEAVES_CLAMP);
        //offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.AZALEA_LEAVES, RegisterItems.LEAVES_CLAMP);
        //offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.FLOWERING_AZALEA_LEAVES, RegisterItems.LEAVES_CLAMP);
        //offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.MANGROVE_LEAVES, RegisterItems.LEAVES_CLAMP);
        //offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHERRY_LEAVES, RegisterItems.LEAVES_CLAMP);
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, RegisterItems.GRASS_HELMET, 1)
                .pattern("SSS")
                .pattern("S0S")
                .input('S', RegisterItems.LEAVES_CLAMP)
                .input('0', Items.SLIME_BALL)
                .criterion(hasItem(RegisterItems.LEAVES_CLAMP), conditionsFromItem(RegisterItems.LEAVES_CLAMP))
                .criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
                .offerTo(exporter, new Identifier(getRecipeName(RegisterItems.GRASS_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, RegisterItems.GRASS_CHESTPLATE, 1)
                .pattern("S0S")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', RegisterItems.LEAVES_CLAMP)
                .input('0', Items.SLIME_BALL)
                .criterion(hasItem(RegisterItems.LEAVES_CLAMP), conditionsFromItem(RegisterItems.LEAVES_CLAMP))
                .criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
                .offerTo(exporter, new Identifier(getRecipeName(RegisterItems.GRASS_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, RegisterItems.GRASS_LEGGINGS, 1)
                .pattern("SSS")
                .pattern("S0S")
                .pattern("S S")
                .input('S', RegisterItems.LEAVES_CLAMP)
                .input('0', Items.SLIME_BALL)
                .criterion(hasItem(RegisterItems.LEAVES_CLAMP), conditionsFromItem(RegisterItems.LEAVES_CLAMP))
                .criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
                .offerTo(exporter, new Identifier(getRecipeName(RegisterItems.GRASS_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, RegisterItems.GRASS_BOOTS, 1)
                .pattern("S0S")
                .pattern("S S")
                .input('S', RegisterItems.LEAVES_CLAMP)
                .input('0', Items.SLIME_BALL)
                .criterion(hasItem(RegisterItems.LEAVES_CLAMP), conditionsFromItem(RegisterItems.LEAVES_CLAMP))
                .criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
                .offerTo(exporter, new Identifier(getRecipeName(RegisterItems.GRASS_BOOTS)));

        createStairsRecipe(RegisterBlocks.MAPLE_STAIRS, Ingredient.ofItems(RegisterBlocks.MAPLE_PLANKS.asItem())).criterion(hasItem(RegisterBlocks.MAPLE_PLANKS.asItem()), conditionsFromItem(RegisterBlocks.MAPLE_PLANKS.asItem())).offerTo(exporter, new Identifier(getRecipeName(RegisterBlocks.MAPLE_STAIRS)));
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,RegisterBlocks.MAPLE_SLAB, Ingredient.ofItems(RegisterBlocks.MAPLE_PLANKS.asItem())).criterion(hasItem(RegisterBlocks.MAPLE_PLANKS.asItem()), conditionsFromItem(RegisterBlocks.MAPLE_PLANKS.asItem())).offerTo(exporter, new Identifier(getRecipeName(RegisterBlocks.MAPLE_SLAB)));
        createDoorRecipe(RegisterBlocks.MAPLE_DOORS, Ingredient.ofItems(RegisterBlocks.MAPLE_PLANKS.asItem())).criterion(hasItem(RegisterBlocks.MAPLE_PLANKS.asItem()), conditionsFromItem(RegisterBlocks.MAPLE_PLANKS.asItem())).offerTo(exporter, new Identifier(getRecipeName(RegisterBlocks.MAPLE_DOORS)));
        createFenceRecipe(RegisterBlocks.MAPLE_FENCE, Ingredient.ofItems(RegisterBlocks.MAPLE_PLANKS.asItem())).criterion(hasItem(RegisterBlocks.MAPLE_PLANKS.asItem()), conditionsFromItem(RegisterBlocks.MAPLE_PLANKS.asItem())).offerTo(exporter, new Identifier(getRecipeName(RegisterBlocks.MAPLE_FENCE)));
        createFenceGateRecipe(RegisterBlocks.MAPLE_GATE, Ingredient.ofItems(RegisterBlocks.MAPLE_PLANKS.asItem())).criterion(hasItem(RegisterBlocks.MAPLE_PLANKS.asItem()), conditionsFromItem(RegisterBlocks.MAPLE_PLANKS.asItem())).offerTo(exporter, new Identifier(getRecipeName(RegisterBlocks.MAPLE_GATE)));
        createTrapdoorRecipe(RegisterBlocks.MAPLE_TRAPDOOR, Ingredient.ofItems(RegisterBlocks.MAPLE_PLANKS.asItem())).criterion(hasItem(RegisterBlocks.MAPLE_PLANKS.asItem()), conditionsFromItem(RegisterBlocks.MAPLE_PLANKS.asItem())).offerTo(exporter, new Identifier(getRecipeName(RegisterBlocks.MAPLE_TRAPDOOR)));
        createPressurePlateRecipe(RecipeCategory.REDSTONE,RegisterBlocks.MAPLE_PRESSURE_PLATE, Ingredient.ofItems(RegisterBlocks.MAPLE_PLANKS.asItem())).criterion(hasItem(RegisterBlocks.MAPLE_PLANKS.asItem()), conditionsFromItem(RegisterBlocks.MAPLE_PLANKS.asItem())).offerTo(exporter, new Identifier(getRecipeName(RegisterBlocks.MAPLE_PRESSURE_PLATE)));



        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, RegisterBlocks.MAPLE_BUTTON.asItem(), 1)
                .pattern("   ")
                .pattern(" X ")
                .pattern("   ")
                .input('X', RegisterBlocks.MAPLE_PLANKS.asItem())
                .criterion(hasItem(RegisterBlocks.MAPLE_PLANKS.asItem()), conditionsFromItem(RegisterBlocks.MAPLE_PLANKS.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(RegisterBlocks.MAPLE_BUTTON)));
    }
}
