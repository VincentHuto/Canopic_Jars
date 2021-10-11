package com.vincenthuto.canopicjars.init;

import com.vincenthuto.canopicjars.CanopicJars;
import com.vincenthuto.canopicjars.model.BaboonSkullModel;
import com.vincenthuto.canopicjars.model.FalconSkullModel;
import com.vincenthuto.canopicjars.model.JackalSkullModel;
import com.vincenthuto.canopicjars.render.block.DissectionAltarRenderer;

import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CanopicJars.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModelLayersInit {

	public static final ModelLayerLocation sandstone_skull = new ModelLayerLocation(
			new ResourceLocation(CanopicJars.MOD_ID, "sandstone_skull"), "main");

	public static final ModelLayerLocation red_sandstone_skull = new ModelLayerLocation(
			new ResourceLocation(CanopicJars.MOD_ID, "red_sandstone_skull"), "main");

	public static final ModelLayerLocation jackal_skull = new ModelLayerLocation(
			new ResourceLocation(CanopicJars.MOD_ID, "jackal_skull"), "main");

	public static final ModelLayerLocation falcon_skull = new ModelLayerLocation(
			new ResourceLocation(CanopicJars.MOD_ID, "falcon_skull"), "main");

	public static ModelLayerLocation baboon_skull = new ModelLayerLocation(
			new ResourceLocation(CanopicJars.MOD_ID, "baboon_skull"), "main");


	public static ModelLayerLocation altar_head = new ModelLayerLocation(
			new ResourceLocation(CanopicJars.MOD_ID, "altar_head"), "main");
	
	public static ModelLayerLocation altar_foot = new ModelLayerLocation(
			new ResourceLocation(CanopicJars.MOD_ID, "altar_foot"), "main");
	
	@SubscribeEvent
	public static void registerModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(sandstone_skull, SkullModel::createMobHeadLayer);
		event.registerLayerDefinition(red_sandstone_skull, SkullModel::createMobHeadLayer);
		event.registerLayerDefinition(jackal_skull, JackalSkullModel::createMobHeadLayer);
		event.registerLayerDefinition(falcon_skull, FalconSkullModel::createMobHeadLayer);
		event.registerLayerDefinition(baboon_skull, BaboonSkullModel::createMobHeadLayer);
		event.registerLayerDefinition(altar_head, DissectionAltarRenderer::createHeadLayer);
		event.registerLayerDefinition(altar_foot, DissectionAltarRenderer::createFootLayer);

	}

}
