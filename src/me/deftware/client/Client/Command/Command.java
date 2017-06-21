package me.deftware.client.Client.Command;

import me.deftware.client.framework.Wrappers.IChat;

public abstract class Command {

	protected void message(String msg) {
		IChat.sendClientMessage(msg);
	}

	protected void syntaxError() {
		message("Invalid syntax");
	}

	public abstract void onCommand(String args);

}
