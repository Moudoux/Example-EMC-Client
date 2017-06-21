package me.deftware.client.Client;

import me.deftware.client.Client.Modules.Mod;
import me.deftware.client.Main.Main;
import me.deftware.client.framework.Wrappers.Objects.IGuiScreen;
import me.deftware.client.framework.Wrappers.Render.IFontRenderer;

public class RenderManager {

	public static void draw() {
		drawClientOverlay();
	}

	/**
	 * Draws the client name in the top left corner
	 */
	public static void drawClientOverlay() {
		// Draw client name at x:0 y:0
		IFontRenderer.drawStringWithShadow(Main.name, 2, 2, 0xFFFFFF);
		// Now let's draw the active mods
		int i = 0;
		for (Mod m : Client.getInstance().getModloader().getModlist().values()) {
			if (m.isState()) {
				int offset = 0;
				if (offset != 0) {
					offset = (IFontRenderer.getFontHeight() * i);
				}
				IFontRenderer.drawStringWithShadow(m.getName(),
						IGuiScreen.getScaledWidth() - IFontRenderer.getStringWidth(m.getName()) - 2,
						2 + offset, 0xFFFFFF);
				i += 1;
			}
		}
	}

}
