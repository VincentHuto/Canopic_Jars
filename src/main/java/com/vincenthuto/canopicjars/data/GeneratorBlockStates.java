package com.vincenthuto.canopicjars.data;

import com.vincenthuto.canopicjars.CanopicJars;
import com.vincenthuto.canopicjars.init.BlockInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fmllegacy.RegistryObject;

public class GeneratorBlockStates extends BlockStateProvider {
	public GeneratorBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, CanopicJars.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {

		for (RegistryObject<Block> b : BlockInit.BLOCKS.getEntries()) {
			simpleBlock(b.get());
			cubeAll(b.get());

		}
//		for (RegistryObject<Block> b : BlockInit.CROSSBLOCKS.getEntries()) {
//			String name = Registry.BLOCK.getKey(b.get()).getPath();
//			ModelFile model = models()
//					.withExistingParent(name, new ResourceLocation(Hemomancy.MOD_ID, "block/shapes/cross"))
//					.texture("cross", new ResourceLocation(Hemomancy.MOD_ID, "block/" + name));
//			simpleBlock(b.get(), model);
//		}

		/*
		 * for (RegistryObject<Block> b : BlockInit.MODELEDBLOCKS.getEntries()) {
		 * blockTexture(b.get()); }
		 * 
		 * for (RegistryObject<Block> b : BlockInit.COLUMNBLOCKS.getEntries()) {
		 * axisBlock((RotatedPillarBlock) b.get(), b.get().getRegistryName(), new
		 * ResourceLocation(Hemomancy.MOD_ID, b.get().getRegistryName().getPath() +
		 * "_end")); blockTexture(b.get());
		 * 
		 * }
		 */
	}

}
