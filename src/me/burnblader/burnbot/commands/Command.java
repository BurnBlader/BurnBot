package me.burnblader.burnbot.commands;

import me.burnblader.burnbot.log.Log;


public abstract class Command {
	
	public enum Commands {
		
		ECHO(Echo.class),
		MONOLOGUE(Monologue.class);
		
		private Class<? extends Command> c;
		
		Commands(Class<? extends Command> c) {
			this.c = c;
		}
		
		public Class<? extends Command> getCommandClass() {
			return c;
		}
	}
	
	public abstract String getCommandLabel();
	
	public abstract void doAction(String message);
	
	public static void parse(String message) {
		for(Commands c : Commands.values()) {
			try {
				Command command = c.getCommandClass().newInstance();
				String s = command.getCommandLabel();
				Log.info(s);
				Log.info(message);
				if(message.startsWith("!" + s)) {
					command.doAction(message.replace("!" + s + " ", ""));
					return;
				}
			} catch (Exception e) {
				Log.error(e);
			}
		}
	}
	
}
