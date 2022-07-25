package com.vincenthuto.canopicjars.data;

import com.vincenthuto.canopicjars.CanopicJars;
import com.vincenthuto.canopicjars.init.BlockInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

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

		for (RegistryObject<Block> b : BlockInit.MODELEDBLOCKS.getEntries()) {
			horizontalBlock(b.get(), models().getExistingFile(ModelLocationUtils.getModelLocation(b.get())));
		}
		
	}

}
