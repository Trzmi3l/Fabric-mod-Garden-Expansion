package com.gardenexpansion.item.custom;

import com.gardenexpansion.Gardenexpansion;
import com.gardenexpansion.item.RegisterItems;
import com.gardenexpansion.util.GexTags;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;
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
            //System.out.println(blockState.isIn(BlockTags.));
            if(true){
                //blockState.isIn(GexTags.Blocks.PRUNER_PRUNABLE)
                if(context.getWorld() instanceof ServerWorld) {
                    int dropcount = new Random().nextInt(3) + 1;

                    ItemStack itemDrop;


                    if(blockState.isOf(Blocks.CHERRY_LEAVES)){
                        itemDrop = new ItemStack(Blocks.PINK_PETALS, dropcount);
                    } else
                    if(blockState.isIn(BlockTags.LEAVES)) {
                        itemDrop = new ItemStack(RegisterItems.LEAVES_CLAMP, dropcount);
                    } else if(blockState.isIn(BlockTags.FLOWERS)) {
                        itemDrop = new ItemStack(blockState.getBlock(), dropcount);
                    } else  {
                        return ActionResult.FAIL;
                    }




                    ServerWorld serverWorld = ((ServerWorld) context.getWorld()).toServerWorld();

                    playPruningSound(context.getPlayer(), serverWorld, positionClicked);

                    serverWorld.spawnEntity(new ItemEntity(serverWorld, positionClicked.getX() + 0.5, positionClicked.getY() + 1, positionClicked.getZ() + 0.5, itemDrop));

                    context.getStack().damage(1, Objects.requireNonNull(context.getPlayer()), p -> p.sendToolBreakStatus(context.getHand()));
                    context.getPlayer().getItemCooldownManager().set(this, 30);
                    return ActionResult.SUCCESS;
                }


            }
        }

        return ActionResult.FAIL;
    }


    /* Metoda sprawdzala czy blokc jest liscmi. Przestazala bo niepotrzebna  a sprawdzanie czy jest liscmi przenioslem do ifa :33

    private boolean isLeaves(BlockState blockState) {
        return blockState.isIn(BlockTags.LEAVES);
    }
    */

    protected void playPruningSound(@Nullable PlayerEntity player, WorldAccess world, BlockPos pos) {
        SoundEvent soundEvent = SoundEvents.ENTITY_SHEEP_SHEAR;
        world.playSound(player, pos, soundEvent, SoundCategory.BLOCKS, 1.0F, 1.0F);
        //world.emitGameEvent(player, GameEvent.FLUID_PLACE, pos);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context){
        //tooltip.add(Text.translatable("tooltip.gardenexpansion.pruner.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
