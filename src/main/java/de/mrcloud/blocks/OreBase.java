package de.mrcloud.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class OreBase extends OreBlock {
    public OreBase(Material mat, float hardness, float resistance, SoundType sound, int harvestLevel, ToolType tool) {
        super(Block.Properties.create(mat)
                .hardnessAndResistance(hardness, resistance)
                .sound(sound)
                .harvestLevel(harvestLevel)
                .harvestTool(tool)
                .setRequiresTool()
        );
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        return 1;
    }
}
