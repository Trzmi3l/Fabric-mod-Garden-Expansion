package com.gardenexpansion.item;

import com.gardenexpansion.Gardenexpansion;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;

public class CowManureItem extends Item {

    static OwoItemSettings s = new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP);

    public static String ITEM_NAME = "cow_manure";
    public CowManureItem() {

        super(s);

    }



    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        //CowEntity
        if(!context.getWorld().isClient()) {
           BlockState bPos = context.getWorld().getBlockState(context.getBlockPos());
           Block block = bPos.getBlock();
            if(bPos.isIn(BlockTags.CROPS)) {
                if (block instanceof Fertilizable fertilizable) {
                    if (fertilizable.isFertilizable(context.getWorld(), context.getBlockPos(), bPos)) {
                        if (context.getWorld() instanceof ServerWorld) {
                            if (fertilizable.canGrow(context.getWorld(), context.getWorld().random, context.getBlockPos(), bPos)) {
                                fertilizable.grow((ServerWorld) context.getWorld(), context.getWorld().random, context.getBlockPos(), bPos);

                                context.getStack().decrement(1);

                                return ActionResult.SUCCESS;
                            } else {
                                return ActionResult.FAIL;
                            }
                            // context.getPlayer().getEquippedStack().getItem().getDefaultStack().decrement(1);

                        }
                    }
                }
            }
        }


        return ActionResult.FAIL;
    }




}
