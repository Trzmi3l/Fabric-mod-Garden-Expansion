package com.gardenexpansion.datagen;

import com.gardenexpansion.block.RegisterBlocks;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class LootTableProvider extends FabricBlockLootTableProvider {
    public LootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(RegisterBlocks.BARK_BLOCK);
        addDrop(RegisterBlocks.WATER_COLLECTOR);
        addDrop(RegisterBlocks.CROSS_FENCE);

        addDrop(RegisterBlocks.MAPLE_LOG);
        addDrop(RegisterBlocks.MAPLE_PLANKS);
        addDrop(RegisterBlocks.MAPLE_WOOD);
        addDrop(RegisterBlocks.MAPLE_STRIPPED_LOG);
        addDrop(RegisterBlocks.MAPLE_STRIPPED_WOOD);

        addDrop(RegisterBlocks.MAPLE_LEAVES, leavesDrops(RegisterBlocks.MAPLE_LEAVES, RegisterBlocks.MAPLE_SAPLING, 0.0025f));
        addDrop(RegisterBlocks.MAPLE_SAPLING);

        addDrop(RegisterBlocks.MAPLE_STAIRS);
        addDrop(RegisterBlocks.MAPLE_PRESSURE_PLATE);
        addDrop(RegisterBlocks.MAPLE_BUTTON);
        addDrop(RegisterBlocks.MAPLE_FENCE);
        addDrop(RegisterBlocks.MAPLE_DOORS, doorDrops(RegisterBlocks.MAPLE_DOORS));
        addDrop(RegisterBlocks.MAPLE_GATE);
        addDrop(RegisterBlocks.MAPLE_SLAB, slabDrops(RegisterBlocks.MAPLE_SLAB));
        addDrop(RegisterBlocks.MAPLE_TRAPDOOR);
        addDrop(RegisterBlocks.MAPLE_WALL);
        //addDrop(RegisterBlocks.MAPLE_WALL_SIGN);
        //addPottedPlantDrops(RegisterBlocks.MAPLE_SAPLING.);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public LootTable.Builder copperLikeOreDrops(Block drop, Item item){
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(2.0f, 5.0f))))
                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
