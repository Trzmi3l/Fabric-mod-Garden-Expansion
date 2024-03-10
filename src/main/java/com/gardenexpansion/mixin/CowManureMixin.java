package com.gardenexpansion.mixin;

import com.gardenexpansion.item.RegisterItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CowEntity.class)
public class CowManureMixin {

    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    private void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        ItemStack is = player.getStackInHand(hand);
        CowEntity ce = (CowEntity) (Object) this;
        if(ce.isBreedingItem(is) && ce.canEat()) {
            ItemStack drop = new ItemStack(RegisterItems.COW_MANURE);
            World w = ce.getWorld();
            ce.setLoveTicks(600);
            ce.lovePlayer(player);
            is.decrement(1);
            w.spawnEntity(new ItemEntity(w, ce.getX(),ce.getY(),ce.getZ(), drop));
            cir.setReturnValue(ActionResult.SUCCESS);
        }
    }

}
