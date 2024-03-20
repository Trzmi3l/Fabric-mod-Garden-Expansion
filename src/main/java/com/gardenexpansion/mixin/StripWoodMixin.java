package com.gardenexpansion.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.gardenexpansion.item.RegisterItems;

import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(AxeItem.class)
public class StripWoodMixin {
    @Inject(method = "useOnBlock", at = @At("TAIL"), cancellable = true)
    private void onUseOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> info) {

        BlockPos pos = context.getBlockPos();
        BlockState blockState = context.getWorld().getBlockState(pos);
        World world = context.getWorld();

        if (isStrippableLog(blockState)) {

            ActionResult result = ActionResult.SUCCESS;

                world.spawnEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, + pos.getZ() +0.5, new ItemStack(RegisterItems.OAK_BARK)));

            info.setReturnValue(result);
        } else {

            info.getReturnValue();
        }
    }

    private boolean isStrippableLog(BlockState state) {

        return state.isIn(BlockTags.LOGS);
    }



}
