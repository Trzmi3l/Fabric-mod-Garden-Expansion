package com.gardenexpansion.blockEntities;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidDrainable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.BucketItem;
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

public class WaterCollectorEntity extends BlockEntity implements FluidDrainable {
    public WaterCollectorEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegister.WATER_COLLECTOR_BLOCK_ENITY, pos, state);
    }
    private int waterStored = 0;
    private int maxWaterCapacity = 1000;
    private boolean isFull = false;

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
        if(world.isClient) return;

        if(world.isRaining()) {
            if(waterStored < maxWaterCapacity) {
                waterStored++;
            } else {
                isFull = true;
            }
        }

    }

    public ActionResult onUse(PlayerEntity p, Hand h, BlockHitResult bhr) {
        System.out.println("kon sie zlal");
       if(!world.isClient()) {
           ItemStack handled = p.getStackInHand(h);

           if(handled.getItem() instanceof BucketItem) {
               FluidDrainable drainable = (FluidDrainable) this;
               ItemStack filledBucket = drainable.tryDrainFluid(p, world, pos, world.getBlockState(pos));

               if(!filledBucket.isEmpty()) {
                   p.setStackInHand(h, filledBucket);
                   return ActionResult.SUCCESS;
               } else {
                   return ActionResult.FAIL;
               }

           }
           return ActionResult.PASS;
       }
        return ActionResult.FAIL;
    }


    @Override
    public ItemStack tryDrainFluid(@Nullable PlayerEntity player, WorldAccess world, BlockPos pos, BlockState state) {
        System.out.println("cipsko1");
        if(isFull) {
            waterStored = 0;
            isFull = false;
            System.out.println("cipsko2");
            return new ItemStack(Fluids.WATER.getBucketItem());
        } else {
            assert player != null;
            System.out.println("cipsko3");
            return player.getActiveItem().getItem().getDefaultStack();
        }
    }

    @Override
    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.empty();
    }
}
