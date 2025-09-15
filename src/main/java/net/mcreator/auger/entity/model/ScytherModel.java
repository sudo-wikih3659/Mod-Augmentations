package net.mcreator.auger.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.auger.entity.ScytherEntity;

public class ScytherModel extends GeoModel<ScytherEntity> {
	@Override
	public ResourceLocation getAnimationResource(ScytherEntity entity) {
		return new ResourceLocation("auger", "animations/scyther.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ScytherEntity entity) {
		return new ResourceLocation("auger", "geo/scyther.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ScytherEntity entity) {
		return new ResourceLocation("auger", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(ScytherEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
