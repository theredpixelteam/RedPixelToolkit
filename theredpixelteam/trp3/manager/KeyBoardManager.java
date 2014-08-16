package com.theredpixelteam.trp3.manager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;

import org.lwjgl.input.Keyboard;

import com.theredpixelteam.trp3.gui.screen.GuiMenu;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class KeyBoardManager {

	protected KeyBinding menu = new KeyBinding("Menu", Keyboard.KEY_Y, "The Red Pixel");
	private Minecraft mc = Minecraft.getMinecraft();
	private static boolean state;

	@SideOnly(Side.CLIENT)
	public KeyBoardManager() {
		ClientRegistry.registerKeyBinding(menu);
	}

	@SubscribeEvent
	public void KeyDown(InputEvent.KeyInputEvent event) {
		if (this.menu.isPressed()) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiMenu());
		}
	}

}
