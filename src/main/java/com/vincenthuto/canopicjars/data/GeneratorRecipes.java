package com.vincenthuto.canopicjars.data;

import java.util.function.Consumer;

import com.vincenthuto.canopicjars.init.BlockInit;
import com.vincenthuto.canopicjars.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class GeneratorRecipes extends RecipeProvider {
	public GeneratorRecipes(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

//		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockInit.polished_venous_stone_bricks.get()),
//				BlockInit.cracked_polished_venous_stone_bricks.get(), 1f, 200);
//
//		ShapelessRecipeBuilder.shapeless(ItemInit.hematic_iron_scrap.get(), 4)
//				.requires(BlockInit.hematic_iron_block.get())
//				.unlockedBy("has_hematic_iron_block", has(BlockInit.hematic_iron_block.get())).save(consumer);
//
		
//Blocks
		ShapedRecipeBuilder.shaped(BlockInit.sandstone_jar.get(), 1)
			.define('R', Blocks.RED_SANDSTONE).define('S', Blocks.SANDSTONE).define('L', Blocks.SANDSTONE_SLAB)
			.pattern("LRL")
			.pattern("SSS")
			.pattern("SSS")
			.unlockedBy("has_red_stone", has(Blocks.RED_SANDSTONE)).save(consumer);
		
		
//Items
		
		ShapelessRecipeBuilder.shapeless(BlockInit.viable_sandstone_jar.get(),1)
		.requires(BlockInit.chiseled_sandstone_jar.get()).requires(ItemInit.ankh_charm.get()).requires(ItemInit.doped_ink_pot.get()).requires(ItemInit.papyrus.get())
		.unlockedBy("has_chiseled_sandstone_jar", has(BlockInit.chiseled_sandstone_jar.get())).save(consumer);
		
		ShapedRecipeBuilder.shaped(ItemInit.papyrus.get(), 3)
			.define('S', Blocks.SAND)		
			.define('C', Items.SUGAR_CANE)
			.pattern("CCC")
			.pattern("SSS")
			.unlockedBy("has_sugar_cane", has(Items.SUGAR_CANE)).save(consumer);

		ShapedRecipeBuilder.shaped(ItemInit.reed_pen.get(), 1)
			.define('S', Items.SUGAR_CANE)
			.pattern("  S")
			.pattern(" S ")
			.pattern("S  ")
			.unlockedBy("has_sugar_cane", has(Items.SUGAR_CANE)).save(consumer);

		
		ShapedRecipeBuilder.shaped(ItemInit.nasal_hook.get(), 1)
			.define('S', Items.STICK).define('I', Items.IRON_INGOT)
			.pattern("III")
			.pattern(" I ")
			.pattern("S  ")
			.unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(consumer);
		
		
		ShapedRecipeBuilder.shaped(ItemInit.ankh_charm.get(), 1)
			.define('T', Items.TOTEM_OF_UNDYING).define('A', Items.GOLDEN_APPLE)
			.define('M', Items.GLISTERING_MELON_SLICE).define('S', Items.SOUL_TORCH)
			.define('C', Items.GOLDEN_CARROT)
			.pattern(" A ")
			.pattern("CTM")
			.pattern(" S ")
			.unlockedBy("has_totem", has(Items.TOTEM_OF_UNDYING)).save(consumer);
		
		
	}
}
