package com.gardenexpansion.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class CowManureItem extends Item {

    static Settings s = new Settings();
    public static String ITEM_NAME = "cow_manure";
    public CowManureItem() {

        super(s);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if(!context.getWorld().isClient()) {
            BlockPos posClick = context.getBlockPos();
            PlayerEntity playerEntity = context.getPlayer();

            BlockState state = context.getWorld().getBlockState(posClick);
            if(state.isOf(Blocks.FARMLAND)) {
                Random rnd = Random.create();
                state.randomTick((ServerWorld) context.getWorld(), posClick, rnd);


                return ActionResult.SUCCESS;
            }

        }


        return ActionResult.FAIL;
    }



}
