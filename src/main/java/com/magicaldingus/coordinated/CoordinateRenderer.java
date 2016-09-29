package com.magicaldingus.coordinated;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CoordinateRenderer {

    private Minecraft minecraft;
    
    /*
	@SubscribeEvent
	public void onRenderWorldLast(RenderWorldLastEvent event) {
		Minecraft mc = Minecraft.getMinecraft();
		renderCoordinates(this.width, this.height);
	}
	*/
	
	@SubscribeEvent
    public void onEvent(RenderGameOverlayEvent.Post event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE) return;
        Minecraft mc = Minecraft.getMinecraft();
        minecraft = mc;
        renderCoordinates(event.getResolution().getScaledWidth(), event.getResolution().getScaledHeight());
    }

    public void renderCoordinates(int screenWidth, int screenHeight) {
        int x = minecraft.thePlayer.getPosition().getX();
        int y = minecraft.thePlayer.getPosition().getY();
        int z = minecraft.thePlayer.getPosition().getZ();

        String coordinates = String.format("X: %d Y: %d Z: %d", x, y, z);

        minecraft.fontRendererObj.drawStringWithShadow(coordinates, screenWidth*80/100, (screenHeight*90/100)-10, Integer.parseInt("e1e1e1", 16));
    }

}