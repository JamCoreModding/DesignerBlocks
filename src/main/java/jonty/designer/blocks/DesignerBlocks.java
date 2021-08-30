package jonty.designer.blocks;

import io.github.jamalam360.libjam.registry.LibJamRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class DesignerBlocks implements ModInitializer {
    public static final String MOD_ID = "designerblocks";

    @Override
    public void onInitialize() {
        DesignerWorldGen.init();
        new LibJamRegistry(MOD_ID, BlockRegistry.class);
        DesignerWorldGen.register();
    }
}
