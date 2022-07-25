package com.vincenthuto.canopicjars.data;

import java.util.function.Consumer;

import com.vincenthuto.canopicjars.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
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
//		
//		ShapedRecipeBuilder.shaped(BlockInit.hematic_iron_pillar.get(), 2)
//				.define('C', BlockInit.hematic_iron_block.get()).pattern("C").pattern("C")
//				.unlockedBy("has_hematic_iron_block", has(BlockInit.hematic_iron_block.get())).save(consumer);

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

		
	}
}
