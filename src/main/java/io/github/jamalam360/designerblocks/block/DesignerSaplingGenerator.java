package io.github.jamalam360.designerblocks.block;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class DesignerSaplingGenerator extends SaplingGenerator {
    private final ConfiguredFeature<TreeFeatureConfig, ?> feature;

    public DesignerSaplingGenerator(ConfiguredFeature<?, ?> feature) {
        this.feature = (ConfiguredFeature<TreeFeatureConfig, ?>) feature;
    }

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean bees) {
        return feature;
    }
}