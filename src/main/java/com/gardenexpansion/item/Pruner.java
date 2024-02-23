package com.gardenexpansion.item;

import com.gardenexpansion.Gardenexpansion;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlayerSkullBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import javax.tools.Tool;

public class Pruner extends Item {

    static OwoItemSettings s = new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP).maxDamageIfAbsent(400);

    public Pruner() {
        super(s);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        
        if(!context.getWorld().isClient) {
            BlockPos bp = context.getBlockPos();
            BlockState bs = context.getWorld().getBlockState(bp);

            if(bs.isIn(BlockTags.FLOWERS) || bs.isIn(BlockTags.SMALL_FLOWERS) || bs.isIn(BlockTags.TALL_FLOWERS)) {

            }
        }

        return ActionResult.PASS;
    }
}
