package com.gardenexpansion.item;

import com.gardenexpansion.Gardenexpansion;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public class PrunerItem extends Item {
    public static OwoItemSettings PrunerItemSettings = new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP).maxDamage(64);

    public PrunerItem() {
        super(PrunerItemSettings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            BlockState blockState = context.getWorld().getBlockState(positionClicked);

            if(isLeaves(blockState)){
                ItemStack itemDrop = new ItemStack(new OakBarkItem(), 1);

                World world = context.getWorld();
                world.spawnEntity(new ItemEntity(world, positionClicked.getX() + 0.5, positionClicked.getY() + 0.5, positionClicked.getZ() + 0.5, itemDrop));

                context.getStack().damage(1, Objects.requireNonNull(context.getPlayer()), p -> p.sendToolBreakStatus(context.getHand()));
                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.PASS;
    }

    private boolean isLeaves(BlockState blockState) {
        return blockState.isIn(BlockTags.LEAVES);
    }
}
