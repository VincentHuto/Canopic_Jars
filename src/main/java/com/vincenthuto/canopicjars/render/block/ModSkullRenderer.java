package com.vincenthuto.canopicjars.render.block;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.canopicjars.CanopicJars;
import com.vincenthuto.canopicjars.block.AbstractModSkullBlock;
import com.vincenthuto.canopicjars.block.BlockModSkull;
import com.vincenthuto.canopicjars.block.WallBlockModSkull;
import com.vincenthuto.canopicjars.init.ModelLayersInit;
import com.vincenthuto.canopicjars.tile.ModSkullBlockEntity;

import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;

public class ModSkullRenderer implements BlockEntityRenderer<ModSkullBlockEntity> {
	private final Map<AbstractModSkullBlock.Type, SkullModelBase> modelByType;
	private static final Map<AbstractModSkullBlock.Type, ResourceLocation> SKIN_BY_TYPE = Util.make(Maps.newHashMap(),
			(p_112552_) -> {
				p_112552_.put(AbstractModSkullBlock.Types.PLAYER, DefaultPlayerSkin.getDefaultSkin());
				p_112552_.put(AbstractModSkullBlock.Types.SANDSTONE,
						new ResourceLocation(CanopicJars.MOD_ID, "textures/entity/skulls/sandstone.png"));
				p_112552_.put(AbstractModSkullBlock.Types.REDSANDSTONE,
						new ResourceLocation(CanopicJars.MOD_ID, "textures/entity/skulls/red_sandstone.png"));

			});

	public static Map<AbstractModSkullBlock.Type, SkullModelBase> createSkullRenderers(EntityModelSet p_173662_) {
		Builder<AbstractModSkullBlock.Type, SkullModelBase> builder = ImmutableMap.builder();
		builder.put(AbstractModSkullBlock.Types.PLAYER, new SkullModel(p_173662_.bakeLayer(ModelLayers.PLAYER_HEAD)));
		builder.put(AbstractModSkullBlock.Types.SANDSTONE,
				new SkullModel(p_173662_.bakeLayer(ModelLayersInit.sandstone)));
		builder.put(AbstractModSkullBlock.Types.REDSANDSTONE,
				new SkullModel(p_173662_.bakeLayer(ModelLayersInit.red_sandstone)));
		return builder.build();
	}

	public ModSkullRenderer(BlockEntityRendererProvider.Context p_173660_) {
		this.modelByType = createSkullRenderers(p_173660_.getModelSet());
	}

	public void render(ModSkullBlockEntity te, float p_112535_, PoseStack ms, MultiBufferSource buffer, int p_112538_,
			int p_112539_) {
		float f = te.getMouthAnimation(p_112535_);
		BlockState blockstate = te.getBlockState();
		boolean flag = blockstate.getBlock() instanceof WallBlockModSkull;
		Direction direction = flag ? blockstate.getValue(WallBlockModSkull.FACING) : null;
		float f1 = 22.5F
				* (float) (flag ? (2 + direction.get2DDataValue()) * 4 : blockstate.getValue(BlockModSkull.ROTATION));
		AbstractModSkullBlock.Type skullblock$type = ((AbstractModSkullBlock) blockstate.getBlock()).getType();
		SkullModelBase skullmodelbase = this.modelByType.get(skullblock$type);
		RenderType rendertype = getRenderType(skullblock$type, te.getOwnerProfile());
		renderSkull(direction, f1, f, ms, buffer, p_112538_, skullmodelbase, rendertype, skullblock$type);
	}

	public static void renderSkull(@Nullable Direction dir, float p_173665_, float p_173666_, PoseStack ms,
			MultiBufferSource buffer, int light, SkullModelBase skullmodel, RenderType rendertype,AbstractModSkullBlock.Type skullblock$type) {
		ms.pushPose();
		if (dir == null) {
			ms.translate(0.5D, 0.0D, 0.5D);
		} else {
			float f = 0.725F;
			ms.translate((double) (0.5F - (float) dir.getStepX() * f), f, (double) (0.5F - (float) dir.getStepZ() * f));
		}

		ms.scale(-1.0F, -1.0F, 1.0F);
		VertexConsumer vertexconsumer = buffer.getBuffer(rendertype);
		skullmodel.setupAnim(p_173666_, p_173665_, 0.0F);
		if(skullblock$type == AbstractModSkullBlock.Types.PLAYER) {
			skullmodel.renderToBuffer(ms, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 0.60F, 0.5F, 0.0F, 1.0F);
		}else {
			skullmodel.renderToBuffer(ms, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		}
		ms.popPose();
	}

	public static RenderType getRenderType(AbstractModSkullBlock.Type type, @Nullable GameProfile profile) {
		ResourceLocation resourcelocation = SKIN_BY_TYPE.get(type);
		if (type == AbstractModSkullBlock.Types.PLAYER && profile != null) {
			Minecraft minecraft = Minecraft.getInstance();
			Map<Type, MinecraftProfileTexture> map = minecraft.getSkinManager().getInsecureSkinInformation(profile);
			return map.containsKey(Type.SKIN)
					? RenderType.entityTranslucent(
							minecraft.getSkinManager().registerTexture(map.get(Type.SKIN), Type.SKIN))
					: RenderType.entityCutoutNoCull(DefaultPlayerSkin.getDefaultSkin(Player.createPlayerUUID(profile)));
		} else {
			return RenderType.entityCutoutNoCullZOffset(resourcelocation);
		}
	}
}