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

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

/**
 * @author Jamalam360
 */
public class DesignerBlockSettings {
    public static FabricBlockSettings getWoolSettings() {
        return FabricBlockSettings.of(Material.WOOL).strength(0.8F).sounds(BlockSoundGroup.WOOL);
    }

    public static FabricBlockSettings getBricksSettings() {
        return FabricBlockSettings.of(Material.STONE).strength(3, 7).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).breakByTool(FabricToolTags.PICKAXES).requiresTool();
    }

    public static FabricBlockSettings getStoneSettings() {
        return FabricBlockSettings.of(Material.STONE).strength(2, 4).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).breakByTool(FabricToolTags.PICKAXES).requiresTool();
    }

    public static FabricBlockSettings getGlassSettings() {
        return FabricBlockSettings.of(Material.GLASS).strength(0.3F).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning(DesignerBlockSettings::never).solidBlock(DesignerBlockSettings::never).suffocates(DesignerBlockSettings::never).blockVision(DesignerBlockSettings::never);
    }

    public static FabricBlockSettings getWoodSettings() {
        return FabricBlockSettings.of(Material.WOOD).strength(2, 4).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES);
    }

    public static FabricBlockSettings getLeavesSettings() {
        return FabricBlockSettings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(DesignerBlockSettings::canSpawnOnLeaves).suffocates(DesignerBlockSettings::never).blockVision(DesignerBlockSettings::never);
    }

    public static FabricBlockSettings getPlanksSettings() {
        return FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES);
    }

    public static FabricBlockSettings getPlantSettings() {
        return FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS);
    }

    public static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    public static Boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }

    private static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }
}
