
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.auger.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.auger.entity.ScytherEntity;
import net.mcreator.auger.entity.DiaboluscannonshotEntity;
import net.mcreator.auger.entity.DiabolusEntity;
import net.mcreator.auger.AugerMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AugerModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AugerMod.MODID);
	public static final RegistryObject<EntityType<DiaboluscannonshotEntity>> DIABOLUSCANNONSHOT = register("diaboluscannonshot", EntityType.Builder.<DiaboluscannonshotEntity>of(DiaboluscannonshotEntity::new, MobCategory.MISC)
			.setCustomClientFactory(DiaboluscannonshotEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<DiabolusEntity>> DIABOLUS = register("diabolus",
			EntityType.Builder.<DiabolusEntity>of(DiabolusEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DiabolusEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ScytherEntity>> SCYTHER = register("scyther",
			EntityType.Builder.<ScytherEntity>of(ScytherEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ScytherEntity::new)

					.sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			DiabolusEntity.init();
			ScytherEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(DIABOLUS.get(), DiabolusEntity.createAttributes().build());
		event.put(SCYTHER.get(), ScytherEntity.createAttributes().build());
	}
}
