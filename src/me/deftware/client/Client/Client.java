package me.deftware.client.Client;

import me.deftware.client.Client.Modules.ModLoader;
import me.deftware.client.Main.Main;
import me.deftware.client.framework.Utils.Storage.Settings;

public class Client {

	private static Main main;
	private static Client instance;

	/*
	 * Handlers
	 */

	private ModLoader modloader = new ModLoader();

	public Client(Main main) {
		this.main = main;
		instance = this;
	}

	/**
	 * Initialize the client (Load mods, commands, etc)
	 */
	public void initialize() {
		modloader.initialize();
	}

	/**
	 * Returns our modloader instance
	 * 
	 * @return
	 */
	public ModLoader getModloader() {
		return modloader;
	}

	public static Client getInstance() {
		return instance;
	}

	/**
	 * Returns the settings instance from EMC
	 * 
	 * @return
	 */
	public static Settings getSetting() {
		return main.getSettings();
	}

}
