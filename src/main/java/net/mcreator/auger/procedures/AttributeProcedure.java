package net.mcreator.auger.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.auger.network.AugerModVariables;
import net.mcreator.auger.init.AugerModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AttributeProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (20 <= AugerModVariables.MapVariables.get(world).lag_timer) {
			if ((entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_ability_cooldown > 0) {
				{
					double _setval = (entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_ability_cooldown - 1;
					entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.player_ability_cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			AugerModVariables.MapVariables.get(world).lag_timer = 0;
			AugerModVariables.MapVariables.get(world).syncData(world);
			if (((entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_surgery_torso5).getItem() == AugerModItems.NUCLEAR_STOMACH.get()) {
				if (Math.random() < 0.1) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"effect give @p alexscaves:irradiated 3 0");
				}
				if (entity instanceof Player _player)
					_player.getFoodData().setSaturation(5);
			}
			if (!(((entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_surgery_torso5).getItem() == AugerModItems.NATURAL_STOMACH.get())) {
				if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.HUNGER)) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.HUNGER);
				}
			}
			if (!(((entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_surgery_arm1).getItem() == AugerModItems.NATURAL_ARM.get())) {
				if (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MobEffects.WEAKNESS)) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.WEAKNESS);
				}
			}
			if (!(((entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_surgery_arm2).getItem() == AugerModItems.NATURAL_ARM.get())) {
				if (entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(MobEffects.WEAKNESS)) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.WEAKNESS);
				}
			}
			if (!(((entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_surgery_leg1).getItem() == AugerModItems.NATURAL_LEG.get())) {
				if (entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
				}
			}
			if (!(((entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_surgery_leg2).getItem() == AugerModItems.NATURAL_LEG.get())) {
				if (entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
				}
			}
			if (((entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_surgery_eye).getItem() == AugerModItems.BIONIC_EYE.get()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 180, 1, false, false));
			}
			if (((entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_surgery_brain).getItem() == AugerModItems.ELDRITCH_BRAIN.get()) {
				if (Math.random() < 0.1) {
					if (entity instanceof Player _player)
						_player.causeFoodExhaustion((float) 0.1);
				}
			}
			if (((entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_surgery_torso3).getItem() == AugerModItems.AIR_BALLOON.get()) {
				if (entity.getY() <= -5) {
					if (Math.random() < 0.5) {
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1);
					}
				}
			}
		} else {
			AugerModVariables.MapVariables.get(world).lag_timer = 1 + AugerModVariables.MapVariables.get(world).lag_timer;
			AugerModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
