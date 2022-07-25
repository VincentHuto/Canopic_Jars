package com.vincenthuto.canopicjars.item;

import com.vincenthuto.canopicjars.init.ItemInit;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemReedPen extends Item {

	public ItemReedPen(Properties prop) {
		super(prop.defaultDurability(128));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack mainhand = player.getItemInHand(InteractionHand.MAIN_HAND);
		ItemStack offhand = player.getItemInHand(InteractionHand.OFF_HAND);
		if (mainhand.getItem() == ItemInit.reed_pen.get()) {
			if (offhand.getItem() == ItemInit.ink_pot.get()) {
				mainhand.hurtAndBreak(5 + level.random.nextInt(3), player, (p_220017_1_) -> {
					p_220017_1_.broadcastBreakEvent(player.getUsedItemHand());
				});
				player.setItemInHand(InteractionHand.OFF_HAND, new ItemStack(ItemInit.doped_ink_pot.get(), 1));
			}
		}

		return super.use(level, player, hand);
	}
}
