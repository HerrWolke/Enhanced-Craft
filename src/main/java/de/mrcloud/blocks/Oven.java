package de.mrcloud.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class Oven extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.makeCuboidShape(6, 11, 14, 9, 17, 16),
            Block.makeCuboidShape(1, 0, 15, 2, 2, 16),
            Block.makeCuboidShape(1, 1, 14, 2, 2, 15),
            Block.makeCuboidShape(14, 1, 1, 15, 2, 2),
            Block.makeCuboidShape(14, 0, 0, 15, 2, 1),
            Block.makeCuboidShape(14, 1, 14, 15, 2, 15),
            Block.makeCuboidShape(14, 0, 15, 15, 2, 16),
            Block.makeCuboidShape(1, 1, 1, 2, 2, 2),
            Block.makeCuboidShape(1, 0, 0, 2, 2, 1),
            Block.makeCuboidShape(1, 2, 1, 15, 10, 15),
            Block.makeCuboidShape(0, 10, 0, 16, 11, 16),
            Block.makeCuboidShape(1, 11, 1, 15, 12, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_EAST = Stream.of(
            Block.makeCuboidShape(0, 11, 6, 2, 17, 9),
            Block.makeCuboidShape(0, 0, 1, 1, 2, 2),
            Block.makeCuboidShape(1, 1, 1, 2, 2, 2),
            Block.makeCuboidShape(14, 1, 14, 15, 2, 15),
            Block.makeCuboidShape(15, 0, 14, 16, 2, 15),
            Block.makeCuboidShape(1, 1, 14, 2, 2, 15),
            Block.makeCuboidShape(0, 0, 14, 1, 2, 15),
            Block.makeCuboidShape(14, 1, 1, 15, 2, 2),
            Block.makeCuboidShape(15, 0, 1, 16, 2, 2),
            Block.makeCuboidShape(1, 2, 1, 15, 10, 15),
            Block.makeCuboidShape(0, 10, 0, 16, 11, 16),
            Block.makeCuboidShape(0, 11, 1, 15, 12, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_SOUTH = Stream.of(
            Block.makeCuboidShape(7, 11, 0, 10, 17, 2),
            Block.makeCuboidShape(14, 0, 0, 15, 2, 1),
            Block.makeCuboidShape(14, 1, 1, 15, 2, 2),
            Block.makeCuboidShape(1, 1, 14, 2, 2, 15),
            Block.makeCuboidShape(1, 0, 15, 2, 2, 16),
            Block.makeCuboidShape(1, 1, 1, 2, 2, 2),
            Block.makeCuboidShape(1, 0, 0, 2, 2, 1),
            Block.makeCuboidShape(14, 1, 14, 15, 2, 15),
            Block.makeCuboidShape(14, 0, 15, 15, 2, 16),
            Block.makeCuboidShape(1, 2, 1, 15, 10, 15),
            Block.makeCuboidShape(0, 10, 0, 16, 11, 16),
            Block.makeCuboidShape(1, 11, 0, 15, 12, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_WEST= Stream.of(
            Block.makeCuboidShape(14, 11, 7, 16, 17, 10),
            Block.makeCuboidShape(15, 0, 14, 16, 2, 15),
            Block.makeCuboidShape(14, 1, 14, 15, 2, 15),
            Block.makeCuboidShape(1, 1, 1, 2, 2, 2),
            Block.makeCuboidShape(0, 0, 1, 1, 2, 2),
            Block.makeCuboidShape(14, 1, 1, 15, 2, 2),
            Block.makeCuboidShape(15, 0, 1, 16, 2, 2),
            Block.makeCuboidShape(1, 1, 14, 2, 2, 15),
            Block.makeCuboidShape(0, 0, 14, 1, 2, 15),
            Block.makeCuboidShape(1, 2, 1, 15, 10, 15),
            Block.makeCuboidShape(0, 10, 0, 16, 11, 16),
            Block.makeCuboidShape(1, 11, 1, 16, 12, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Oven() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.METAL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
                .sound(SoundType.ANVIL)
        );
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING,context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_NORTH;
            case EAST:
                return SHAPE_EAST;
            case SOUTH:
                return SHAPE_SOUTH;
            case WEST:
                return SHAPE_WEST;
            default:
                return SHAPE_NORTH;
        }
    }



    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING,rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));

    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6F;
    }
}