package com.vincenthuto.canopicjars.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class JackalSkullModel extends SkullModelBase {
	private final ModelPart root;
	protected final ModelPart head;

	public JackalSkullModel(ModelPart p_170945_) {
		this.root = p_170945_;
		this.head = p_170945_.getChild("head");
	}

	public static MeshDefinition createHeadModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-3.0F, -1.3711F, -1.5F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 14)
						.addBox(-3.0F, -3.3711F, 0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 14)
						.addBox(1.0F, -3.3711F, 0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 17)
						.addBox(1.5F, -4.3711F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 17)
						.addBox(-2.5F, -4.3711F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 10)
						.addBox(-1.5F, 1.6133F, -4.5F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -5, -0.5F));
		return meshdefinition;
	}

	public static LayerDefinition createMobHeadLayer() {
		MeshDefinition meshdefinition = createHeadModel();
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	public void setupAnim(float p_103811_, float p_103812_, float p_103813_) {
		this.head.yRot = p_103812_ * ((float) Math.PI / 180F);
		this.head.xRot = p_103813_ * ((float) Math.PI / 180F);
	}

	public void renderToBuffer(PoseStack p_103815_, VertexConsumer p_103816_, int p_103817_, int p_103818_,
			float p_103819_, float p_103820_, float p_103821_, float p_103822_) {
		this.root.render(p_103815_, p_103816_, p_103817_, p_103818_, p_103819_, p_103820_, p_103821_, p_103822_);
	}
}