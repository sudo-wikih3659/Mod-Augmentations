
package net.mcreator.auger.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.auger.procedures.AnethesizedEffectStartedappliedProcedure;
import net.mcreator.auger.procedures.AnethesizedEffectExpiresProcedure;

public class AnethesizedMobEffect extends MobEffect {
	public AnethesizedMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16711834);
		this.addAttributeModifier(Attributes.JUMP_STRENGTH, "8383be3c-e672-3a5e-a4c9-0acb70c2522f", -20, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "cee7f399-f967-359d-a111-6985d47ad9a1", -20, AttributeModifier.Operation.ADDITION);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.addAttributeModifiers(entity, attributeMap, amplifier);
		AnethesizedEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		AnethesizedEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
