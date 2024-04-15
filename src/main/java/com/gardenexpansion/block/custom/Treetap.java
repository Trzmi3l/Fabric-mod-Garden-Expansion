package com.gardenexpansion.block.custom;

import com.gardenexpansion.block.RegisterBlocks;
import com.gardenexpansion.util.GexTags;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class Treetap extends BlockWithEntity {

    private static VoxelShape shape = Stream.of(
            Block.createCuboidShape(7.5, 3, 0, 8.5, 4, 5),
            Block.createCuboidShape(7.85, 4, 2, 8.100000000000001, 4.5, 2.25),
            Block.createCuboidShape(6.85, 4.5, 2, 9.100000000000001, 4.7, 2.25),
            Block.createCuboidShape(7.75, 2.5, 5, 8.25, 3.5, 6)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static DirectionProperty FACING = Properties.FACING;
    protected static VoxelShape EAST_SHAPE;
    protected static VoxelShape WEST_SHAPE;
    protected static VoxelShape SOUTH_SHAPE;
    protected static VoxelShape NORTH_SHAPE;



    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if(state.isIn(GexTags.Blocks.SYRUP_GATHERABLE)) {

            return true;
        } else return false;
    }


    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {

        return super.getPlacementState(context).with(Properties.FACING, context.getSide());
    }

    public Treetap() {
        super(FabricBlockSettings.copyOf(Blocks.ACACIA_BUTTON));
        setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
}
