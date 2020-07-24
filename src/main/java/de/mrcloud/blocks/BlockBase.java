package de.mrcloud.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockBase extends Block {
    public BlockBase(Material mat, float hardness, float resistance, SoundType sound, int harvestLevel, ToolType tool) {
        super(Block.Properties.create(mat)
                .hardnessAndResistance(hardness, resistance)
                .sound(sound)
                .harvestLevel(harvestLevel)
                .harvestTool(tool)
                .setRequiresTool()
        );
    }
}
