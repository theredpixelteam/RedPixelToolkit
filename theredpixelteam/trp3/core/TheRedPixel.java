package com.theredpixelteam.trp3.core;

import com.theredpixelteam.trp3.manager.EventManager;
import com.theredpixelteam.trp3.manager.KeyBoardManager;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TheRedPixel.MODID, name = TheRedPixel.NAME, version = TheRedPixel.VERSION)
public class TheRedPixel {
	@SidedProxy(clientSide = "com.theredpixelteam.trp3.core.ClientProxy", serverSide = "com.theredpixelteam.trp3.core.CommonProxy")
	private static ClientProxy proxy;
	protected static final String MODID = "theredpixel";
	protected static final String VERSION = "1.0";
	protected static final String NAME = "TheRedPixel";
	private Minecraft mc;
	private EventManager eventManager;
	private KeyBoardManager keyManager;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		/*event.getModMetadata().name = "RedMgr";
		event.getModMetadata().modId = "redmgr";
		event.getModMetadata().version = "1.4";
		event.getModMetadata().logoFile = "logo.png";
		event.getModMetadata().description = "Show minecart speed and redstone information.";
		event.getModMetadata().authorList.add("719823597");		
		event.getModMetadata().authorList.add("Erioifpud");	
		event.getModMetadata().credits = EnumChatFormatting.RED + "The RedPixel Team";
		event.getModMetadata().url = "http://forum.theredpixelteam.com/";*/
	}
	
	@EventHandler
	public void init(FMLPostInitializationEvent event) {
		eventManager = new EventManager();
		keyManager = new KeyBoardManager();
		MinecraftForge.EVENT_BUS.register(eventManager);
		FMLCommonHandler.instance().bus().register(eventManager);
		MinecraftForge.EVENT_BUS.register(keyManager);
		FMLCommonHandler.instance().bus().register(keyManager);
		//proxy.initialize();
	}
}
