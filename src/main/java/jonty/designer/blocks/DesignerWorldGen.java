package jonty.designer.blocks;

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

import static jonty.designer.blocks.DesignerBlocks.MOD_ID;

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
            .applyChance(5); // About a 33% chance to generate per chunk (1/x)

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
