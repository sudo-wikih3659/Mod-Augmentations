package net.mcreator.auger.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.auger.network.AugerModVariables;

public class PrisonPocketPickerRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_surgery_brain).is(ItemTags.create(new ResourceLocation("minecraft:logs")))) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = ((entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_surgery_brain).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				ItemStack _setval = ItemStack.EMPTY;
				entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_surgery_brain = _setval.copy();
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
