package com.vincenthuto.canopicjars.init;

import com.vincenthuto.canopicjars.CanopicJars;
import com.vincenthuto.canopicjars.block.BlockChiseledJar;
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
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = CanopicJars.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			CanopicJars.MOD_ID);
	public static final DeferredRegister<Block> MODELEDBLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			CanopicJars.MOD_ID);

	public static final DeferredRegister<Block> SKULLBLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			CanopicJars.MOD_ID);

	public static final RegistryObject<Block> stone_jar = MODELEDBLOCKS.register("stone_jar", () -> new BlockStoneJar(
			BlockBehaviour.Properties.of(Material.STONE).strength(50f, 1500f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> chiseled_jar = MODELEDBLOCKS.register("chiseled_jar",
			() -> new BlockChiseledJar(
					BlockBehaviour.Properties.of(Material.STONE).strength(50f, 1500f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> sandstone_skull = SKULLBLOCKS.register("sandstone_skull",
			() -> new BlockModSkull(BlockModSkull.Types.SANDSTONE,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));

	public static final RegistryObject<Block> red_sandstone_skull = SKULLBLOCKS.register("red_sandstone_skull",
			() -> new BlockModSkull(BlockModSkull.Types.REDSANDSTONE,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));

	public static final RegistryObject<Block> player_sandstone_skull = SKULLBLOCKS.register("player_sandstone_skull",
			() -> new BlockModSkull(BlockModSkull.Types.PLAYER,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		if (FMLEnvironment.dist == Dist.CLIENT) {
			ItemBlockRenderTypes.setRenderLayer(BlockInit.stone_jar.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(BlockInit.chiseled_jar.get(), RenderType.translucent());
		}
	}

}
