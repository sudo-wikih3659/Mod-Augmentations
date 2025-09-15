
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.auger.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.auger.client.renderer.ScytherRenderer;
import net.mcreator.auger.client.renderer.DiabolusRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AugerModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(AugerModEntities.DIABOLUSCANNONSHOT.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(AugerModEntities.DIABOLUS.get(), DiabolusRenderer::new);
		event.registerEntityRenderer(AugerModEntities.SCYTHER.get(), ScytherRenderer::new);
	}
}
