package com.gardenexpansion.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.datafixer.fix.ChunkPalettedStorageFix;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;


public class WaterCollectorBlock extends Block {

    public static final String BLOCK_NAME = "water_collector";
    static FabricBlockSettings s = FabricBlockSettings.create().strength(3);

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public WaterCollectorBlock() {
        super(s);
    }

    private static final VoxelShape d = Stream.of(
            Block.createCuboidShape(2, 1, 2, 3, 7, 3),
            Block.createCuboidShape(12, -5, 2, 13, 1, 3),
            Block.createCuboidShape(12, -5, 13, 13, 1, 14),
            Block.createCuboidShape(2, 1, 13, 3, 7, 14),
            Block.createCuboidShape(5, 5, 2, 11, 6, 14),
            Block.createCuboidShape(4, 5, 1, 5, 7, 15),
            Block.createCuboidShape(11, 5, 1, 12, 7, 15),
            Block.createCuboidShape(5, 5, 1, 11, 7, 2),
            Block.createCuboidShape(5, 5, 14, 11, 7, 15),
            Block.createCuboidShape(5, 6, 2, 11, 7, 14)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
