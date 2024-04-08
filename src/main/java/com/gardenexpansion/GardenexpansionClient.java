package com.gardenexpansion;

import com.gardenexpansion.block.RegisterBlocks;

import com.gardenexpansion.util.CustomLeavesColorProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.impl.client.rendering.ColorProviderRegistryImpl;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;

public class GardenexpansionClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registryColorProviders();
    }

    private void registryColorProviders() {
       // BlockColorProvider grassColorProvider = ColorProviderRegistry.BLOCK.get(Blocks.SHORT_GRASS);



       // ColorProviderRegistry.BLOCK.register(grassColorProvider, RegisterBlocks.WATER_COLLECTOR);

        CustomLeavesColorProvider colorProvider = new CustomLeavesColorProvider();

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if(world == null || pos == null) {
                return BiomeColors.getWaterColor(world, pos);
            }
            return BiomeColors.getWaterColor(world, pos);
        }), RegisterBlocks.WATER_COLLECTOR
        );


        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if(world == null || pos == null) {
                return colorProvider.getColor(state, world, pos, tintIndex);
            }
                return colorProvider.getColor(state, world, pos, tintIndex);
        }), RegisterBlocks.MAPLE_LEAVES
        );


        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            return colorProvider.getColor();
        }, RegisterBlocks.MAPLE_LEAVES.asItem());
       /*
        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
                    if(world == null || pos == null) {
                        return BiomeColors.getGrassColor(world, pos);
                    }
                    return BiomeColors.getGrassColor(world, pos);
                }), RegisterBlocks.SMALL_GRASS
        );

             */




        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.WATER_COLLECTOR, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.CROSS_FENCE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.MAPLE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.MAPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.MAPLE_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.MAPLE_DOORS, RenderLayer.getCutout());
       // BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.SMALL_GRASS, RenderLayer.getCutoutMipped());
       // BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.WATER_COLLECTOR, RenderLayer.getCutout());



    }



}
