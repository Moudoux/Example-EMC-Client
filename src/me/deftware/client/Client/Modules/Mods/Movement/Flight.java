package me.deftware.client.Client.Modules.Mods.Movement;

import me.deftware.client.Client.Modules.Mod;
import me.deftware.client.Client.Modules.ModType;
import me.deftware.client.framework.Event.Event;
import me.deftware.client.framework.Event.Events.EventUpdate;
import me.deftware.client.framework.Wrappers.Entity.IEntityPlayer;

public class Flight extends Mod {

	public Flight() {
		// Set default keybind to 33 (F)
		super("Flight", "Allows you to fly in survival", ModType.Flight, 33);
	}

	@Override
	public void onEvent(Event event) {
		if (event instanceof EventUpdate) {
			IEntityPlayer.setFlying(true);
		}
	}

	@Override
	public void onEnable() {

	}

	@Override
	public void onDisable() {
		IEntityPlayer.setFlying(false);
	}

}
