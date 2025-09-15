
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.auger.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.auger.AugerMod;

public class AugerModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, AugerMod.MODID);
	public static final RegistryObject<Potion> ANESTHETIC = REGISTRY.register("anesthetic", () -> new Potion(new MobEffectInstance(AugerModMobEffects.ANETHESIZED.get(), 1200, 0, false, true)));
}
