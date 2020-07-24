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

public class Press extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.makeCuboidShape(1, 1, 0, 15, 9, 1),
            Block.makeCuboidShape(0, 1, 1, 1, 9, 15),
            Block.makeCuboidShape(15, 1, 1, 16, 9, 15),
            Block.makeCuboidShape(0, 9, 0, 16, 10, 15),
            Block.makeCuboidShape(2, 10, 2, 14, 11, 13),
            Block.makeCuboidShape(2, 17, 2, 14, 18, 13),
            Block.makeCuboidShape(3, 18, 3, 13, 31, 12),
            Block.makeCuboidShape(0, 0, 15, 16, 32, 16),
            Block.makeCuboidShape(15, 0, 0, 16, 9, 1),
            Block.makeCuboidShape(0, 0, 0, 1, 9, 1),
            Block.makeCuboidShape(1, 1, 1, 16, 1, 15),
            Block.makeCuboidShape(0, 16, 7, 1, 17, 19),
            Block.makeCuboidShape(0, 31, 0, 16, 32, 15),
            Block.makeCuboidShape(15, 17, 7, 16, 18, 19)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_EAST = Stream.of(
            Block.makeCuboidShape(15, 1, 1, 16, 9, 15),
            Block.makeCuboidShape(1, 1, 0, 15, 9, 1),
            Block.makeCuboidShape(1, 1, 15, 15, 9, 16),
            Block.makeCuboidShape(1, 9, 0, 16, 10, 16),
            Block.makeCuboidShape(3, 10, 2, 14, 11, 14),
            Block.makeCuboidShape(3, 17, 2, 14, 18, 14),
            Block.makeCuboidShape(4, 18, 3, 13, 31, 13),
            Block.makeCuboidShape(0, 0, 0, 1, 32, 16),
            Block.makeCuboidShape(15, 0, 15, 16, 9, 16),
            Block.makeCuboidShape(15, 0, 0, 16, 9, 1),
            Block.makeCuboidShape(1, 1, 1, 15, 1, 16),
            Block.makeCuboidShape(-3, 16, 0, 9, 17, 1),
            Block.makeCuboidShape(1, 31, 0, 16, 32, 16),
            Block.makeCuboidShape(-3, 17, 15, 9, 18, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_SOUTH = Stream.of(
            Block.makeCuboidShape(1, 1, 15, 15, 9, 16),
            Block.makeCuboidShape(15, 1, 1, 16, 9, 15),
            Block.makeCuboidShape(0, 1, 1, 1, 9, 15),
            Block.makeCuboidShape(0, 9, 1, 16, 10, 16),
            Block.makeCuboidShape(2, 10, 3, 14, 11, 14),
            Block.makeCuboidShape(2, 17, 3, 14, 18, 14),
            Block.makeCuboidShape(3, 18, 4, 13, 31, 13),
            Block.makeCuboidShape(0, 0, 0, 16, 32, 1),
            Block.makeCuboidShape(0, 0, 15, 1, 9, 16),
            Block.makeCuboidShape(15, 0, 15, 16, 9, 16),
            Block.makeCuboidShape(0, 1, 1, 15, 1, 15),
            Block.makeCuboidShape(15, 16, -3, 16, 17, 9),
            Block.makeCuboidShape(0, 31, 1, 16, 32, 16),
            Block.makeCuboidShape(0, 17, -3, 1, 18, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_WEST= Stream.of(
            Block.makeCuboidShape(0, 1, 1, 1, 9, 15),
            Block.makeCuboidShape(1, 1, 15, 15, 9, 16),
            Block.makeCuboidShape(1, 1, 0, 15, 9, 1),
            Block.makeCuboidShape(0, 9, 0, 15, 10, 16),
            Block.makeCuboidShape(2, 10, 2, 13, 11, 14),
            Block.makeCuboidShape(2, 17, 2, 13, 18, 14),
            Block.makeCuboidShape(3, 18, 3, 12, 31, 13),
            Block.makeCuboidShape(15, 0, 0, 16, 32, 16),
            Block.makeCuboidShape(0, 0, 0, 1, 9, 1),
            Block.makeCuboidShape(0, 0, 15, 1, 9, 16),
            Block.makeCuboidShape(1, 1, 0, 15, 1, 15),
            Block.makeCuboidShape(7, 16, 15, 19, 17, 16),
            Block.makeCuboidShape(0, 31, 0, 15, 32, 16),
            Block.makeCuboidShape(7, 17, 0, 19, 18, 1)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Press() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.METAL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
                .sound(SoundType.LANTERN)
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