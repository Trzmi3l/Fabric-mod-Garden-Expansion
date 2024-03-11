package com.gardenexpansion;

import com.gardenexpansion.block.RegisterBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.fabricmc.fabric.impl.client.rendering.ColorProviderRegistryImpl;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;

public class GardenexpansionClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registryColorProviders();
    }


    private void registryColorProviders() {
       // BlockColorProvider grassColorProvider = ColorProviderRegistry.BLOCK.get(Blocks.SHORT_GRASS);



       // ColorProviderRegistry.BLOCK.register(grassColorProvider, RegisterBlocks.WATER_COLLECTOR);


        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if(world == null || pos == null) {
                return BiomeColors.getWaterColor(world, pos);
            }
            return BiomeColors.getWaterColor(world, pos);
        }), RegisterBlocks.WATER_COLLECTOR
        );

        BlockRenderLayerMapImpl.INSTANCE.putBlock(RegisterBlocks.WATER_COLLECTOR, RenderLayer.getCutoutMipped());



    }

}
