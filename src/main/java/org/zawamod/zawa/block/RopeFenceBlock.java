package org.zawamod.zawa.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class RopeFenceBlock extends Block implements IWaterLoggable {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty POST = BooleanProperty.create("pose");
    public static final BooleanProperty POST_TOP = BooleanProperty.create("post_top");
    public static final BooleanProperty SIDE = BooleanProperty.create("side");
    public static final BooleanProperty SIDE_TOP = BooleanProperty.create("side_top");
    public static final BooleanProperty SIDE_FULL = BooleanProperty.create("side_full");
    public static final BooleanProperty MID = BooleanProperty.create("mid");
    public static final BooleanProperty MID_TOP = BooleanProperty.create("mid_top");
    public static final BooleanProperty MID_FULL = BooleanProperty.create("mid_full");
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);

    public RopeFenceBlock() {
        super(Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD));
        this.setDefaultState(this.getStateContainer().getBaseState().with(WATERLOGGED, Boolean.FALSE)
                .with(POST, false).with(POST_TOP, false).with(SIDE, false).with(SIDE_TOP, false)
                .with(SIDE_FULL, false).with(MID, false).with(MID_TOP, false).with(MID_FULL, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }

    private boolean shouldConnect(BlockState state, boolean sideSolid, Direction facing) {
        Block block = state.getBlock();
        boolean flag = block instanceof FenceGateBlock && FenceGateBlock.isParallel(state, facing);
        return !cannotAttach(block) && sideSolid || block instanceof PaneBlock || flag;
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED))
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));

        worldIn.getBlockState(currentPos.up());

        if (facing == Direction.DOWN)
            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        else
            return idkFuckThisShit(worldIn, currentPos, stateIn, facingPos, facingState, facing);
    }

    private BlockState idkFuckThisShit(IWorldReader world, BlockPos currentPos, BlockState state, BlockPos facingPos, BlockState facingState, Direction facing) {
        Direction direction = facing.getOpposite();
        boolean flag = facing == Direction.NORTH && this.shouldConnect(facingState, facingState.isSolidSide(world, facingPos, direction), direction);
        boolean flag1 = facing == Direction.EAST && this.shouldConnect(facingState, facingState.isSolidSide(world, facingPos, direction), direction);
        boolean flag2 = facing == Direction.SOUTH && this.shouldConnect(facingState, facingState.isSolidSide(world, facingPos, direction), direction);
        boolean flag3 = facing == Direction.WEST && this.shouldConnect(facingState, facingState.isSolidSide(world, facingPos, direction), direction);
        BlockPos blockpos = currentPos.up();
        BlockState blockstate = world.getBlockState(blockpos);
        return this.func_235626_a_(world, state, blockpos, blockstate, flag, flag1, flag2, flag3);
    }

    private BlockState func_235626_a_(IWorldReader world, BlockState state, BlockPos collisionPos, BlockState collisionState, boolean connectedSouth, boolean connectedWest, boolean connectedNorth, boolean connectedEast) {
        VoxelShape voxelshape = collisionState.getCollisionShape(world, collisionPos).project(Direction.DOWN);
        BlockState blockstate = this.func_235630_a_(state, connectedSouth, connectedWest, connectedNorth, connectedEast, voxelshape);
        return blockstate.with(UP, Boolean.valueOf(this.func_235628_a_(blockstate, collisionState, voxelshape)));
    }

    private BlockState func_235630_a_(BlockState state, boolean connectedSouth, boolean connectedWest, boolean connectedNorth, boolean connectedEast, VoxelShape shape) {
        return state.with(WALL_HEIGHT_NORTH, this.func_235633_a_(connectedSouth, shape, WALL_CONNECTION_NORTH_SIDE_SHAPE)).with(WALL_HEIGHT_EAST, this.func_235633_a_(connectedWest, shape, WALL_CONNECTION_EAST_SIDE_SHAPE)).with(WALL_HEIGHT_SOUTH, this.func_235633_a_(connectedNorth, shape, WALL_CONNECTION_SOUTH_SIDE_SHAPE)).with(WALL_HEIGHT_WEST, this.func_235633_a_(connectedEast, shape, WALL_CONNECTION_WEST_SIDE_SHAPE));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, POST, POST_TOP, SIDE, SIDE_TOP, SIDE_FULL, MID, MID_TOP, MID_FULL);
    }
}
