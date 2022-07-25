package com.vincenthuto.canopicjars.data;

import com.vincenthuto.canopicjars.CanopicJars;
import com.vincenthuto.canopicjars.init.BlockInit;
import com.vincenthuto.canopicjars.init.ItemInit;
import com.vincenthuto.hutoslib.client.HLTextUtils;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class GeneratorLanguage extends LanguageProvider {
	public GeneratorLanguage(DataGenerator gen, ExistingFileHelper helper) {
		super(gen, CanopicJars.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		// Jei
	//	add("canopicjars.jei.recaller", "Visceral Recaller");
	//	add("canopicjars.jei.chisel_station", "Chisel Station");

		// Banner

	//	addArmBannerTranslation("leather");


//		addBannerTranslation("hemomancy_heart", "Vascularium");
//		addBannerTranslation("hemomancy_veins", "Veins");
	//	add("item.canopicjars.heart_pattern.desc", "Vascularium Crest");


		add("itemGroup.canopicjars", "Canopic Jars; Organ Storage");

		for (RegistryObject<Block> b : BlockInit.BLOCKS.getEntries()) {
			addBlock(b,
					HLTextUtils.convertInitToLang(b.get().asItem().getDescriptionId().replace("block.canopicjars.", "")));
		}
		
		for (RegistryObject<Block> b : BlockInit.MODELEDBLOCKS.getEntries()) {
			addBlock(b,
					HLTextUtils.convertInitToLang(b.get().asItem().getDescriptionId().replace("block.canopicjars.", "")));
		}

		for (RegistryObject<Block> b : BlockInit.SKULLBLOCKS.getEntries()) {
			addBlock(b,
					HLTextUtils.convertInitToLang(b.get().asItem().getDescriptionId().replace("block.canopicjars.", "")));
		}

		for (RegistryObject<Item> i : ItemInit.ITEMS.getEntries()) {
			addItem(i, HLTextUtils.convertInitToLang(i.get().asItem().getDescriptionId().replace("item.canopicjars.", "")));
		}


	}


	public void addBannerTranslation(String regName, String transName) {
		add("block.minecraft.banner." + regName + ".black", "Black " + transName);
		add("block.minecraft.banner." + regName + ".red", "Red " + transName);
		add("block.minecraft.banner." + regName + ".green", "Green " + transName);
		add("block.minecraft.banner." + regName + ".brown", "Brown " + transName);
		add("block.minecraft.banner." + regName + ".blue", "Blue " + transName);
		add("block.minecraft.banner." + regName + ".purple", "Purple " + transName);
		add("block.minecraft.banner." + regName + ".cyan", "Cyan " + transName);
		add("block.minecraft.banner." + regName + ".silver", "Light Gray " + transName);
		add("block.minecraft.banner." + regName + ".gray", "Gray " + transName);
		add("block.minecraft.banner." + regName + ".pink", "Pink " + transName);
		add("block.minecraft.banner." + regName + ".lime", "Lime " + transName);
		add("block.minecraft.banner." + regName + ".yellow", "Yellow " + transName);
		add("block.minecraft.banner." + regName + ".lightBlue", "Light " + transName);
		add("block.minecraft.banner." + regName + ".magenta", "Magenta " + transName);
		add("block.minecraft.banner." + regName + ".orange", "Orange " + transName);
		add("block.minecraft.banner." + regName + ".white", "White " + transName);
	}

	public void addArmBannerTranslation(String prefix) {
		add("item.canopicjars." + prefix + "_arm_banner.black",
				"Black " + HLTextUtils.convertInitToLang(prefix + "_arm_banner"));
		add("item.canopicjars." + prefix + "_arm_banner.red", "Red " + HLTextUtils.convertInitToLang("_arm_banner"));
		add("item.canopicjars." + prefix + "_arm_banner.green",
				"Green " + HLTextUtils.convertInitToLang(prefix + "_arm_banner"));
		add("item.canopicjars." + prefix + "_arm_banner.brown",
				"Brown " + HLTextUtils.convertInitToLang(prefix + "_arm_banner"));
		add("item.canopicjars." + prefix + "_arm_banner.blue",
				"Blue " + HLTextUtils.convertInitToLang(prefix + "_arm_banner"));
		add("item.canopicjars." + prefix + "_arm_banner.purple",
				"Purple " + HLTextUtils.convertInitToLang(prefix + "_arm_banner"));
		add("item.canopicjars." + prefix + "_arm_banner.cyan",
				"Cyan " + HLTextUtils.convertInitToLang(prefix + "_arm_banner"));
		add("item.canopicjars." + prefix + "_arm_banner.silver",
				"Light Gray " + HLTextUtils.convertInitToLang(prefix + "_arm_banner"));
		add("item.canopicjars." + prefix + "_arm_banner.gray",
				"Gray " + HLTextUtils.convertInitToLang(prefix + "_arm_banner"));
		add("item.canopicjars." + prefix + "_arm_banner.pink",
				"Pink " + HLTextUtils.convertInitToLang(prefix + "_arm_banner"));
		add("item.canopicjars." + prefix + "_arm_banner.lime",
				"Lime " + HLTextUtils.convertInitToLang(prefix + "_arm_banner"));
		add("item.canopicjars." + prefix + "_arm_banner.yellow",
				"Yellow " + HLTextUtils.convertInitToLang(prefix + "_arm_banner"));
		add("item.canopicjars." + prefix + "_arm_banner.lightBlue",
				"Light " + HLTextUtils.convertInitToLang(prefix + "_arm_banner"));
		add("item.canopicjars." + prefix + "_arm_banner.magenta",
				"Magenta " + HLTextUtils.convertInitToLang(prefix + "_arm_banner"));
		add("item.canopicjars." + prefix + "_arm_banner.orange",
				"Orange " + HLTextUtils.convertInitToLang(prefix + "_arm_banner"));
		add("item.canopicjars." + prefix + "_arm_banner.white",
				"White " + HLTextUtils.convertInitToLang(prefix + "_arm_banner"));
	}
}
