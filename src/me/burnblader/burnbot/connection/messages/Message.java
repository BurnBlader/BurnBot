package me.burnblader.burnbot.connection.messages;

import me.burnblader.burnbot.commands.Command;
import me.burnblader.burnbot.log.Log;
import me.burnblader.burnbot.main.Main;


public class Message {
	
	private String message;
	
	public Message(String message) {
		this.message = message;
	}
	
	public void parse() {
		if(message.contains("004")) {
			Log.info("Successfully connected.");
		} else if(message.contains("443")) {
			Log.info("Username already in use.");
		} else if(message.startsWith("PING ")) {
			Main.getBot().getConnection().write("PONG :" + message.substring(5) + "\r\n");
			Main.getBot().getConnection().flush();
		} else if(message.contains("PRIVMSG ")) {
			String s = message.substring(message.lastIndexOf(":") + 1);
			Command.parse(s);
		}
	}
	
	public String getMessage() {
		return message;
	}
	
}
