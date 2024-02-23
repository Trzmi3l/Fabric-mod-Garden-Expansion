package com.gardenexpansion.item;

import com.gardenexpansion.Gardenexpansion;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.Random;

public class PrunerItem extends Item {
    public static OwoItemSettings PrunerItemSettings = new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP).maxDamage(64);

    public PrunerItem() {
        super(PrunerItemSettings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if (!context.getWorld().isClient()) {

            BlockPos positionClicked = context.getBlockPos();
            BlockState blockState = context.getWorld().getBlockState(positionClicked);


            if(blockState.isIn(BlockTags.LEAVES)){

                if(context.getWorld() instanceof ServerWorld) {
                    int dropcount = new Random().nextInt(3) + 1;

                    ItemStack itemDrop = new ItemStack(blockState.getBlock(), dropcount);


                    ServerWorld serverWorld = ((ServerWorld) context.getWorld()).toServerWorld();



                    serverWorld.spawnEntity(new ItemEntity(serverWorld, positionClicked.getX() + 0.5, positionClicked.getY() + 1, positionClicked.getZ() + 0.5, itemDrop));

                    context.getStack().damage(1, Objects.requireNonNull(context.getPlayer()), p -> p.sendToolBreakStatus(context.getHand()));
                    context.getPlayer().getItemCooldownManager().set(this, 30);
                    return ActionResult.SUCCESS;
                }


            }
        }

        return ActionResult.PASS;
    }

    @Deprecated
    /** Metoda sprawdzala czy blokc jest liscmi. Przestazala bo niepotrzebna  a sprawdzanie czy jest liscmi przenioslem do ifa :33
     */
    private boolean isLeaves(BlockState blockState) {
        return blockState.isIn(BlockTags.LEAVES);
    }
}
