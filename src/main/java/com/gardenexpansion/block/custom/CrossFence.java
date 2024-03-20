package com.gardenexpansion.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;


public class CrossFence extends Block {

    public static DirectionProperty FACING = Properties.FACING;
    protected static VoxelShape EAST_SHAPE;
    protected static VoxelShape WEST_SHAPE;
    protected static VoxelShape SOUTH_SHAPE;
    protected static VoxelShape NORTH_SHAPE;
    protected static VoxelShape DOWN_SHAPE;
    protected static VoxelShape UP_SHAPE;
    static FabricBlockSettings crossFenceSettings = FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).pistonBehavior(PistonBehavior.DESTROY).nonOpaque();
    public CrossFence() {

        super(crossFenceSettings);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        switch (direction) {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case EAST:
                return EAST_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case DOWN:
                return DOWN_SHAPE;
            case UP:
                return UP_SHAPE;
            default:
                return UP_SHAPE;
        }
    }
    static {
        WEST_SHAPE = VoxelShapes.cuboid(0.9375, 0, 0, 1, 1, 1);
        EAST_SHAPE = VoxelShapes.cuboid(0, 0, 0, 0.0625, 1, 1);
        NORTH_SHAPE = VoxelShapes.cuboid(0, 0, 0.9375, 1, 1, 1);
        SOUTH_SHAPE = VoxelShapes.cuboid(0, 0, 0, 1, 1, 0.0625);
        UP_SHAPE = VoxelShapes.cuboid(0, 0, 0, 1, 0.0625, 1);
        DOWN_SHAPE = VoxelShapes.cuboid(0, 0.9375, 0, 1, 1, 1);
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return super.getPlacementState(context).with(Properties.FACING, context.getPlayerLookDirection().getOpposite());
    }


}

