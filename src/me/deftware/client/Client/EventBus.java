package me.deftware.client.Client;

import me.deftware.client.Client.Command.ChatProccessor;
import me.deftware.client.framework.Event.Event;
import me.deftware.client.framework.Event.Events.EventClientCommand;
import me.deftware.client.framework.Event.Events.EventRender2D;
import me.deftware.client.framework.Wrappers.IMinecraft;
import me.deftware.client.framework.Wrappers.Objects.IGuiScreen;

/**
 * Handles all incoming events from EMC
 * 
 * @author deftware
 *
 */
public class EventBus {

	private static IGuiScreen screen;

	public static void onEvent(Event event) {
		if (event instanceof EventRender2D) {
			// Check if there's any screen we need to display
			if (screen != null) {
				IMinecraft.setGuiScreen(screen);
				screen = null;
			}
			// Pass our 2d render events to the rendermanager
			RenderManager.draw();
		} else if (event instanceof EventClientCommand) {
			// Pass . commands to the command handler
			ChatProccessor.onClientCommand((EventClientCommand) event);
		}
		// Pass event to all the mods
		Client.getInstance().getModloader().onEvent(event);
	}

	/**
	 * Sets a screen to display, as we cannot display screens from non render
	 * events
	 * 
	 * @param screen
	 */
	public static void setScreen(IGuiScreen screen) {
		EventBus.screen = screen;
	}

}
