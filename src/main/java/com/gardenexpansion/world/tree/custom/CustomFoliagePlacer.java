package com.gardenexpansion.world.tree.custom;

import com.gardenexpansion.mixin.FoliagePlacerTypeInvoker;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class CustomFoliagePlacer {

    public static final FoliagePlacerType<MapleFoliagePlacer> MAPLE_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("maple_foliage_placer", MapleFoliagePlacer.CODEC);


    public static class MapleFoliagePlacer extends FoliagePlacer {

        public static final Codec<MapleFoliagePlacer> CODEC = RecordCodecBuilder.create(chestnutFoliagePlacerInstance ->
                fillFoliagePlacerFields(chestnutFoliagePlacerInstance).and(Codec.intRange(0, 12).fieldOf("height")
                        .forGetter(instance -> instance.height)).apply(chestnutFoliagePlacerInstance, MapleFoliagePlacer::new));

        private int height;

        public MapleFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
            super(radius, offset);
            this.height = height;
        }

        @Override
        protected FoliagePlacerType<?> getType() {
            return CustomFoliagePlacer.MAPLE_FOLIAGE_PLACER;
        }

        @Override
        protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
            generateSquare(world, placer, random, config, treeNode.getCenter().up(0),2,1, treeNode.isGiantTrunk());
            generateSquare(world, placer, random, config, treeNode.getCenter().up(0),2,1, treeNode.isGiantTrunk());
            generateSquare(world, placer, random, config, treeNode.getCenter().up(0),2,1, treeNode.isGiantTrunk());
        }

        @Override
        public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
            return this.height;
        }

        @Override
        protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
            return false;
        }
    }
}
