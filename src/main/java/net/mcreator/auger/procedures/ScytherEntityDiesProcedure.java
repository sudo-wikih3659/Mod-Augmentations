package net.mcreator.auger.procedures;

import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;

import net.mcreator.auger.network.AugerModVariables;

public class ScytherEntityDiesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_bandwidth_consumed
					- 0;
			(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.player_bandwidth_consumed = _setval;
				capability.syncPlayerVariables((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null));
			});
		}
	}
}
