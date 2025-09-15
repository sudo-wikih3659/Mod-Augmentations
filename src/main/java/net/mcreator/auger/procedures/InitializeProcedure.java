package net.mcreator.auger.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.auger.network.AugerModVariables;
import net.mcreator.auger.init.AugerModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class InitializeProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_hasjoined) {
			{
				ItemStack _setval = new ItemStack(AugerModItems.NATURAL_BRAIN.get());
				entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_surgery_brain = _setval.copy();
					capability.syncPlayerVariables(entity);
				});
			}
			{
				ItemStack _setval = new ItemStack(AugerModItems.NATURAL_EYES.get());
				entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_surgery_eye = _setval.copy();
					capability.syncPlayerVariables(entity);
				});
			}
			{
				ItemStack _setval = new ItemStack(AugerModItems.NATURAL_HEAD.get());
				entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_surgery_head = _setval.copy();
					capability.syncPlayerVariables(entity);
				});
			}
			{
				ItemStack _setval = new ItemStack(AugerModItems.NATURAL_ARM.get());
				entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_surgery_arm1 = _setval.copy();
					capability.syncPlayerVariables(entity);
				});
			}
			{
				ItemStack _setval = new ItemStack(AugerModItems.NATURAL_ARM.get());
				entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_surgery_arm2 = _setval.copy();
					capability.syncPlayerVariables(entity);
				});
			}
			{
				ItemStack _setval = new ItemStack(AugerModItems.NATURAL_LEG.get());
				entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_surgery_leg1 = _setval.copy();
					capability.syncPlayerVariables(entity);
				});
			}
			{
				ItemStack _setval = new ItemStack(AugerModItems.NATURAL_LEG.get());
				entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_surgery_leg2 = _setval.copy();
					capability.syncPlayerVariables(entity);
				});
			}
			{
				ItemStack _setval = new ItemStack(AugerModItems.NATURAL_KIDNEY.get());
				entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_surgery_torso1 = _setval.copy();
					capability.syncPlayerVariables(entity);
				});
			}
			{
				ItemStack _setval = new ItemStack(AugerModItems.NATURAL_HEART.get());
				entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_surgery_torso2 = _setval.copy();
					capability.syncPlayerVariables(entity);
				});
			}
			{
				ItemStack _setval = new ItemStack(AugerModItems.NATURAL_LUNG.get());
				entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_surgery_torso3 = _setval.copy();
					capability.syncPlayerVariables(entity);
				});
			}
			{
				ItemStack _setval = new ItemStack(AugerModItems.NATURAL_LUNG.get());
				entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_surgery_torso4 = _setval.copy();
					capability.syncPlayerVariables(entity);
				});
			}
			{
				ItemStack _setval = new ItemStack(AugerModItems.NATURAL_STOMACH.get());
				entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_surgery_torso5 = _setval.copy();
					capability.syncPlayerVariables(entity);
				});
			}
			{
				ItemStack _setval = new ItemStack(AugerModItems.XENO_GERM.get());
				entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_surgery_torso6 = _setval.copy();
					capability.syncPlayerVariables(entity);
				});
			}
			{
				ItemStack _setval = new ItemStack(AugerModItems.NATURAL_SKIN.get());
				entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_surgery_skin = _setval.copy();
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = true;
				entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_hasjoined = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
