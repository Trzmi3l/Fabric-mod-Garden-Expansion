package com.gardenexpansion.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class FoodComponents {
    public static final FoodComponent CLONE_SYRUP = new FoodComponent.Builder().hunger(0).saturationModifier(2.4f).
            statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1200), 0.8f).build();

}
