package com.gardenexpansion.blockEntities;

import com.gardenexpansion.block.custom.WaterCollectorBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidDrainable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class WaterCollectorEntity extends BlockEntity{
    public WaterCollectorEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegister.WATER_COLLECTOR_BLOCK_ENITY, pos, state);
    }
    private int waterStored = 0;
    private int maxWaterCapacity = 100;
    public boolean isFull = false;

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("water_collector_block.water_stored", waterStored);
        nbt.putBoolean("water_collector_block.is_full", isFull);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        waterStored = nbt.getInt("water_collector_block.water_stored");
        isFull = nbt.getBoolean("water_collector_block.is_full");
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isRaining()) {
            if (waterStored < maxWaterCapacity) {
                waterStored++;
                isFull = false;
            } else if(waterStored == maxWaterCapacity){
                isFull = true;
            }
        }
        world.setBlockState(pos, state.with(WaterCollectorBlock.IS_FILLED, isFull));
    }


    public ActionResult onUse(PlayerEntity p, Hand h, BlockHitResult bhr) {
        if (world.isClient()) {
            ItemStack handled = p.getStackInHand(h);

            if (handled.getItem() == Items.BUCKET) {

                //ItemStack filledBucket = drainable.tryDrainFluid(p, world, pos, world.getBlockState(pos));
                ItemStack filledBucket = new ItemStack(Items.WATER_BUCKET, 1);
                if (handled.getItem() == Items.BUCKET && handled.getItem() != Items.WATER_BUCKET) {
                    p.setStackInHand(h, filledBucket);
                    waterStored = 0;
                    world.setBlockState(pos, world.getBlockState(pos).with(WaterCollectorBlock.IS_FILLED, isFull));
                    return ActionResult.SUCCESS;
                } else {
                    return ActionResult.FAIL;
                }
            }
            return ActionResult.FAIL;
        }
        return ActionResult.FAIL;
    }


    /*
    @Override
    public ItemStack tryDrainFluid(@Nullable PlayerEntity player, WorldAccess world, BlockPos pos, BlockState state) {
        if (isFull) {
            waterStored = 0;
            isFull = false;
            // Utwórz nowe wiadro z wodą i zwróć je
            return new ItemStack(Items.WATER_BUCKET);
        } else {
            // Zwróć puste wiadro, jeśli gracz trzymało puste wiadro
            return player != null && player.getActiveItem().isEmpty() ? new ItemStack(Items.BUCKET) : ItemStack.EMPTY;
        }
    }

    @Override
    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.empty();
    }
    */

}
