package net.mcreator.auger.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.auger.network.AugerModVariables;
import net.mcreator.auger.init.AugerModAttributes;

public class DebugerRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + (entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_hasjoined)), false);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + AugerModVariables.MapVariables.get(world).lag_timer)), false);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + (entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_ability_cooldown)),
					false);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("bandwidth/bandwidthconsumed"), false);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
					("" + (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(AugerModAttributes.BANDWIDTH.get()) ? _livingEntity4.getAttribute(AugerModAttributes.BANDWIDTH.get()).getBaseValue() : 0))),
					false);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + (entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_bandwidth_consumed)),
					false);
	}
}
