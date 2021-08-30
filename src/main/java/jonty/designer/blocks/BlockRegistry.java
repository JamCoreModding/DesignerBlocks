package jonty.designer.blocks;

import io.github.jamalam360.libjam.registry.entry.BlockEntry;
import jonty.designer.blocks.block.DesignerSaplingBlock;
import jonty.designer.blocks.block.DesignerSaplingGenerator;
import jonty.designer.blocks.block.DesignerStairsBlock;
import jonty.designer.blocks.block.OneWayWindowBlock;
import net.minecraft.block.*;
import net.minecraft.item.ItemGroup;

/**
 * @author Jamalam360 AND Jomlom but mostly Jamalam obviously
 */

@SuppressWarnings("unused")
public class BlockRegistry {
    public static final BlockEntry D_GLASS = new BlockEntry("d_glass", new GlassBlock(DesignerBlockSettings.getGlassSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry ONE_WAY_STONE = new BlockEntry("one_way_stone", new OneWayWindowBlock(DesignerBlockSettings.getGlassSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry ONE_WAY_DARKSTONE = new BlockEntry("one_way_darkstone", new OneWayWindowBlock(DesignerBlockSettings.getGlassSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry ONE_WAY_SANDSTONE = new BlockEntry("one_way_sandstone", new OneWayWindowBlock(DesignerBlockSettings.getGlassSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry ONE_WAY_LIMESTONE = new BlockEntry("one_way_limestone", new OneWayWindowBlock(DesignerBlockSettings.getGlassSettings()), ItemGroup.BUILDING_BLOCKS);

    public static final BlockEntry D_STONE = new BlockEntry("d_stone", new Block(DesignerBlockSettings.getBricksSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry D_SANDSTONE = new BlockEntry("d_sandstone", new Block(DesignerBlockSettings.getBricksSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry D_LIMESTONE = new BlockEntry("d_limestone", new Block(DesignerBlockSettings.getBricksSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry D_DARKSTONE = new BlockEntry("d_darkstone", new Block(DesignerBlockSettings.getBricksSettings()), ItemGroup.BUILDING_BLOCKS);

    public static final BlockEntry LIMESTONE = new BlockEntry("darkstone", new Block(DesignerBlockSettings.getStoneSettings()), ItemGroup.MATERIALS);
    public static final BlockEntry DARKSTONE = new BlockEntry("limestone", new Block(DesignerBlockSettings.getStoneSettings()), ItemGroup.MATERIALS);

    public static final BlockEntry D_WOOL_RED = new BlockEntry("d_wool_red", new Block(DesignerBlockSettings.getWoolSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry D_WOOL_BLUE = new BlockEntry("d_wool_blue", new Block(DesignerBlockSettings.getWoolSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry D_WOOL_GREEN = new BlockEntry("d_wool_green", new Block(DesignerBlockSettings.getWoolSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry D_WOOL_PURPLE = new BlockEntry("d_wool_purple", new Block(DesignerBlockSettings.getWoolSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry D_WOOL_WHITE = new BlockEntry("d_wool_white", new Block(DesignerBlockSettings.getWoolSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry D_WOOL_BLACK = new BlockEntry("d_wool_black", new Block(DesignerBlockSettings.getWoolSettings()), ItemGroup.BUILDING_BLOCKS);

    public static final BlockEntry CHESTNUT_PLANKS = new BlockEntry("chestnut_planks", new Block(DesignerBlockSettings.getPlanksSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry CHESTNUT_WOOD = new BlockEntry("chestnut_wood", new Block(DesignerBlockSettings.getWoodSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry CHESTNUT_LOG = new BlockEntry("chestnut_log", new PillarBlock(DesignerBlockSettings.getWoodSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry CHESTNUT_LEAVES = new BlockEntry("chestnut_leaves", new LeavesBlock(DesignerBlockSettings.getLeavesSettings()), ItemGroup.DECORATIONS);
    public static final BlockEntry CHESTNUT_SLAB = new BlockEntry("chestnut_slab", new SlabBlock(DesignerBlockSettings.getPlanksSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry CHESTNUT_STAIRS = new BlockEntry("chestnut_stairs", new DesignerStairsBlock(CHESTNUT_PLANKS.getBlock().getDefaultState(), DesignerBlockSettings.getPlanksSettings()), ItemGroup.BUILDING_BLOCKS);
    public static final BlockEntry CHESTNUT_SAPLING = new BlockEntry("chestnut_sapling", new DesignerSaplingBlock(new DesignerSaplingGenerator(DesignerWorldGen.CHESTNUT_TREE), DesignerBlockSettings.getPlantSettings()), ItemGroup.DECORATIONS);
}