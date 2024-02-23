package com.gardenexpansion.block;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.impl.client.rendering.ColorProviderRegistryImpl;
import net.minecraft.block.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.stream.Stream;


public class WaterCollectorBlock extends Block {

    //TOODODODODODODODOD ZMIENIC TO TAK ZBEY DZIALAO BO NEI MA TICKERA W BLOCK I ZMIENIC TO NAJPEWNIEJ NA BLOCKWITHENTITY POMOCY ZONA NIE CHCE OTWORZYC DZRZWI, JESTEM PEWNY ZE WYPILA CALA ZGRZEWKA HARNASIA BEZ EMNIE!!!!!1

    static MapColor mc = MapColor.BLUE;
    static FabricBlockSettings s = FabricBlockSettings.create().strength(3).mapColor(mc);

    public static final BooleanProperty IS_FILLED = BooleanProperty.of("full");

    private static final int TICK_INTERVAL = 20; // Dostosuj do własnych potrzeb
    private int tickCounter = 0;

    public WaterCollectorBlock() {
        super(s);
        setDefaultState(getDefaultState().with(IS_FILLED, false));



    }

    @Override

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.scheduledTick(state, world, pos, random);

        tickCounter++;
        if (tickCounter >= TICK_INTERVAL) {
            tickCounter = 0; // Zresetuj licznik po każdym przejściu przez TICK_INTERVAL
            onTick(world, pos, state); // Wywołaj metodę, którą chcesz wykonywać co określoną ilość ticków
        }

        onTick(world, pos, state);
    }
    private void onTick(World world, BlockPos pos, BlockState state) {

        if(world.isRaining()) {
            state.with(IS_FILLED, true);
        }

    }

    @Override
    public MapColor getDefaultMapColor() {
        return super.getDefaultMapColor();
    }

    private static final VoxelShape d = Stream.of(
            Block.createCuboidShape(1, 0, 1, 15, 1, 15),
            Block.createCuboidShape(1, 1, 1, 3, 5, 3),
            Block.createCuboidShape(1, 1, 13, 3, 5, 15),
            Block.createCuboidShape(13, 1, 1, 15, 5, 3),
            Block.createCuboidShape(13, 1, 13, 15, 5, 15),
            Block.createCuboidShape(3, 1, 1, 13, 5, 2),
            Block.createCuboidShape(3, 1, 14, 13, 5, 15),
            Block.createCuboidShape(14, 1, 3, 15, 5, 13),
            Block.createCuboidShape(2, 4, 2, 14, 4, 14),
            Block.createCuboidShape(1, 1, 3, 2, 5, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();




    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return d;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        world.setBlockState(pos, state.with(IS_FILLED,true));
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(IS_FILLED);
    }
}
