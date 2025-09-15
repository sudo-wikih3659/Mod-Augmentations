
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.auger.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.auger.network.ActivateSpecialMessage;
import net.mcreator.auger.AugerMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class AugerModKeyMappings {
	public static final KeyMapping ACTIVATE_SPECIAL = new KeyMapping("key.auger.activate_special", GLFW.GLFW_KEY_H, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				AugerMod.PACKET_HANDLER.sendToServer(new ActivateSpecialMessage(0, 0));
				ActivateSpecialMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(ACTIVATE_SPECIAL);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				ACTIVATE_SPECIAL.consumeClick();
			}
		}
	}
}
