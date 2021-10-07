package com.vincenthuto.canopicjars.init;

import com.vincenthuto.canopicjars.CanopicJars;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockEntityInit {
	public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITIES, CanopicJars.MOD_ID);

	
	
}
