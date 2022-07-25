package com.vincenthuto.canopicjars.init;

import com.vincenthuto.canopicjars.CanopicJars;
import com.vincenthuto.canopicjars.tile.ChiseledJarBlockEntity;
import com.vincenthuto.canopicjars.tile.DissectionAltarBlockEntity;
import com.vincenthuto.canopicjars.tile.ModSkullBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
	public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITIES, CanopicJars.MOD_ID);

	public static final RegistryObject<BlockEntityType<ModSkullBlockEntity>> mod_skull_block = TILES.register(
			"mod_skull_block",
			() -> BlockEntityType.Builder.of(ModSkullBlockEntity::new, BlockInit.sandstone_skull.get(),
					BlockInit.red_sandstone_skull.get(), BlockInit.player_sandstone_skull.get(),
					BlockInit.jackal_skull.get(), BlockInit.baboon_skull.get(), BlockInit.falcon_skull.get())
					.build(null));
	public static final RegistryObject<BlockEntityType<ChiseledJarBlockEntity>> chiseled_jar = TILES.register(
			"chiseled_jar",
			() -> BlockEntityType.Builder.of(ChiseledJarBlockEntity::new, BlockInit.stone_jar.get()).build(null));

	public static final RegistryObject<BlockEntityType<DissectionAltarBlockEntity>> dissection_altar = TILES
			.register("dissection_altar", () -> BlockEntityType.Builder
					.of(DissectionAltarBlockEntity::new, BlockInit.dissection_altar.get()).build(null));

}
