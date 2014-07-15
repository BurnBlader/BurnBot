package me.burnblader.burnbot.commands;

import me.burnblader.burnbot.main.Main;

public class Echo extends Command {

	@Override
	public String getCommandLabel() {
		return "echo";
	}

	@Override
	public void doAction(String message) {
		Main.getBot().getConnection().sendMessage(message);
	}
	
	
	
}
