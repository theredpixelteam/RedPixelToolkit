package com.theredpixelteam.trp3.gui.component;

import org.lwjgl.opengl.GL11;

import com.erioifpud.toolkit.GuiUtils;
import com.mcf.davidee.guilib.vanilla.ButtonVanilla;

public class ButtonYellow extends ButtonVanilla {

	public ButtonYellow(int width, int height, String text,
			ButtonHandler handler) {
		super(width, height, text, handler);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(int mx, int my) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		boolean hover = inBounds(mx, my);
		int u = 0, v = 46 + getStateOffset(hover);
		if(hover) {
			GuiUtils.drawRect(this.x, this.y, this.width, this.height, 0xffe7c97f);
			GuiUtils.drawRect(this.x, this.y + this.height - 2, this.width, 2, 0xffa18c59);
		}
		else {
			GuiUtils.drawRect(this.x, this.y, this.width, this.height, 0xffe1cfa3);
			GuiUtils.drawRect(this.x, this.y + this.height - 2, this.width, 2, 0xffac9f81);
		}
		drawString(mc.fontRenderer, str, (x + width / 2) - mc.fontRenderer.getStringWidth(str) / 2, y + (height - 8) / 2, 0xffbdc3c7);
	}
	
	private int getStateOffset(boolean hover) {
		return ((enabled) ? ((hover) ? 40 : 20) : 0);
	}
	
	private int getTextColor(boolean hover) {
		return ((enabled) ? ((hover) ? 16777120 : 14737632) : 6250336);
	}

}
