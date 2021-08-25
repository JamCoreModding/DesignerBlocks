package jonty.designer.blocks;

import io.github.jamalam360.libjam.registry.entry.BlockEntry;
import jonty.designer.blocks.block.OneWayStoneBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;

/**
 * @author Jamalam360
 */

@SuppressWarnings("unused")
public class BlockRegistry {
    public static final BlockEntry D_GLASS = new BlockEntry("d_glass", new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).allowsSpawning(DesignerBlocks::never).solidBlock(DesignerBlocks::never).suffocates(DesignerBlocks::never).blockVision(DesignerBlocks::never).requiresTool()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry ONE_WAY_STONE = new BlockEntry("one_way_stone", new OneWayStoneBlock(FabricBlockSettings.copy(Blocks.GLASS).allowsSpawning(DesignerBlocks::never).solidBlock(DesignerBlocks::never).suffocates(DesignerBlocks::never).blockVision(DesignerBlocks::never).requiresTool()), ItemGroup.BUILDING_BLOCKS);

    public static final BlockEntry D_STONE = new BlockEntry("d_stone", new Block(FabricBlockSettings.of(Material.STONE).strength(3, 7).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).breakByTool(FabricToolTags.PICKAXES).requiresTool()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry D_SANDSTONE = new BlockEntry("d_sandstone", new Block(FabricBlockSettings.of(Material.STONE).strength(3, 7).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).breakByTool(FabricToolTags.PICKAXES).requiresTool()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry D_LIMESTONE = new BlockEntry("d_limestone", new Block(FabricBlockSettings.of(Material.STONE).strength(3, 7).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).breakByTool(FabricToolTags.PICKAXES).requiresTool()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry D_DARKSTONE = new BlockEntry("d_darkstone", new Block(FabricBlockSettings.of(Material.STONE).strength(3, 7).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).breakByTool(FabricToolTags.PICKAXES).requiresTool()), ItemGroup.BUILDING_BLOCKS);

    public static final BlockEntry LIMESTONE = new BlockEntry("darkstone", new Block(FabricBlockSettings.of(Material.STONE).strength(2, 4).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).breakByTool(FabricToolTags.PICKAXES).requiresTool()), ItemGroup.MATERIALS);
    public static final BlockEntry DARKSTONE = new BlockEntry("limestone", new Block(FabricBlockSettings.of(Material.STONE).strength(2, 4).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).breakByTool(FabricToolTags.PICKAXES).requiresTool()), ItemGroup.MATERIALS);

    public static final BlockEntry D_WOOL_RED = new BlockEntry("d_wool_red", new Block(FabricBlockSettings.of(Material.WOOL).strength(0.5F, 3).sounds(BlockSoundGroup.WOOL).breakByTool(FabricToolTags.SHEARS)), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry D_WOOL_BLUE = new BlockEntry("d_wool_blue", new Block(FabricBlockSettings.of(Material.WOOL).strength(0.5F, 3).sounds(BlockSoundGroup.WOOL).breakByTool(FabricToolTags.SHEARS)), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry D_WOOL_GREEN = new BlockEntry("d_wool_green", new Block(FabricBlockSettings.of(Material.WOOL).strength(0.5F, 3).sounds(BlockSoundGroup.WOOL).breakByTool(FabricToolTags.SHEARS)), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry D_WOOL_PURPLE = new BlockEntry("d_wool_purple", new Block(FabricBlockSettings.of(Material.WOOL).strength(0.5F, 3).sounds(BlockSoundGroup.WOOL).breakByTool(FabricToolTags.SHEARS)), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry D_WOOL_WHITE = new BlockEntry("d_wool_white", new Block(FabricBlockSettings.of(Material.WOOL).strength(0.5F, 3).sounds(BlockSoundGroup.WOOL).breakByTool(FabricToolTags.SHEARS)), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry D_WOOL_BLACK = new BlockEntry("d_wool_black", new Block(FabricBlockSettings.of(Material.WOOL).strength(0.5F, 3).sounds(BlockSoundGroup.WOOL).breakByTool(FabricToolTags.SHEARS)), ItemGroup.BUILDING_BLOCKS);

    public static final BlockEntry CHESTNUT_PLANKS = new BlockEntry("chestnut_planks", new Block(FabricBlockSettings.of(Material.WOOD).strength(2, 5).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry CHESTNUT_WOOD = new BlockEntry("chestnut_wood", new Block(FabricBlockSettings.of(Material.WOOD).strength(2, 4).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)), ItemGroup.MATERIALS);
    public static final BlockEntry CHESTNUT_LOG = new BlockEntry("chestnut_log", new Block(FabricBlockSettings.of(Material.WOOD).strength(2, 4).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry CHESTNUT_LEAVES = new BlockEntry("chestnut_leaves", new Block(FabricBlockSettings.of(Material.LEAVES).strength(0.1F, 1).sounds(BlockSoundGroup.GRASS).breakByTool(FabricToolTags.SHEARS).requiresTool()), ItemGroup.MATERIALS);
}
