
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.auger.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.auger.item.XenoGermItem;
import net.mcreator.auger.item.SurgeryExtractorItem;
import net.mcreator.auger.item.StoneSkinItem;
import net.mcreator.auger.item.SterilizingStomachItem;
import net.mcreator.auger.item.SkulkSensorsItem;
import net.mcreator.auger.item.PsychicResonatorItem;
import net.mcreator.auger.item.PsychicReaderItem;
import net.mcreator.auger.item.PrisonPocketPickerItem;
import net.mcreator.auger.item.PlasteelSkinItem;
import net.mcreator.auger.item.PacemakerItem;
import net.mcreator.auger.item.NuclearStomachItem;
import net.mcreator.auger.item.NeurocalculatorItem;
import net.mcreator.auger.item.NeuralHeatsinkItem;
import net.mcreator.auger.item.NaturalStomachItem;
import net.mcreator.auger.item.NaturalSpineItem;
import net.mcreator.auger.item.NaturalSkinItem;
import net.mcreator.auger.item.NaturalLungItem;
import net.mcreator.auger.item.NaturalLegItem;
import net.mcreator.auger.item.NaturalKidneyItem;
import net.mcreator.auger.item.NaturalHeartItem;
import net.mcreator.auger.item.NaturalHeadItem;
import net.mcreator.auger.item.NaturalEyesItem;
import net.mcreator.auger.item.NaturalEarItem;
import net.mcreator.auger.item.NaturalBrainItem;
import net.mcreator.auger.item.NaturalArmItem;
import net.mcreator.auger.item.MindscrewItem;
import net.mcreator.auger.item.MechanoidTamerItem;
import net.mcreator.auger.item.MechLinkItem;
import net.mcreator.auger.item.KnifeItem;
import net.mcreator.auger.item.HeartofGoldItem;
import net.mcreator.auger.item.HealingEnhancerItem;
import net.mcreator.auger.item.FleshmassStomachItem;
import net.mcreator.auger.item.FleshArmItem;
import net.mcreator.auger.item.EldritchBrainItem;
import net.mcreator.auger.item.DrillArmItem;
import net.mcreator.auger.item.DebugerItem;
import net.mcreator.auger.item.DeathAcidifierItem;
import net.mcreator.auger.item.CognitiveOverclockerItem;
import net.mcreator.auger.item.BionicLungItem;
import net.mcreator.auger.item.BionicLegItem;
import net.mcreator.auger.item.BionicEyeItem;
import net.mcreator.auger.item.BionicArmItem;
import net.mcreator.auger.item.ArchotechEyeItem;
import net.mcreator.auger.item.ArchotechArmItem;
import net.mcreator.auger.item.AirBalloonItem;
import net.mcreator.auger.item.AdrenalHeartItem;
import net.mcreator.auger.AugerMod;

