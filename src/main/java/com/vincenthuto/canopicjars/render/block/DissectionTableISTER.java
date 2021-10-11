package com.vincenthuto.canopicjars.render.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.canopicjars.block.BlockDissectionAltar;
import com.vincenthuto.canopicjars.init.BlockInit;
import com.vincenthuto.canopicjars.tile.DissectionAltarBlockEntity;

import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

public class DissectionTableISTER extends BlockEntityWithoutLevelRenderer {

	private final BlockEntityRenderDispatcher blockEntityRenderDispatcher;
	@SuppressWarnings("unused")
	private final EntityModelSet entityModelSet;
	private final DissectionAltarBlockEntity bed = new DissectionAltarBlockEntity(BlockPos.ZERO,
			BlockInit.dissection_altar.get().defaultBlockState());

	public DissectionTableISTER(BlockEntityRenderDispatcher p_172550_, EntityModelSet p_172551_) {
		super(p_172550_, p_172551_);
		this.blockEntityRenderDispatcher = p_172550_;
		this.entityModelSet = p_172551_;
	}

	public void onResourceManagerReload(ResourceManager p_172555_) {
	}

	@Override
	public void renderByItem(ItemStack stack, ItemTransforms.TransformType transfrom, PoseStack matrices,
			MultiBufferSource buffer, int light1, int light2) {
		Item item = stack.getItem();
		if (item instanceof BlockItem) {
			Block block = ((BlockItem) item).getBlock();
			BlockEntity blockentity;
			if (block instanceof BlockDissectionAltar) {
				blockentity = this.bed;
				this.blockEntityRenderDispatcher.renderItem(blockentity, matrices, buffer, light1, light2);
			}

		}

	}

}