
package net.mcreator.auger.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class MindscrewItem extends Item {
	public MindscrewItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.auger.mindscrew.description_0"));
		list.add(Component.translatable("item.auger.mindscrew.description_1"));
		list.add(Component.translatable("item.auger.mindscrew.description_2"));
		list.add(Component.translatable("item.auger.mindscrew.description_3"));
	}
}
