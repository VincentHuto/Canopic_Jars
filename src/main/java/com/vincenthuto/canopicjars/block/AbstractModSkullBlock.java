package com.vincenthuto.canopicjars.block;

import com.vincenthuto.canopicjars.tile.ModSkullBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

public abstract class AbstractModSkullBlock extends BaseEntityBlock implements Wearable {
	private final AbstractModSkullBlock.Type type;

	public AbstractModSkullBlock(AbstractModSkullBlock.Type p_48745_, BlockBehaviour.Properties p_48746_) {
		super(p_48746_);
		this.type = p_48745_;
	}

	public BlockEntity newBlockEntity(BlockPos p_151996_, BlockState p_151997_) {
		return new ModSkullBlockEntity(p_151996_, p_151997_);
	}

	public AbstractModSkullBlock.Type getType() {
		return this.type;
	}

	public boolean isPathfindable(BlockState p_48750_, BlockGetter p_48751_, BlockPos p_48752_,
			PathComputationType p_48753_) {
		return false;
	}

	public interface Type {
	}

	public static enum Types implements AbstractModSkullBlock.Type {
		SANDSTONE, REDSANDSTONE, PLAYER, BABOON, JACKAL, FALCON;
	}

}