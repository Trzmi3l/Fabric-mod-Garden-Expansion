package com.gardenexpansion.block;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.option.StickyKeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.Vibrations;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class WaterCollectorBlock extends BlockWithEntity implements BlockEntityProvider{
    private static final VoxelShape d = Stream.of(Block.createCuboidShape(1, 0, 1, 15, 1, 15), Block.createCuboidShape(1, 1, 1, 3, 5, 3), Block.createCuboidShape(1, 1, 13, 3, 5, 15), Block.createCuboidShape(13, 1, 1, 15, 5, 3), Block.createCuboidShape(13, 1, 13, 15, 5, 15), Block.createCuboidShape(3, 1, 1, 13, 5, 2), Block.createCuboidShape(3, 1, 14, 13, 5, 15), Block.createCuboidShape(14, 1, 3, 15, 5, 13), Block.createCuboidShape(2, 4, 2, 14, 4, 14), Block.createCuboidShape(1, 1, 3, 2, 5, 13)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    static FabricBlockSettings s = FabricBlockSettings.create().strength(3).nonOpaque();


    public static final BooleanProperty IS_FILLED = BooleanProperty.of("full");

    public WaterCollectorBlock() {
        super(s);
        setDefaultState(getDefaultState().with(IS_FILLED, false));

    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {



        return ActionResult.SUCCESS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return d;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(IS_FILLED);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
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

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        // VALIDATE TICKER ZROBIC https://github.com/Tutorials-By-Kaupenjoe/Fabric-Tutorial-1.20.X/blob/main/src/main/java/net/kaupenjoe/tutorialmod/block/custom/GemPolishingStationBlock.java#L81
    }
}
