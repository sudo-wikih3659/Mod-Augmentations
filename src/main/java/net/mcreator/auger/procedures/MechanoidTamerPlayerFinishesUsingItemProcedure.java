package net.mcreator.auger.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.auger.network.AugerModVariables;
import net.mcreator.auger.init.AugerModAttributes;
import net.mcreator.auger.entity.ScytherEntity;

import java.util.List;
import java.util.Comparator;

public class MechanoidTamerPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity usedEntity = null;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				usedEntity = entityiterator;
				if (("player").equals(usedEntity instanceof ScytherEntity _datEntS ? _datEntS.getEntityData().get(ScytherEntity.DATA_owner) : "") && !(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)
						&& (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(AugerModAttributes.BANDWIDTH.get())
								? _livingEntity2.getAttribute(AugerModAttributes.BANDWIDTH.get()).getValue()
								: 0) >= (entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_bandwidth_consumed + 2) {
					if (usedEntity instanceof ScytherEntity _datEntSetS)
						_datEntSetS.getEntityData().set(ScytherEntity.DATA_owner, (entity.getDisplayName().getString()));
					if (usedEntity instanceof TamableAnimal _toTame && entity instanceof Player _owner)
						_toTame.tame(_owner);
					{
						double _setval = (entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AugerModVariables.PlayerVariables())).player_bandwidth_consumed + 2;
						entity.getCapability(AugerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.player_bandwidth_consumed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
