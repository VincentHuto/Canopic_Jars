package com.vincenthuto.canopicjars.data;

import com.vincenthuto.canopicjars.CanopicJars;
import com.vincenthuto.canopicjars.init.BlockInit;
import com.vincenthuto.canopicjars.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fmllegacy.RegistryObject;

public class GeneratorItemModels extends ItemModelProvider {
	public GeneratorItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, CanopicJars.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		// Our block items

		for (RegistryObject<Block> b : BlockInit.BLOCKS.getEntries()) {
			registerBlockModel(b.get());
		}
		
		for (RegistryObject<Block> b : BlockInit.MODELEDBLOCKS.getEntries()) {
			registerBlockModel(b.get());
		}

		for (RegistryObject<Item> item : ItemInit.ITEMS.getEntries()) {
			basicIcon(item);
		}
	}

	private void registerBlockModel(Block block) {
		String path = block.getRegistryName().getPath();
		getBuilder(path).parent(new ModelFile.UncheckedModelFile(modLoc("block/" + path)));
	}

	private ItemModelBuilder basicIcon(RegistryObject<Item> item) {
		return getBuilder(item.getId().getPath()).parent(new ModelFile.UncheckedModelFile("item/generated"))
				.texture("layer0", new ResourceLocation(CanopicJars.MOD_ID, "item/" + item.getId().getPath()));
	}

	@Override
	public String getName() {
		return "Item Models";
	}
}