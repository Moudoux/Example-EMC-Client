package me.deftware.client.Client.Modules;

import java.util.HashMap;

import me.deftware.client.Client.Modules.Mods.Movement.Flight;
import me.deftware.client.framework.Event.Event;
import me.deftware.client.framework.Event.Events.EventKeyPress;

/**
 * Handles all the client mods
 * 
 * @author deftware
 *
 */
public class ModLoader {

	public boolean done = false;
	private HashMap<ModType, Mod> modlist = new HashMap<ModType, Mod>();

	/**
	 * Add all mods
	 */
	public void initialize() {
		modlist.put(ModType.Flight, new Flight());
	}

	/**
	 * Returns the mods
	 * 
	 * @return
	 */
	public HashMap<ModType, Mod> getModlist() {
		return modlist;
	}

	/**
	 * Returns a mod instance from a modtype
	 * 
	 * @param mod
	 * @return
	 */
	public Mod getMod(ModType mod) {
		return modlist.get(mod);
	}

	/**
	 * Returns a mod instance from the name of the mod
	 * 
	 * @param mod
	 * @return
	 */
	public Mod getMod(String mod) {
		for (Mod m : modlist.values()) {
			if (m.getName().toLowerCase().equals(mod.toLowerCase())) {
				return m;
			}
		}
		return null;
	}

	/**
	 * Called from the event bus, passes a provided event to all enabled mods
	 */
	public void onEvent(Event event) {
		for (Mod m : modlist.values()) {
			if (m.isState()) {
				m.onEvent(event);
			}
			// Handle keybinds
			if (event instanceof EventKeyPress) {
				EventKeyPress keypress = (EventKeyPress) event;
				if (m.getKeybind() == keypress.getKey()) {
					// If keybind matches toggle mod
					m.toggle();
				}
			}
		}
	}

}
