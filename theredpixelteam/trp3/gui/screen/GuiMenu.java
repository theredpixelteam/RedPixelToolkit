package com.theredpixelteam.trp3.gui.screen;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

import com.mcf.davidee.guilib.basic.BasicScreen;
import com.mcf.davidee.guilib.core.Button;
import com.mcf.davidee.guilib.core.Container;
import com.mcf.davidee.guilib.core.Widget;
import com.theredpixelteam.trp3.gui.GuiUtils;
import com.theredpixelteam.trp3.gui.component.ButtonYellow;

public class GuiMenu extends BasicScreen {
	private Button button1;
	private Container container;
	//private String password;
	private StringBuilder sb;

	public GuiMenu() {
		super(null);
		// TODO Auto-generated constructor stub
		sb = new StringBuilder();
	}
	
	/*@Override
	public void drawScreen(int mx, int my, float f) {
		List<Widget> overlays = new ArrayList<Widget>();
		int scale = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight).getScaleFactor();
		for (Container c : containers)
			overlays.addAll(c.draw(mx, my, scale));
		for (Widget w : overlays)
			w.draw(mx, my);
		GuiUtils.drawRect(this.width / 2 - 120, 20, 240, this.height - 40, 0xff6e5745);
		GuiUtils.drawRect(this.width / 2 - 120, this.height - 2, 240, 2, 0xff524133);
	}*/

	@Override
	protected void revalidateGui() {
		// TODO Auto-generated method stub
		button1.setPosition(this.width / 2 - 100, 30);
		container.revalidate(0, 0, width, height);
	}

	@Override
	protected void createGui() {
		// TODO Auto-generated method stub
		container = new Container();
		button1 = new ButtonYellow(80, 20, "TRP", new CloseHandler());
		container.addWidgets(button1);
		containers.add(container);
	}

	@Override
	protected void reopenedGui() {
		// TODO Auto-generated method stub
		
	}
	
    @Override
	protected void unhandledKeyTyped(char c, int code) {
		if (code == Keyboard.KEY_ESCAPE)
			close();
		sb.append(c);
		if(sb.toString().equals("trp")) {
			System.out.println("2333333333333333333333333333333333~");
			sb.delete(0, sb.length());
		}
	}
    


}
