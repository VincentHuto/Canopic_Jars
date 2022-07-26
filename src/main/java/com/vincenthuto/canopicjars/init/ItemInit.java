package com.vincenthuto.canopicjars.init;

import com.vincenthuto.canopicjars.CanopicJars;
import com.vincenthuto.canopicjars.CanopicJars.CanopicJarsItemGroup;
import com.vincenthuto.canopicjars.item.ItemReedPen;
import com.vincenthuto.hutoslib.common.item.ModSpawnEggItem;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = CanopicJars.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			CanopicJars.MOD_ID);

	public static final RegistryObject<Item> papyrus = ITEMS.register("papyrus",
			() -> new Item(new Item.Properties().tab(CanopicJarsItemGroup.instance)));

	public static final RegistryObject<Item> reed_pen = ITEMS.register("reed_pen",
			() -> new ItemReedPen(new Item.Properties().tab(CanopicJarsItemGroup.instance).stacksTo(1)));
	public static final RegistryObject<Item> nasal_hook = ITEMS.register("nasal_hook",
			() -> new ItemReedPen(new Item.Properties().tab(CanopicJarsItemGroup.instance).stacksTo(1)));
	public static final RegistryObject<Item> ink_pot = ITEMS.register("ink_pot",
			() -> new Item(new Item.Properties().tab(CanopicJarsItemGroup.instance).stacksTo(1)));

	public static final RegistryObject<Item> doped_ink_pot = ITEMS.register("doped_ink_pot",
			() -> new Item(new Item.Properties().tab(CanopicJarsItemGroup.instance).stacksTo(1)));

	public static final RegistryObject<Item> sandstone_shard = ITEMS.register("sandstone_shard",
			() -> new Item(new Item.Properties().tab(CanopicJarsItemGroup.instance)));

	public static final RegistryObject<Item> ankh_charm = ITEMS.register("ankh_charm", () -> new Item(
			new Item.Properties().tab(CanopicJarsItemGroup.instance).stacksTo(1).rarity(Rarity.UNCOMMON)));

	@SubscribeEvent
	public static void registerItemColorHandlers(ColorHandlerEvent.Item event) {
	}

	@SuppressWarnings("unchecked")
	@SafeVarargs
	public static void registerSpawnEggColorHandler(ItemColors colors, RegistryObject<ModSpawnEggItem>... spawnEggs) {
		for (RegistryObject<ModSpawnEggItem> spawnEgg : spawnEggs) {
			registerItemColorHandler(colors, (stack, tintIndex) -> spawnEgg.get().getColor(tintIndex), spawnEgg);
		}
	}

	@SuppressWarnings("unchecked")
	public static void registerItemColorHandler(ItemColors colors, ItemColor itemColor,
			RegistryObject<ModSpawnEggItem>... items) {
		for (RegistryObject<ModSpawnEggItem> itemProvider : items) {
			colors.register(itemColor, itemProvider.get());
		}
	}

	// Item Property Override
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void itemPropOverrideClient(final FMLClientSetupEvent event) {

	}

}
