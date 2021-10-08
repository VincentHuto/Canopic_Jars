package com.vincenthuto.canopicjars.block;

import java.util.function.Consumer;

import com.vincenthuto.canopicjars.render.block.ModSkullISTER;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.IItemRenderProperties;

public class ModSkullBlockItem extends BlockItem {

	public ModSkullBlockItem(Block p_40565_, Properties p_40566_) {
		super(p_40565_, p_40566_);
	}

	@Override
	public void initializeClient(Consumer<IItemRenderProperties> consumer) {
		super.initializeClient(consumer);
		consumer.accept(RenderProp.INSTANCE);

	}
}

class RenderProp implements IItemRenderProperties {

	public static RenderProp INSTANCE = new RenderProp();

	@SuppressWarnings("resource")
	@Override
	public Font getFont(ItemStack stack) {
		return Minecraft.getInstance().font;
	}

	@Override
	public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
		return new ModSkullISTER(Minecraft.getInstance().getBlockEntityRenderDispatcher(),
				Minecraft.getInstance().getEntityModels());
	}
}