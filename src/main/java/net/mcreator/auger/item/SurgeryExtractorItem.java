
package net.mcreator.auger.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SurgeryExtractorItem extends Item {
	public SurgeryExtractorItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
