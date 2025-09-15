
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.auger.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.auger.world.inventory.SurgeryMenu;
import net.mcreator.auger.AugerMod;

public class AugerModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, AugerMod.MODID);
	public static final RegistryObject<MenuType<SurgeryMenu>> SURGERY = REGISTRY.register("surgery", () -> IForgeMenuType.create(SurgeryMenu::new));
}
