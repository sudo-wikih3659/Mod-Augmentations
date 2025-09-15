
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.auger.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.auger.potion.AnethesizedMobEffect;
import net.mcreator.auger.AugerMod;

public class AugerModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AugerMod.MODID);
	public static final RegistryObject<MobEffect> ANETHESIZED = REGISTRY.register("anethesized", () -> new AnethesizedMobEffect());
}
