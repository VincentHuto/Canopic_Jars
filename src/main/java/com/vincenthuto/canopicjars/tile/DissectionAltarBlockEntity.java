package com.vincenthuto.canopicjars.tile;

import com.vincenthuto.canopicjars.init.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DissectionAltarBlockEntity extends BlockEntity {

	public DissectionAltarBlockEntity(BlockPos p_155115_, BlockState p_155116_) {
	      super(BlockEntityInit.dissection_altar.get(), p_155115_, p_155116_);
	   }

	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return new ClientboundBlockEntityDataPacket(this.worldPosition, 11, this.getUpdateTag());
	}

}