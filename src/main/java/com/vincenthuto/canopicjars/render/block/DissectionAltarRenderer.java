package com.vincenthuto.canopicjars.render.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.vincenthuto.canopicjars.CanopicJars;
import com.vincenthuto.canopicjars.block.BlockDissectionAltar;
import com.vincenthuto.canopicjars.init.BlockEntityInit;
import com.vincenthuto.canopicjars.init.ModelLayersInit;
import com.vincenthuto.canopicjars.tile.DissectionAltarBlockEntity;

import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;

public class DissectionAltarRenderer implements BlockEntityRenderer<DissectionAltarBlockEntity> {
	private final ModelPart headRoot;
	private final ModelPart footRoot;

	public DissectionAltarRenderer(BlockEntityRendererProvider.Context p_173540_) {
		this.headRoot = p_173540_.bakeLayer(ModelLayersInit.altar_head);
		this.footRoot = p_173540_.bakeLayer(ModelLayersInit.altar_foot);
	}

	public static LayerDefinition createHeadLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(0, 21)
						.addBox(0.0F, -24.0F, -3.0F, 16.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(38, 39)
						.addBox(3.0F, -23.0F, -5.0F, 10.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(40, 0)
						.addBox(0.0F, -24.0F, 7.0F, 16.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(1.0F, -23.0F, 1.0F, 14.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(40, 25)
						.addBox(13.75F, -23.75F, 1.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(36, 17)
						.addBox(0.25F, -23.75F, 1.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public static LayerDefinition createFootLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(0, 100)
						.addBox(0.0F, -24.0F, -3.0F, 16.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(38, 98)
						.addBox(3.0F, -13.0F, -4.0F, 10.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(40, 79)
						.addBox(0.0F, -24.0F, 7.0F, 16.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 79)
						.addBox(1.0F, -24.0F, 1.0F, 14.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(16, 120)
						.addBox(13.75F, -10.25F, 1.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 120)
						.addBox(0.25F, -10.25F, 1.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(40, 103)
						.addBox(13.75F, -25.0F, 1.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(34, 114)
						.addBox(0.25F, -25.0F, 1.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void render(DissectionAltarBlockEntity p_112205_, float p_112206_, PoseStack p_112207_,
			MultiBufferSource p_112208_, int p_112209_, int p_112210_) {
//		Material material = Sheets.BED_TEXTURES[DyeColor.BLACK.getId()];

		Material material = new Material(TextureAtlas.LOCATION_BLOCKS,
				new ResourceLocation(CanopicJars.MOD_ID, "block/dissection_altar"));

		Level level = p_112205_.getLevel();
		if (level != null) {
			BlockState blockstate = p_112205_.getBlockState();
			DoubleBlockCombiner.NeighborCombineResult<? extends DissectionAltarBlockEntity> neighborcombineresult = DoubleBlockCombiner
					.combineWithNeigbour(BlockEntityInit.dissection_altar.get(), BlockDissectionAltar::getBlockType,
							BlockDissectionAltar::getConnectedDirection, ChestBlock.FACING, blockstate, level,
							p_112205_.getBlockPos(), (p_112202_, p_112203_) -> {
								return false;
							});
			int i = neighborcombineresult.<Int2IntFunction>apply(new BrightnessCombiner<>()).get(p_112209_);
			this.renderPiece(p_112207_, p_112208_,
					blockstate.getValue(BlockDissectionAltar.PART) == BedPart.HEAD ? this.headRoot : this.footRoot,
					blockstate.getValue(BlockDissectionAltar.FACING), material, i, p_112210_, false);
		} else {
			this.renderPiece(p_112207_, p_112208_, this.headRoot, Direction.SOUTH, material, p_112209_, p_112210_,
					false);
			this.renderPiece(p_112207_, p_112208_, this.footRoot, Direction.SOUTH, material, p_112209_, p_112210_,
					true);
		}

	}

	private void renderPiece(PoseStack p_173542_, MultiBufferSource p_173543_, ModelPart p_173544_, Direction p_173545_,
			Material p_173546_, int p_173547_, int p_173548_, boolean p_173549_) {
		p_173542_.pushPose();
		p_173542_.translate(0.0D, 0.5625D, p_173549_ ? -1.0D : 0.0D);
		p_173542_.mulPose(Vector3f.XP.rotationDegrees(90.0F));
		p_173542_.translate(0.5D, 0.5D, 0.5D);
		p_173542_.mulPose(Vector3f.ZP.rotationDegrees(180.0F + p_173545_.toYRot()));
		p_173542_.translate(-0.5D, -0.5D, -0.5D);
		VertexConsumer vertexconsumer = p_173546_.buffer(p_173543_, RenderType::entitySolid);
		p_173544_.render(p_173542_, vertexconsumer, p_173547_, p_173548_);
		p_173542_.popPose();
	}
}