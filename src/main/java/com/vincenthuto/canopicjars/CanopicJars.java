package com.vincenthuto.canopicjars;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vincenthuto.canopicjars.block.DissectionAltarBlockItem;
import com.vincenthuto.canopicjars.block.ModSkullBlockItem;
import com.vincenthuto.canopicjars.init.BlockEntityInit;
import com.vincenthuto.canopicjars.init.BlockInit;
import com.vincenthuto.canopicjars.init.ItemInit;
import com.vincenthuto.canopicjars.render.block.ChiseledJarRenderer;
import com.vincenthuto.canopicjars.render.block.DissectionAltarRenderer;
import com.vincenthuto.canopicjars.render.block.ModSkullRenderer;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("canopicjars")
@Mod.EventBusSubscriber(modid = CanopicJars.MOD_ID, bus = Bus.MOD)
public class CanopicJars {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "canopicjars";

	public CanopicJars() {
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::clientSetup);
		modEventBus.addListener(this::commonSetup);
		modEventBus.addListener(this::onTextureStitch);
		ItemInit.ITEMS.register(modEventBus);
		BlockInit.BLOCKS.register(modEventBus);
		BlockInit.MODELEDBLOCKS.register(modEventBus);
		BlockInit.SKULLBLOCKS.register(modEventBus);
		BlockInit.ALTARBLOCKS.register(modEventBus);
		BlockEntityInit.TILES.register(modEventBus);
		MinecraftForge.EVENT_BUS.register(this);
	}

	// Automatically Registers BlockItems
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().tab(CanopicJarsItemGroup.instance);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});

		BlockInit.MODELEDBLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().tab(CanopicJarsItemGroup.instance);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});

		BlockInit.SKULLBLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().tab(CanopicJarsItemGroup.instance)
					.rarity(Rarity.UNCOMMON);
			final BlockItem blockItem = new ModSkullBlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});
		
		BlockInit.ALTARBLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().tab(CanopicJarsItemGroup.instance)
					.rarity(Rarity.EPIC);
			final BlockItem blockItem = new DissectionAltarBlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});

	}

	// Creative Tab
	public static class CanopicJarsItemGroup extends CreativeModeTab {
		public static final CanopicJarsItemGroup instance = new CanopicJarsItemGroup(CreativeModeTab.TABS.length,
				"canopicjars");

		public CanopicJarsItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ItemInit.ankh_charm.get());
		}
	}

	@SuppressWarnings("deprecation")
	public void onTextureStitch(TextureStitchEvent.Pre event) {
		if (event.getMap().location().equals(TextureAtlas.LOCATION_BLOCKS)) {
			System.out.println("STICHING");
		event.addSprite(new ResourceLocation(CanopicJars.MOD_ID, "block/dissection_altar"));
		}
	}

	private void clientSetup(final FMLClientSetupEvent event) {

		BlockEntityRenderers.register(BlockEntityInit.mod_skull_block.get(), ModSkullRenderer::new);
		BlockEntityRenderers.register(BlockEntityInit.chiseled_jar.get(), ChiseledJarRenderer::new);
		BlockEntityRenderers.register(BlockEntityInit.dissection_altar.get(), DissectionAltarRenderer::new);

	}

	private void commonSetup(final FMLCommonSetupEvent event) {

	}

}
