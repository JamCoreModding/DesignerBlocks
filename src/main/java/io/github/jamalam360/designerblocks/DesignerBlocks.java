package io.github.jamalam360.designerblocks;

import io.github.jamalam360.libjam.registry.LibJamRegistry;
import net.fabricmc.api.ModInitializer;

public class DesignerBlocks implements ModInitializer {
    public static final String MOD_ID = "designerblocks";

    @Override
    public void onInitialize() {
        DesignerWorldGen.setupShitJavaIsFuckingStupidSoYouHaveToCallThisToLoadTheClassBeforeUsage();
        new LibJamRegistry(MOD_ID, BlockRegistry.class);
        DesignerWorldGen.register();
    }
}
