package com.gardenexpansion.item.custom;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class CloneSyrup extends Item {

    public CloneSyrup(Settings settings) {
        super(settings);
    }
    @Override
    public SoundEvent getDrinkSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }

    @Override
    public SoundEvent getEatSound() { return SoundEvents.BLOCK_HONEY_BLOCK_FALL; }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (!world.isClient) {
            //world.getServer().getOverworld().spawnParticles(ParticleTypes.DRIPPING_HONEY, user.getX(), user.getY()+1.5, user.getZ(), 10, 0.3f, 0.7f, 0.3f, 4f);
        }

        if (stack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        } else {
            if (user instanceof PlayerEntity) {
                PlayerEntity playerEntity = (PlayerEntity)user;
                if (!playerEntity.getAbilities().creativeMode) {
                    ItemStack itemStack = new ItemStack(Items.GLASS_BOTTLE);
                    if (!playerEntity.getInventory().insertStack(itemStack)) {
                        playerEntity.dropItem(itemStack, false);
                    }
                }
            }

            return stack;
        }

    }
}
