package com.gardenexpansion.item.custom;

import com.gardenexpansion.Gardenexpansion;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

public class CowManureItem extends Item {

    static OwoItemSettings s = new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP);

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
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context){
        tooltip.add(Text.translatable("tooltip.gardenexpansion.cow_manure.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }




}
