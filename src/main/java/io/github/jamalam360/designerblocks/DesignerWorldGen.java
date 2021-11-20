/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2021 Jamalam360
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package io.github.jamalam360.designerblocks;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;

import java.util.OptionalInt;

import static io.github.jamalam360.designerblocks.DesignerBlocks.MOD_ID;

/**
 * @author Jamalam360
 */
public class DesignerWorldGen {

    private static final ConfiguredFeature<?, ?> LIMESTONE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    BlockRegistry.LIMESTONE.getBlock().getDefaultState(),
                    64)) // Vein size
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(150)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(3); // Number of veins per chunk

    private static final ConfiguredFeature<?, ?> DARKSTONE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    BlockRegistry.DARKSTONE.getBlock().getDefaultState(),
                    64))
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(150))))
            .spreadHorizontally()
            .repeat(3);

    public static final ConfiguredFeature<?, ?> CHESTNUT_TREE = Feature.TREE.
            configure((new net.minecraft.world.gen.feature.TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BlockRegistry.CHESTNUT_LOG.getBlock().getDefaultState()),
                    new DarkOakTrunkPlacer(6, 2, 1),
                    new SimpleBlockStateProvider(BlockRegistry.CHESTNUT_LEAVES.getBlock().getDefaultState()),
                    new SimpleBlockStateProvider(BlockRegistry.CHESTNUT_SAPLING.getBlock().getDefaultState()),
                    new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                    new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())))
                    .ignoreVines().build())
            .spreadHorizontally()
            .applyChance(5); // About a 20% chance to generate per chunk (1/x)

    @SuppressWarnings("deprecation")
    public static void register() {
        RegistryKey<ConfiguredFeature<?, ?>> limestoneOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(MOD_ID, "limestone_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, limestoneOverworld.getValue(), LIMESTONE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, limestoneOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> darkstoneOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(MOD_ID, "darkstone_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, darkstoneOverworld.getValue(), DARKSTONE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, darkstoneOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> chestnutTree = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MOD_ID, "chestnut_tree"));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, chestnutTree.getValue(), CHESTNUT_TREE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, chestnutTree);
    }

    public static void setupShitJavaIsFuckingStupidSoYouHaveToCallThisToLoadTheClassBeforeUsage() {
    }
}
