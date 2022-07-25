package com.vincenthuto.canopicjars.render.block;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.canopicjars.block.AbstractModSkullBlock;
import com.vincenthuto.canopicjars.tile.ModSkullBlockEntity;

import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class ModSkullISTER extends BlockEntityWithoutLevelRenderer {

	private Map<AbstractModSkullBlock.Type, SkullModelBase> skullModels;
	private final EntityModelSet entityModelSet;

	public ModSkullISTER(BlockEntityRenderDispatcher p_172550_, EntityModelSet p_172551_) {
		super(p_172550_, p_172551_);
		this.entityModelSet = p_172551_;
		this.skullModels = ModSkullRenderer.createSkullRenderers(this.entityModelSet);

	}

	public void onResourceManagerReload(ResourceManager p_172555_) {
		this.skullModels = ModSkullRenderer.createSkullRenderers(this.entityModelSet);
	}

	@Override
	public void renderByItem(ItemStack stack, ItemTransforms.TransformType transfrom, PoseStack matrices,
			MultiBufferSource buffer, int light1, int light2) {
		Item item = stack.getItem();
		if (item instanceof BlockItem) {
			Block block = ((BlockItem) item).getBlock();
			if (block instanceof AbstractModSkullBlock) {
				GameProfile gameprofile = null;
				if (stack.hasTag()) {
					CompoundTag compoundtag = stack.getTag();
					if (compoundtag.contains("SkullOwner", 10)) {
						gameprofile = NbtUtils.readGameProfile(compoundtag.getCompound("SkullOwner"));
					} else if (compoundtag.contains("SkullOwner", 8)
							&& !StringUtils.isBlank(compoundtag.getString("SkullOwner"))) {
						gameprofile = new GameProfile((UUID) null, compoundtag.getString("SkullOwner"));
						compoundtag.remove("SkullOwner");
						ModSkullBlockEntity.updateGameprofile(gameprofile, (p_172560_) -> {
							compoundtag.put("SkullOwner", NbtUtils.writeGameProfile(new CompoundTag(), p_172560_));
						});
					}
				}
				if (this.skullModels != null) {
					AbstractModSkullBlock.Type skullblock$type = ((AbstractModSkullBlock) block).getType();
					SkullModelBase skullmodelbase = this.skullModels.get(skullblock$type);
					RenderType rendertype = ModSkullRenderer.getRenderType(skullblock$type, gameprofile);
					ModSkullRenderer.renderSkull((Direction) null, 180.0F, 0.0F, matrices, buffer, light1,
							skullmodelbase, rendertype, skullblock$type);
				}
			}
		}
	}

}