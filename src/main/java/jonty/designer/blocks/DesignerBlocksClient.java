package jonty.designer.blocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.render.RenderLayer;

public class DesignerBlocksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.D_GLASS.getBlock(), RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.ONE_WAY_STONE.getBlock(), RenderLayer.getTranslucent());

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