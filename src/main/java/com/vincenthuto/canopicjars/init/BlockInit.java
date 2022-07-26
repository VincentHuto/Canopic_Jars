package com.vincenthuto.canopicjars.init;

import com.vincenthuto.canopicjars.CanopicJars;
import com.vincenthuto.canopicjars.block.AbstractModSkullBlock;
import com.vincenthuto.canopicjars.block.BlockChiseledJar;
import com.vincenthuto.canopicjars.block.BlockDissectionAltar;
import com.vincenthuto.canopicjars.block.BlockModSkull;
import com.vincenthuto.canopicjars.block.BlockStoneJar;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = CanopicJars.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			CanopicJars.MOD_ID);
	public static final DeferredRegister<Block> MODELEDBLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			CanopicJars.MOD_ID);

	public static final DeferredRegister<Block> SKULLBLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			CanopicJars.MOD_ID);
	
	public static final DeferredRegister<Block> ALTARBLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			CanopicJars.MOD_ID);

	
	public static final RegistryObject<Block> dissection_altar = ALTARBLOCKS.register("dissection_altar",
			() -> new BlockDissectionAltar(
					BlockBehaviour.Properties.of(Material.STONE).strength(50f, 1500f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> sandstone_jar = MODELEDBLOCKS.register("sandstone_jar", () -> new BlockStoneJar(
			BlockBehaviour.Properties.of(Material.STONE).strength(50f, 1500f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> chiseled_sandstone_jar = MODELEDBLOCKS.register("chiseled_sandstone_jar",
			() -> new BlockChiseledJar(
					BlockBehaviour.Properties.of(Material.STONE).strength(50f, 1500f).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> viable_sandstone_jar = MODELEDBLOCKS.register("viable_sandstone_jar",
			() -> new BlockChiseledJar(
					BlockBehaviour.Properties.of(Material.STONE).strength(50f, 1500f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> sandstone_skull = registerSkull("sandstone_skull",
			AbstractModSkullBlock.Types.SANDSTONE);

	public static final RegistryObject<Block> red_sandstone_skull = registerSkull("red_sandstone_skull",
			AbstractModSkullBlock.Types.REDSANDSTONE);

	public static final RegistryObject<Block> player_sandstone_skull = registerSkull("player_sandstone_skull",
			AbstractModSkullBlock.Types.PLAYER);

	public static final RegistryObject<Block> jackal_skull = registerSkull("jackal_skull",
			AbstractModSkullBlock.Types.JACKAL);

	public static final RegistryObject<Block> falcon_skull = registerSkull("falcon_skull",
			AbstractModSkullBlock.Types.FALCON);

	public static final RegistryObject<Block> baboon_skull = registerSkull("baboon_skull",
			AbstractModSkullBlock.Types.BABOON);

	public static RegistryObject<Block> registerSkull(String name, AbstractModSkullBlock.Types type) {
		return SKULLBLOCKS.register(name,
				() -> new BlockModSkull(type, BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));
	}

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		if (FMLEnvironment.dist == Dist.CLIENT) {
			ItemBlockRenderTypes.setRenderLayer(BlockInit.sandstone_jar.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(BlockInit.chiseled_sandstone_jar.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(BlockInit.viable_sandstone_jar.get(), RenderType.translucent());

		}
	}

}
