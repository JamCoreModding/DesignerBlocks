package io.github.jamalam360.designerblocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class DesignerBlocksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.D_GLASS.getBlock(), RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.ONE_WAY_STONE.getBlock(), RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.ONE_WAY_DARKSTONE.getBlock(), RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.ONE_WAY_SANDSTONE.getBlock(), RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.ONE_WAY_LIMESTONE.getBlock(), RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.CHESTNUT_LEAVES.getBlock(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.CHESTNUT_SAPLING.getBlock(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.LIGHT_PANEL.getBlock(), RenderLayer.getCutout());

        this.registerColorProvidedBlock(BlockRegistry.D_WOOL_RED.getBlock(), 0x800202);
        this.registerColorProvidedBlock(BlockRegistry.D_WOOL_BLUE.getBlock(), 0x00006b);
        this.registerColorProvidedBlock(BlockRegistry.D_WOOL_GREEN.getBlock(), 0x356500);
        this.registerColorProvidedBlock(BlockRegistry.D_WOOL_PURPLE.getBlock(), 0x5800a8);
        this.registerColorProvidedBlock(BlockRegistry.D_WOOL_WHITE.getBlock(), 0xffffff);
        this.registerColorProvidedBlock(BlockRegistry.D_WOOL_BLACK.getBlock(), 0x282828);
    }

    public void registerColorProvidedBlock(Block block, int colour) {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> colour, block);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> colour, block);
    }
}