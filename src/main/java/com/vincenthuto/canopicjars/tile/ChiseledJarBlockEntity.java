package com.vincenthuto.canopicjars.tile;

import com.vincenthuto.canopicjars.init.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ChiseledJarBlockEntity extends BlockEntity {

	public ChiseledJarBlockEntity(BlockPos p_155731_, BlockState p_155732_) {
		super(BlockEntityInit.chiseled_jar.get(), p_155731_, p_155732_);
	}

}