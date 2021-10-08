package com.vincenthuto.canopicjars.init;

import com.vincenthuto.canopicjars.CanopicJars;

import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CanopicJars.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModelLayersInit {

	public static final ModelLayerLocation sandstone = new ModelLayerLocation(
			new ResourceLocation(CanopicJars.MOD_ID, "sandstone"), "main");

	public static final ModelLayerLocation red_sandstone = new ModelLayerLocation(
			new ResourceLocation(CanopicJars.MOD_ID, "red_sandstone"), "main");

	@SubscribeEvent
	public static void registerModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(sandstone, SkullModel::createMobHeadLayer);
		event.registerLayerDefinition(red_sandstone, SkullModel::createMobHeadLayer);
	}

}
