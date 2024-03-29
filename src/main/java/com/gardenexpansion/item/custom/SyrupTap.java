package com.gardenexpansion.item.custom;

import com.gardenexpansion.Gardenexpansion;
import com.gardenexpansion.item.RegisterItems;
import com.gardenexpansion.util.GexTags;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import java.util.Objects;

public class SyrupTap extends Item {

    static OwoItemSettings s = new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP).maxDamage(64);




    public SyrupTap() {
        super(s);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos bp = context.getBlockPos();
        BlockState bs = context.getWorld().getBlockState(bp);

        if(!context.getWorld().isClient) {
            if(bs.isIn(GexTags.Blocks.SYRUP_GATHERABLE)) {

                ServerWorld serverWorld = ((ServerWorld) context.getWorld()).toServerWorld();

                serverWorld.spawnEntity(new ItemEntity(serverWorld, bp.getX() + 0.5, bp.getY() + 1, bp.getZ() + 0.5, new ItemStack(RegisterItems.CLONE_SYRUP, 1)));
                context.getPlayer().playSound(SoundEvents.BLOCK_HONEY_BLOCK_BREAK, SoundCategory.BLOCKS, 1, 1);
                context.getStack().damage(1, Objects.requireNonNull(context.getPlayer()), p -> p.sendToolBreakStatus(context.getHand()));
                context.getPlayer().getItemCooldownManager().set(this, 120);

            }
        }
        return ActionResult.FAIL;
    }
}
