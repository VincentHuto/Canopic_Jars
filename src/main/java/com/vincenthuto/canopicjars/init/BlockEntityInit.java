package com.vincenthuto.canopicjars.init;

import com.vincenthuto.canopicjars.CanopicJars;
import com.vincenthuto.canopicjars.tile.ChiseledJarBlockEntity;
import com.vincenthuto.canopicjars.tile.ModSkullBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockEntityInit {
	public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITIES, CanopicJars.MOD_ID);

	public static final RegistryObject<BlockEntityType<ModSkullBlockEntity>> mod_skull_block = TILES
			.register("mod_skull_block",
					() -> BlockEntityType.Builder
							.of(ModSkullBlockEntity::new, BlockInit.sandstone_skull.get(),
									BlockInit.red_sandstone_skull.get(), BlockInit.player_sandstone_skull.get())
							.build(null));
	public static final RegistryObject<BlockEntityType<ChiseledJarBlockEntity>> chiseled_jar = TILES.register(
			"chiseled_jar",
			() -> BlockEntityType.Builder.of(ChiseledJarBlockEntity::new, BlockInit.stone_jar.get()).build(null));
}
