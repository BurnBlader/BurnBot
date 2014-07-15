package me.burnblader.burnbot.commands;

import me.burnblader.burnbot.log.Log;
import me.burnblader.burnbot.main.Main;

public class Monologue extends Command {

	@Override
	public String getCommandLabel() {
		return "monologue";
	}

	@Override
	public void doAction(String message) {
		new Thread() {
			public void run() {
				try {
					Main.getBot().getConnection().sendMessage("Hello, " + Main.getBot().getUsername() + " here.");
					Thread.sleep(2000);
					Main.getBot().getConnection().sendMessage("Aren't trains really cool?");
					Thread.sleep(2000);
					Main.getBot().getConnection().sendMessage("They just go so fast...");
				} catch(Exception e) {
					Log.error(e);
				}
			};
		}.start();
	}

}
