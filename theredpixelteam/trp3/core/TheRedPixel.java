package com.theredpixelteam.trp3.core;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TheRedPixel.MODID, name = TheRedPixel.NAME, version = TheRedPixel.VERSION)
public class TheRedPixel {
	@SidedProxy(clientSide = "com.theredpixelteam.trp3.core.ClientProxy", serverSide = "com.theredpixelteam.trp3.core.CommonProxy")
	public static ClientProxy proxy;
	public static final String MODID = "theredpixel";
	public static final String VERSION = "1.0";
	public static final String NAME = "TheRedPixel";
	public Minecraft mc;
	
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
		//MinecraftForge.EVENT_BUS.register();
		//FMLCommonHandler.instance().bus().register();
		//proxy.initialize();
	}
}
