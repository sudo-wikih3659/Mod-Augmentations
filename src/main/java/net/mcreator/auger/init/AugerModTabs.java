
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.auger.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.auger.AugerMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AugerModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AugerMod.MODID);
	public static final RegistryObject<CreativeModeTab> AUGMENTATIONS = REGISTRY.register("augmentations",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.auger.augmentations")).icon(() -> new ItemStack(Blocks.BIRCH_PLANKS)).displayItems((parameters, tabData) -> {
				tabData.accept(AugerModItems.NATURAL_HEAD.get());
				tabData.accept(AugerModItems.MINDSCREW.get());
				tabData.accept(AugerModItems.NATURAL_STOMACH.get());
				tabData.accept(AugerModItems.KNIFE.get());
				tabData.accept(AugerModItems.DEBUGER.get());
				tabData.accept(AugerModItems.PRISON_POCKET_PICKER.get());
				tabData.accept(AugerModItems.SURGERY_EXTRACTOR.get());
				tabData.accept(AugerModItems.NATURAL_LUNG.get());
				tabData.accept(AugerModItems.NATURAL_BRAIN.get());
				tabData.accept(AugerModItems.NATURAL_EYES.get());
				tabData.accept(AugerModItems.NATURAL_SPINE.get());
				tabData.accept(AugerModItems.MECH_LINK.get());
				tabData.accept(AugerModItems.NEUROCALCULATOR.get());
				tabData.accept(AugerModItems.PSYCHIC_READER.get());
				tabData.accept(AugerModItems.BIONIC_ARM.get());
				tabData.accept(AugerModItems.BIONIC_EYE.get());
				tabData.accept(AugerModItems.BIONIC_LEG.get());
				tabData.accept(AugerModItems.DEATH_ACIDIFIER.get());
				tabData.accept(AugerModItems.NUCLEAR_STOMACH.get());
				tabData.accept(AugerModItems.STERILIZING_STOMACH.get());
				tabData.accept(AugerModItems.FLESHMASS_STOMACH.get());
				tabData.accept(AugerModItems.ADRENAL_HEART.get());
				tabData.accept(AugerModItems.ARCHOTECH_EYE.get());
				tabData.accept(AugerModItems.ARCHOTECH_ARM.get());
				tabData.accept(AugerModItems.FLESH_ARM.get());
				tabData.accept(AugerModItems.DRILL_ARM.get());
				tabData.accept(AugerModItems.NATURAL_HEART.get());
				tabData.accept(AugerModItems.NATURAL_ARM.get());
				tabData.accept(AugerModItems.NATURAL_SKIN.get());
				tabData.accept(AugerModItems.NATURAL_LEG.get());
				tabData.accept(AugerModItems.NATURAL_KIDNEY.get());
				tabData.accept(AugerModItems.XENO_GERM.get());
				tabData.accept(AugerModItems.BIONIC_LUNG.get());
				tabData.accept(AugerModItems.HEALING_ENHANCER.get());
				tabData.accept(AugerModItems.STONE_SKIN.get());
				tabData.accept(AugerModItems.PSYCHIC_RESONATOR.get());
				tabData.accept(AugerModItems.ELDRITCH_BRAIN.get());
				tabData.accept(AugerModItems.NEURAL_HEATSINK.get());
				tabData.accept(AugerModItems.PLASTEEL_SKIN.get());
				tabData.accept(AugerModItems.COGNITIVE_OVERCLOCKER.get());
				tabData.accept(AugerModItems.HEARTOF_GOLD.get());
				tabData.accept(AugerModItems.PACEMAKER.get());
				tabData.accept(AugerModItems.SKULK_SENSORS.get());
				tabData.accept(AugerModItems.AIR_BALLOON.get());
				tabData.accept(AugerModItems.SCYTHER_SPAWN_EGG.get());
				tabData.accept(AugerModItems.MECHANOID_TAMER.get());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(AugerModItems.DIABOLUS_SPAWN_EGG.get());
		}
	}
}
