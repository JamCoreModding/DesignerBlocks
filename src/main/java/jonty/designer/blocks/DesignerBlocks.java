package jonty.designer.blocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class DesignerBlocks implements ModInitializer {
    public static final Item BALL = new Item(new Item.Settings().group(ItemGroup.MISC));

    public static final Block D_GLASS = new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).allowsSpawning(DesignerBlocks::never).solidBlock(DesignerBlocks::never).suffocates(DesignerBlocks::never).blockVision(DesignerBlocks::never));
    public static final Block ONE_WAY_STONE = new OneWayStone(FabricBlockSettings.copy(Blocks.GLASS).allowsSpawning(DesignerBlocks::never).solidBlock(DesignerBlocks::never).suffocates(DesignerBlocks::never).blockVision(DesignerBlocks::never));

    public static final Block D_STONE = new Block(FabricBlockSettings.of(Material.STONE).strength(3, 7).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).breakByTool(FabricToolTags.PICKAXES).requiresTool());
    public static final Block D_SANDSTONE = new Block(FabricBlockSettings.of(Material.STONE).strength(3, 7).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).breakByTool(FabricToolTags.PICKAXES).requiresTool());
    public static final Block D_LIMESTONE = new Block(FabricBlockSettings.of(Material.STONE).strength(3, 7).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).breakByTool(FabricToolTags.PICKAXES).requiresTool());
    public static final Block D_DARKSTONE = new Block(FabricBlockSettings.of(Material.STONE).strength(3, 7).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).breakByTool(FabricToolTags.PICKAXES).requiresTool());

    public static final Block LIMESTONE = new Block(FabricBlockSettings.of(Material.STONE).strength(2, 4).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).breakByTool(FabricToolTags.PICKAXES).requiresTool());
    public static final Block DARKSTONE = new Block(FabricBlockSettings.of(Material.STONE).strength(2, 4).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).breakByTool(FabricToolTags.PICKAXES).requiresTool());

    public static final Block D_WOOL_RED = new Block(FabricBlockSettings.of(Material.WOOL).strength(0.5F, 3).sounds(BlockSoundGroup.WOOL).breakByTool(FabricToolTags.SHEARS));
    public static final Block D_WOOL_BLUE = new Block(FabricBlockSettings.of(Material.WOOL).strength(0.5F, 3).sounds(BlockSoundGroup.WOOL).breakByTool(FabricToolTags.SHEARS));
    public static final Block D_WOOL_GREEN = new Block(FabricBlockSettings.of(Material.WOOL).strength(0.5F, 3).sounds(BlockSoundGroup.WOOL).breakByTool(FabricToolTags.SHEARS));
    public static final Block D_WOOL_PURPLE = new Block(FabricBlockSettings.of(Material.WOOL).strength(0.5F, 3).sounds(BlockSoundGroup.WOOL).breakByTool(FabricToolTags.SHEARS));
    public static final Block D_WOOL_WHITE = new Block(FabricBlockSettings.of(Material.WOOL).strength(0.5F, 3).sounds(BlockSoundGroup.WOOL).breakByTool(FabricToolTags.SHEARS));
    public static final Block D_WOOL_BLACK = new Block(FabricBlockSettings.of(Material.WOOL).strength(0.5F, 3).sounds(BlockSoundGroup.WOOL).breakByTool(FabricToolTags.SHEARS));

    private static final ConfiguredFeature<?, ?> LIMESTONE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    LIMESTONE.getDefaultState(),
                    64)) // Vein size
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(150)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(3); // Number of veins per chunk

    private static final ConfiguredFeature<?, ?> DARKSTONE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    DARKSTONE.getDefaultState(),
                    64))
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(150))))
            .spreadHorizontally()
            .repeat(3);

    @Override
    public void onInitialize() {

        RegistryKey<ConfiguredFeature<?, ?>> limestoneOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("designerblocks", "limestone_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, limestoneOverworld.getValue(), LIMESTONE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, limestoneOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> darkstoneOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("designerblocks", "darkstone_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, darkstoneOverworld.getValue(), DARKSTONE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, darkstoneOverworld);

        registerBlock("d_glass", D_GLASS, ItemGroup.BUILDING_BLOCKS);
        registerBlock("one_way_stone", ONE_WAY_STONE, ItemGroup.BUILDING_BLOCKS);
        registerBlock("d_stone", D_STONE, ItemGroup.BUILDING_BLOCKS);
        registerBlock("d_sandstone", D_SANDSTONE, ItemGroup.BUILDING_BLOCKS);
        registerBlock("d_limestone", D_LIMESTONE, ItemGroup.BUILDING_BLOCKS);
        registerBlock("d_darkstone", D_DARKSTONE, ItemGroup.BUILDING_BLOCKS);

        registerBlock("darkstone", DARKSTONE, ItemGroup.MATERIALS);
        registerBlock("limestone", LIMESTONE, ItemGroup.MATERIALS);

        registerBlock("d_wool_red", D_WOOL_RED, ItemGroup.BUILDING_BLOCKS);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x800202, D_WOOL_RED);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x800202, D_WOOL_RED);
        registerBlock("d_wool_blue", D_WOOL_BLUE, ItemGroup.BUILDING_BLOCKS);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x0000c9, D_WOOL_BLUE);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x0000c9, D_WOOL_BLUE);
        registerBlock("d_wool_green", D_WOOL_GREEN, ItemGroup.BUILDING_BLOCKS);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x004a17, D_WOOL_GREEN);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x004a17, D_WOOL_GREEN);
        registerBlock("d_wool_purple", D_WOOL_PURPLE, ItemGroup.BUILDING_BLOCKS);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x5800a8, D_WOOL_PURPLE);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x5800a8, D_WOOL_PURPLE);
        registerBlock("d_wool_white", D_WOOL_WHITE, ItemGroup.BUILDING_BLOCKS);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xffffff, D_WOOL_WHITE);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xffffff, D_WOOL_WHITE);
        registerBlock("d_wool_black", D_WOOL_BLACK, ItemGroup.BUILDING_BLOCKS);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x282828, D_WOOL_BLACK);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x282828, D_WOOL_BLACK);
    }

    private void registerBlock(String id, Block block, ItemGroup itemGroup) {
        Registry.register(Registry.BLOCK, new Identifier("designerblocks", id), block);
        Registry.register(Registry.ITEM, new Identifier("designerblocks", id), new BlockItem(block, new FabricItemSettings().group(itemGroup)));
    }

    public static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    public static Boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }
}
