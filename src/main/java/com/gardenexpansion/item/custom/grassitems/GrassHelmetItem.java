package com.gardenexpansion.item.custom.grassitems;

import com.gardenexpansion.item.materials.ArmorMaterials;
import com.google.common.collect.ImmutableMap;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GrassHelmetItem extends ArmorItem {
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ArmorMaterials.GRASS, new StatusEffectInstance(StatusEffects.LUCK, 1, 1,
                            true, false, true))

                    .build();
    public GrassHelmetItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    /*
    private static final Map<ArmorMaterial, ParticleEffect> MATERIAL_TO_PARTICLE_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, ParticleEffect>())
                    .put(ArmorMaterials.GRASS, ParticleTypes.HAPPY_VILLAGER)
                    .build();

    private static final ThreadLocal<Map<PlayerEntity, List<ParticleEffect>>> PLAYER_PARTICLES =
            ThreadLocal.withInitial(HashMap::new);

    // In a method handling armor wearing or updating:
    ArmorMaterial material = player.getInventory().getArmorStack(slot).getItem().getMaterial();
    ParticleEffect particle = MATERIAL_PARTICLE_MAP.get(material);

    if (particle != null) {
            List<ParticleEffect> playerParticles = PLAYER_PARTICLES.get().getOrDefault(player, new ArrayList<>());
            playerParticles.add(particle);
            PLAYER_PARTICLES.get().put(player, playerParticles);

            // Spawn particles periodically for visual effect:
            server.execute(() -> {
                while (player.getInventory().getArmorStack(slot).getItem().getMaterial() == material) {
                    for (ParticleEffect effect : playerParticles) {
                        spawnParticle(player, effect); // Implement your particle spawning logic
                    }
                    Thread.sleep(50); // Adjust for desired particle density
                }

                // Remove particles when armor is unequipped or material changes:
                PLAYER_PARTICLES.get().remove(player);
            });
    }

    private void spawnParticle(PlayerEntity player, ParticleEffect effect) {
        // Use Minecraft's particle spawning methods here,
        // considering server-side or client-side context as needed.
        // Example:
        player.world.spawnParticles(effect, player.getParticleX(0.5), player.getRandomBodyY(), player.getParticleZ(0.5), 5, 0.2, 0.2, 0.2, 0);
    }
    */


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player && hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private void evaluateArmorEffects(PlayerEntity player){
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }
    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect));
        }
    }
    private boolean particleWhenFullSet(PlayerEntity player, ArmorMaterial mapArmorMaterial){
        while(hasCorrectArmorOn(mapArmorMaterial, player)) {
            generateParticles(Objects.requireNonNull(player.getServer()).getOverworld(), player);
            break;
        }
        return false;
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        for (ItemStack armorStack: player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());
        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }

    private static void generateParticles(ServerWorld serverWorld, PlayerEntity player ){
        serverWorld.spawnParticles(ParticleTypes.SPORE_BLOSSOM_AIR, player.getX(), player.getY()+1, player.getZ(), 100, 0.4f, 0.8f, 0.4f, 0.4f);
    }


    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context){
        tooltip.add(Text.translatable("tooltip.gardenexpansion.grass_helmet.tooltip"));
            super.appendTooltip(stack, world, tooltip, context);
    }
}
