package com.gardenexpansion.util;

import com.gardenexpansion.Gardenexpansion;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

import javax.swing.text.html.HTML;

public class GexTags {
    public static class Blocks {
        public static final TagKey<Block> PRUNER_PRUNABLE = createTag("pruner_prunable");
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Gardenexpansion.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Gardenexpansion.MOD_ID, name));
        }
    }
}
