package net.mcreator.auger.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.auger.network.AugerModVariables;

public class AnethesizedEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.player_isanesthetized = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
