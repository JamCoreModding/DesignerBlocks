package jonty.designer.blocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class DesignerBlocksClient implements ClientModInitializer {

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 1.0f, 0.5f);
    }

    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.D_GLASS.getBlock(), RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.ONE_WAY_STONE.getBlock(), RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.CHESTNUT_LEAVES.getBlock(), RenderLayer.getCutout());

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x800202, BlockRegistry.D_WOOL_RED.getBlock());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x800202,  BlockRegistry.D_WOOL_RED.getBlock());

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x0000c9,  BlockRegistry.D_WOOL_BLUE.getBlock());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x0000c9,  BlockRegistry.D_WOOL_BLUE.getBlock());

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x004a17,  BlockRegistry.D_WOOL_GREEN.getBlock());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x004a17,  BlockRegistry.D_WOOL_GREEN.getBlock());

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x5800a8, BlockRegistry.D_WOOL_PURPLE.getBlock());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x5800a8,  BlockRegistry.D_WOOL_PURPLE.getBlock());

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xffffff,  BlockRegistry.D_WOOL_WHITE.getBlock());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xffffff,  BlockRegistry.D_WOOL_WHITE.getBlock());

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x282828,  BlockRegistry.D_WOOL_BLACK.getBlock());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x282828,  BlockRegistry.D_WOOL_BLACK.getBlock());
    }
}