public class AugerModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AugerMod.MODID);
	public static final RegistryObject<Item> NATURAL_HEAD = REGISTRY.register("natural_head", () -> new NaturalHeadItem());
	public static final RegistryObject<Item> MINDSCREW = REGISTRY.register("mindscrew", () -> new MindscrewItem());
	public static final RegistryObject<Item> NATURAL_STOMACH = REGISTRY.register("natural_stomach", () -> new NaturalStomachItem());
	public static final RegistryObject<Item> KNIFE = REGISTRY.register("knife", () -> new KnifeItem());
	public static final RegistryObject<Item> NATURAL_EAR = REGISTRY.register("natural_ear", () -> new NaturalEarItem());
	public static final RegistryObject<Item> DEBUGER = REGISTRY.register("debuger", () -> new DebugerItem());
	public static final RegistryObject<Item> PRISON_POCKET_PICKER = REGISTRY.register("prison_pocket_picker", () -> new PrisonPocketPickerItem());
	public static final RegistryObject<Item> SURGERY_EXTRACTOR = REGISTRY.register("surgery_extractor", () -> new SurgeryExtractorItem());
	public static final RegistryObject<Item> NATURAL_LUNG = REGISTRY.register("natural_lung", () -> new NaturalLungItem());
	public static final RegistryObject<Item> NATURAL_BRAIN = REGISTRY.register("natural_brain", () -> new NaturalBrainItem());
	public static final RegistryObject<Item> NATURAL_EYES = REGISTRY.register("natural_eyes", () -> new NaturalEyesItem());
	public static final RegistryObject<Item> NATURAL_SPINE = REGISTRY.register("natural_spine", () -> new NaturalSpineItem());
	public static final RegistryObject<Item> MECH_LINK = REGISTRY.register("mech_link", () -> new MechLinkItem());
	public static final RegistryObject<Item> NEUROCALCULATOR = REGISTRY.register("neurocalculator", () -> new NeurocalculatorItem());
	public static final RegistryObject<Item> PSYCHIC_READER = REGISTRY.register("psychic_reader", () -> new PsychicReaderItem());
	public static final RegistryObject<Item> BIONIC_ARM = REGISTRY.register("bionic_arm", () -> new BionicArmItem());
	public static final RegistryObject<Item> BIONIC_EYE = REGISTRY.register("bionic_eye", () -> new BionicEyeItem());
	public static final RegistryObject<Item> BIONIC_LEG = REGISTRY.register("bionic_leg", () -> new BionicLegItem());
	public static final RegistryObject<Item> DEATH_ACIDIFIER = REGISTRY.register("death_acidifier", () -> new DeathAcidifierItem());
	public static final RegistryObject<Item> NUCLEAR_STOMACH = REGISTRY.register("nuclear_stomach", () -> new NuclearStomachItem());
	public static final RegistryObject<Item> STERILIZING_STOMACH = REGISTRY.register("sterilizing_stomach", () -> new SterilizingStomachItem());
	public static final RegistryObject<Item> FLESHMASS_STOMACH = REGISTRY.register("fleshmass_stomach", () -> new FleshmassStomachItem());
	public static final RegistryObject<Item> ADRENAL_HEART = REGISTRY.register("adrenal_heart", () -> new AdrenalHeartItem());
	public static final RegistryObject<Item> ARCHOTECH_EYE = REGISTRY.register("archotech_eye", () -> new ArchotechEyeItem());
	public static final RegistryObject<Item> ARCHOTECH_ARM = REGISTRY.register("archotech_arm", () -> new ArchotechArmItem());
	public static final RegistryObject<Item> FLESH_ARM = REGISTRY.register("flesh_arm", () -> new FleshArmItem());
	public static final RegistryObject<Item> DRILL_ARM = REGISTRY.register("drill_arm", () -> new DrillArmItem());
	public static final RegistryObject<Item> NATURAL_HEART = REGISTRY.register("natural_heart", () -> new NaturalHeartItem());
	public static final RegistryObject<Item> NATURAL_ARM = REGISTRY.register("natural_arm", () -> new NaturalArmItem());
	public static final RegistryObject<Item> NATURAL_SKIN = REGISTRY.register("natural_skin", () -> new NaturalSkinItem());
	public static final RegistryObject<Item> NATURAL_LEG = REGISTRY.register("natural_leg", () -> new NaturalLegItem());
	public static final RegistryObject<Item> NATURAL_KIDNEY = REGISTRY.register("natural_kidney", () -> new NaturalKidneyItem());
	public static final RegistryObject<Item> XENO_GERM = REGISTRY.register("xeno_germ", () -> new XenoGermItem());
	public static final RegistryObject<Item> BIONIC_LUNG = REGISTRY.register("bionic_lung", () -> new BionicLungItem());
	public static final RegistryObject<Item> HEALING_ENHANCER = REGISTRY.register("healing_enhancer", () -> new HealingEnhancerItem());
	public static final RegistryObject<Item> STONE_SKIN = REGISTRY.register("stone_skin", () -> new StoneSkinItem());
	public static final RegistryObject<Item> PSYCHIC_RESONATOR = REGISTRY.register("psychic_resonator", () -> new PsychicResonatorItem());
	public static final RegistryObject<Item> ELDRITCH_BRAIN = REGISTRY.register("eldritch_brain", () -> new EldritchBrainItem());
	public static final RegistryObject<Item> NEURAL_HEATSINK = REGISTRY.register("neural_heatsink", () -> new NeuralHeatsinkItem());
	public static final RegistryObject<Item> DIABOLUS_SPAWN_EGG = REGISTRY.register("diabolus_spawn_egg", () -> new ForgeSpawnEggItem(AugerModEntities.DIABOLUS, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> PLASTEEL_SKIN = REGISTRY.register("plasteel_skin", () -> new PlasteelSkinItem());
	public static final RegistryObject<Item> COGNITIVE_OVERCLOCKER = REGISTRY.register("cognitive_overclocker", () -> new CognitiveOverclockerItem());
	public static final RegistryObject<Item> HEARTOF_GOLD = REGISTRY.register("heartof_gold", () -> new HeartofGoldItem());
	public static final RegistryObject<Item> PACEMAKER = REGISTRY.register("pacemaker", () -> new PacemakerItem());
	public static final RegistryObject<Item> SKULK_SENSORS = REGISTRY.register("skulk_sensors", () -> new SkulkSensorsItem());
	public static final RegistryObject<Item> AIR_BALLOON = REGISTRY.register("air_balloon", () -> new AirBalloonItem());
	public static final RegistryObject<Item> SCYTHER_SPAWN_EGG = REGISTRY.register("scyther_spawn_egg", () -> new ForgeSpawnEggItem(AugerModEntities.SCYTHER, -52429, -1, new Item.Properties()));
	public static final RegistryObject<Item> MECHANOID_TAMER = REGISTRY.register("mechanoid_tamer", () -> new MechanoidTamerItem());
	// Start of user code block custom items
	// End of user code block custom items
}
