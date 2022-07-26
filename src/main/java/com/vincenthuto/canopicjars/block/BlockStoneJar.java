package com.vincenthuto.canopicjars.block;

import java.util.stream.Stream;

import com.vincenthuto.canopicjars.init.BlockInit;
import com.vincenthuto.canopicjars.init.ItemInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockStoneJar extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	private static final VoxelShape SHAPE_N = Stream.of(Block.box(3.75, 6, 3.75, 12.25, 11, 12.25),
			Block.box(4, 11, 4, 12, 14, 12), Block.box(4, 0, 4, 12, 7, 12))
			.reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

	public BlockStoneJar(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.SOUTH));

	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
			BlockHitResult result) {

		worldIn.playSound(player, pos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 0.25f, 1f);
		ItemStack stack = player.getItemInHand(handIn);
		if (!player.isShiftKeyDown()) {
			if (stack.getItem() == ItemInit.reed_pen.get()) {
				worldIn.destroyBlock(pos, false);
				stack.hurtAndBreak(5 + worldIn.random.nextInt(3), player, (p_220017_1_) -> {
					p_220017_1_.broadcastBreakEvent(player.getUsedItemHand());
				});
				worldIn.setBlockAndUpdate(pos, BlockInit.chiseled_sandstone_jar.get().defaultBlockState());
			}
		}

		return InteractionResult.SUCCESS;

	}

	@Override
	public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_,
			CollisionContext p_60558_) {
		return SHAPE_N;
	}

	@Override
	public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
			boolean isMoving) {
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

//	@Override
//	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
//		return new BlockEntityVisceralRecaller(p_153215_, p_153216_);
//	}

}
