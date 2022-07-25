package com.vincenthuto.canopicjars.data;

import com.vincenthuto.canopicjars.CanopicJars;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = CanopicJars.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Generator {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		if (event.includeServer())
			registerServerProviders(event.getGenerator(), event);

		if (event.includeClient())
			registerClientProviders(event.getGenerator(), event);
	}

	@SuppressWarnings("unused")
	private static void registerServerProviders(DataGenerator generator, GatherDataEvent event) {
		ExistingFileHelper helper = event.getExistingFileHelper();
		generator.addProvider(new GeneratorRecipes(generator));
	}

	private static void registerClientProviders(DataGenerator generator, GatherDataEvent event) {
		ExistingFileHelper helper = event.getExistingFileHelper();
		ItemModelProvider itemModels = new GeneratorItemModels(generator, event.getExistingFileHelper());
		generator.addProvider(itemModels);
		generator.addProvider(new GeneratorBlockStates(generator, itemModels.existingFileHelper));
		generator.addProvider(new GeneratorLanguage(generator, helper));
	}
}