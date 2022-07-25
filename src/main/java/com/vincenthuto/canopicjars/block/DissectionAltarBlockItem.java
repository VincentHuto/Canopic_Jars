package com.vincenthuto.canopicjars.block;

import java.util.function.Consumer;

import com.vincenthuto.canopicjars.render.block.DissectionTableISTER;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.IItemRenderProperties;

public class DissectionAltarBlockItem extends BlockItem {

	public DissectionAltarBlockItem(Block p_40565_, Properties p_40566_) {
		super(p_40565_, p_40566_);
	}

	@Override
	public void initializeClient(Consumer<IItemRenderProperties> consumer) {
		super.initializeClient(consumer);
		consumer.accept(RenderPropAltar.INSTANCE);

	}
}

class RenderPropAltar implements IItemRenderProperties {

	public static RenderPropAltar INSTANCE = new RenderPropAltar();

	@SuppressWarnings("resource")
	@Override
	public Font getFont(ItemStack stack) {
		return Minecraft.getInstance().font;
	}

	@Override
	public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
		return new DissectionTableISTER(Minecraft.getInstance().getBlockEntityRenderDispatcher(),
				Minecraft.getInstance().getEntityModels());
	}
}