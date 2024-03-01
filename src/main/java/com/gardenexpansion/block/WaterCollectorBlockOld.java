package com.gardenexpansion.block;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

@Deprecated
public class WaterCollectorBlockOld extends Block {

    static FabricBlockSettings s = FabricBlockSettings.create().strength(3);

    public static final BooleanProperty IS_FILLED = BooleanProperty.of("full");

    public WaterCollectorBlockOld() {
        super(s);
        setDefaultState(getDefaultState().with(IS_FILLED, false));
    }




    private static final VoxelShape d = Stream.of(Block.createCuboidShape(1, 0, 1, 15, 1, 15), Block.createCuboidShape(1, 1, 1, 3, 5, 3), Block.createCuboidShape(1, 1, 13, 3, 5, 15), Block.createCuboidShape(13, 1, 1, 15, 5, 3), Block.createCuboidShape(13, 1, 13, 15, 5, 15), Block.createCuboidShape(3, 1, 1, 13, 5, 2), Block.createCuboidShape(3, 1, 14, 13, 5, 15), Block.createCuboidShape(14, 1, 3, 15, 5, 13), Block.createCuboidShape(2, 4, 2, 14, 4, 14), Block.createCuboidShape(1, 1, 3, 2, 5, 13)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return d;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(IS_FILLED);
    }
    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }


}
