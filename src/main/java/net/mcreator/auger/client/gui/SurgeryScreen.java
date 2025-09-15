package net.mcreator.auger.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.auger.world.inventory.SurgeryMenu;
import net.mcreator.auger.procedures.TooltipStomachImplantProcedure;
import net.mcreator.auger.procedures.TooltipSkinImplantProcedure;
import net.mcreator.auger.procedures.TooltipLung2ImplantProcedure;
import net.mcreator.auger.procedures.TooltipLung1ImplantProcedure;
import net.mcreator.auger.procedures.TooltipLeg2ImplantProcedure;
import net.mcreator.auger.procedures.TooltipLeg1ImplantProcedure;
import net.mcreator.auger.procedures.TooltipKidneyImplantProcedure;
import net.mcreator.auger.procedures.TooltipHeartImplantProcedure;
import net.mcreator.auger.procedures.TooltipHeadImplantProcedure;
import net.mcreator.auger.procedures.TooltipGeneseedImplantProcedure;
import net.mcreator.auger.procedures.TooltipEyeImplantProcedure;
import net.mcreator.auger.procedures.TooltipBrainImplantProcedure;
import net.mcreator.auger.procedures.TooltipArm2ImplantProcedure;
import net.mcreator.auger.procedures.TooltipArm1ImplantProcedure;
import net.mcreator.auger.procedures.SurgguimodelProcedure;
import net.mcreator.auger.network.SurgeryButtonMessage;
import net.mcreator.auger.AugerMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SurgeryScreen extends AbstractContainerScreen<SurgeryMenu> {
	private final static HashMap<String, Object> guistate = SurgeryMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox sureyouwanttosave;
	ImageButton imagebutton_implant_default;
	ImageButton imagebutton_implant_default1;
	ImageButton imagebutton_implant_default2;

	public SurgeryScreen(SurgeryMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 192;
		this.imageHeight = 216;
	}

	private static final ResourceLocation texture = new ResourceLocation("auger:textures/screens/surgery.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (SurgguimodelProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 78, this.topPos + 88, 30, 0f + (float) Math.atan((this.leftPos + 78 - mouseX) / 40.0), (float) Math.atan((this.topPos + 39 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (TooltipEyeImplantProcedure.execute(entity))
			if (mouseX > leftPos + 32 && mouseX < leftPos + 56 && mouseY > topPos + 23 && mouseY < topPos + 47)
				guiGraphics.renderTooltip(font, Component.translatable("gui.auger.surgery.tooltip_eye_implant"), mouseX, mouseY);
		if (TooltipHeadImplantProcedure.execute(entity))
			if (mouseX > leftPos + 32 && mouseX < leftPos + 56 && mouseY > topPos + -4 && mouseY < topPos + 20)
				guiGraphics.renderTooltip(font, Component.translatable("gui.auger.surgery.tooltip_head_implant"), mouseX, mouseY);
		if (TooltipBrainImplantProcedure.execute(entity))
			if (mouseX > leftPos + 5 && mouseX < leftPos + 29 && mouseY > topPos + 5 && mouseY < topPos + 29)
				guiGraphics.renderTooltip(font, Component.translatable("gui.auger.surgery.tooltip_brain_implant"), mouseX, mouseY);
		if (TooltipSkinImplantProcedure.execute(entity))
			if (mouseX > leftPos + 5 && mouseX < leftPos + 29 && mouseY > topPos + 32 && mouseY < topPos + 56)
				guiGraphics.renderTooltip(font, Component.translatable("gui.auger.surgery.tooltip_skin_implant"), mouseX, mouseY);
		if (TooltipArm1ImplantProcedure.execute(entity))
			if (mouseX > leftPos + 41 && mouseX < leftPos + 65 && mouseY > topPos + 50 && mouseY < topPos + 74)
				guiGraphics.renderTooltip(font, Component.translatable("gui.auger.surgery.tooltip_arm_implant"), mouseX, mouseY);
		if (TooltipLeg1ImplantProcedure.execute(entity))
			if (mouseX > leftPos + 41 && mouseX < leftPos + 65 && mouseY > topPos + 77 && mouseY < topPos + 101)
				guiGraphics.renderTooltip(font, Component.translatable("gui.auger.surgery.tooltip_leg_implant"), mouseX, mouseY);
		if (TooltipLeg2ImplantProcedure.execute(entity))
			if (mouseX > leftPos + 86 && mouseX < leftPos + 110 && mouseY > topPos + 77 && mouseY < topPos + 101)
				guiGraphics.renderTooltip(font, Component.translatable("gui.auger.surgery.tooltip_leg_implant1"), mouseX, mouseY);
		if (TooltipArm2ImplantProcedure.execute(entity))
			if (mouseX > leftPos + 95 && mouseX < leftPos + 119 && mouseY > topPos + 50 && mouseY < topPos + 74)
				guiGraphics.renderTooltip(font, Component.translatable("gui.auger.surgery.tooltip_arm_implant1"), mouseX, mouseY);
		if (TooltipLung1ImplantProcedure.execute(entity))
			if (mouseX > leftPos + 122 && mouseX < leftPos + 146 && mouseY > topPos + -4 && mouseY < topPos + 20)
				guiGraphics.renderTooltip(font, Component.translatable("gui.auger.surgery.tooltip_lung_implant"), mouseX, mouseY);
		if (TooltipLung2ImplantProcedure.execute(entity))
			if (mouseX > leftPos + 158 && mouseX < leftPos + 182 && mouseY > topPos + -4 && mouseY < topPos + 20)
				guiGraphics.renderTooltip(font, Component.translatable("gui.auger.surgery.tooltip_lung_implant1"), mouseX, mouseY);
		if (TooltipHeartImplantProcedure.execute(entity))
			if (mouseX > leftPos + 122 && mouseX < leftPos + 146 && mouseY > topPos + 23 && mouseY < topPos + 47)
				guiGraphics.renderTooltip(font, Component.translatable("gui.auger.surgery.tooltip_heart_implant"), mouseX, mouseY);
		if (TooltipStomachImplantProcedure.execute(entity))
			if (mouseX > leftPos + 158 && mouseX < leftPos + 182 && mouseY > topPos + 23 && mouseY < topPos + 47)
				guiGraphics.renderTooltip(font, Component.translatable("gui.auger.surgery.tooltip_stomach_implant"), mouseX, mouseY);
		if (TooltipKidneyImplantProcedure.execute(entity))
			if (mouseX > leftPos + 122 && mouseX < leftPos + 146 && mouseY > topPos + 50 && mouseY < topPos + 74)
				guiGraphics.renderTooltip(font, Component.translatable("gui.auger.surgery.tooltip_kidney_implant"), mouseX, mouseY);
		if (TooltipGeneseedImplantProcedure.execute(entity))
			if (mouseX > leftPos + 158 && mouseX < leftPos + 182 && mouseY > topPos + 50 && mouseY < topPos + 74)
				guiGraphics.renderTooltip(font, Component.translatable("gui.auger.surgery.tooltip_kidney_implant1"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.auger.surgery.label_save"), 158, 185, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.auger.surgery.label_reboot"), 14, 185, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.auger.surgery.label_clear"), 86, 185, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_implant_default = new ImageButton(this.leftPos + 14, this.topPos + 194, 16, 16, 0, 0, 16, new ResourceLocation("auger:textures/screens/atlas/imagebutton_implant_default.png"), 16, 32, e -> {
			if (true) {
				AugerMod.PACKET_HANDLER.sendToServer(new SurgeryButtonMessage(0, x, y, z));
				SurgeryButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_implant_default", imagebutton_implant_default);
		this.addRenderableWidget(imagebutton_implant_default);
		imagebutton_implant_default1 = new ImageButton(this.leftPos + 158, this.topPos + 194, 16, 16, 0, 0, 16, new ResourceLocation("auger:textures/screens/atlas/imagebutton_implant_default1.png"), 16, 32, e -> {
			if (true) {
				AugerMod.PACKET_HANDLER.sendToServer(new SurgeryButtonMessage(1, x, y, z));
				SurgeryButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_implant_default1", imagebutton_implant_default1);
		this.addRenderableWidget(imagebutton_implant_default1);
		imagebutton_implant_default2 = new ImageButton(this.leftPos + 86, this.topPos + 194, 16, 16, 0, 0, 16, new ResourceLocation("auger:textures/screens/atlas/imagebutton_implant_default2.png"), 16, 32, e -> {
			if (true) {
				AugerMod.PACKET_HANDLER.sendToServer(new SurgeryButtonMessage(2, x, y, z));
				SurgeryButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_implant_default2", imagebutton_implant_default2);
		this.addRenderableWidget(imagebutton_implant_default2);
		sureyouwanttosave = new Checkbox(this.leftPos + 194, this.topPos + 185, 20, 20, Component.translatable("gui.auger.surgery.sureyouwanttosave"), false);
		guistate.put("checkbox:sureyouwanttosave", sureyouwanttosave);
		this.addRenderableWidget(sureyouwanttosave);
	}
}
