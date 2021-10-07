package com.vincenthuto.canopicjars.init;

import com.vincenthuto.canopicjars.CanopicJars;
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

	public static final RegistryObject<Block> stone_jar = MODELEDBLOCKS.register("stone_jar",
			() -> new BlockStoneJar(BlockBehaviour.Properties.of(Material.STONE).strength(50f, 1500f).sound(SoundType.STONE)));

//	public static final RegistryObject<Block> venous_stone = BLOCKS.register("venous_stone",
//			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE)
//					.requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
//	

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		if (FMLEnvironment.dist == Dist.CLIENT) {
			ItemBlockRenderTypes.setRenderLayer(BlockInit.stone_jar.get(), RenderType.translucent());

		}
	}

}
