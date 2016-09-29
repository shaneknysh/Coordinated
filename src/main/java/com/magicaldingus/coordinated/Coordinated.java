package com.magicaldingus.coordinated;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Coordinated.MOD_ID, name = Coordinated.MOD_NAME, version = Coordinated.VERSION, dependencies = Coordinated.DEPENDENCIES, guiFactory = Coordinated.GUI_FACTORY, clientSideOnly = true)
public class Coordinated {
	
	public static final String MOD_ID = "Coordinated";
	public static final String MOD_NAME = MOD_ID;
	public static final String BUILD = "GRADLE:BUILD";
	public static final String VERSION = "GRADLE:VERSION-" + BUILD;	
	public static final String DEPENDENCIES = "required-after:Forge@[12.17.0.1909,);";
	public static final String GUI_FACTORY = "com.magincaldingus.coordinated.GuiFactory";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new CoordinateRenderer());
	}
}