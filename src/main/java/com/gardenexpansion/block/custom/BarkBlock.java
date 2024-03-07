package com.gardenexpansion.block.custom;

import com.gardenexpansion.datagen.BlockTagProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Arrays;
import java.util.List;


public class BarkBlock extends Block {

    public static final BlockSoundGroup BARK_BLOCK_SOUNDS = new BlockSoundGroup(1.0f, 1.0f, SoundEvents.BLOCK_MANGROVE_ROOTS_BREAK, SoundEvents.BLOCK_WART_BLOCK_STEP, SoundEvents.BLOCK_WART_BLOCK_PLACE, SoundEvents.BLOCK_WART_BLOCK_HIT, SoundEvents.BLOCK_WART_BLOCK_FALL);
    static FabricBlockSettings BarkBlockSettings = FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BARK_BLOCK_SOUNDS);


    public BarkBlock() {
        super(BarkBlockSettings);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        this.spawnBreakParticles(world, player, pos, state);
        if (state.isIn(BlockTags.GUARDED_BY_PIGLINS)) {
            PiglinBrain.onGuardedBlockInteracted(player, false);
        }
        /*
        if do tej lopaty pierdolonej
        if(state.isIn(BlockTags.SHOVEL_MINEABLE)){
            player.getMainHandStack()

        }
        */

        world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(player, state));
        return state;
    }


    /*
    public static float strength() {
        ItemStack shovelStack = new ItemStack(Items.AIR);
        if (SHOVELS.contains(shovelStack.getItem())) {
            return 0.2f;
        } else {
            return Blocks.DIRT.getHardness();
        }
    }
    private static final List<Item> SHOVELS = Arrays.asList(Items.WOODEN_SHOVEL, Items.STONE_SHOVEL, Items.IRON_SHOVEL,
                Items.GOLDEN_SHOVEL, Items.DIAMOND_SHOVEL, Items.NETHERITE_SHOVEL);
    */
    public boolean isShovel(BlockState state){
        return state.isIn(BlockTags.SHOVEL_MINEABLE);
    }


}
