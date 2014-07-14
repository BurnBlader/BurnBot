package me.burnblader.burnbot;

import me.burnblader.burnbot.connection.IRCConnection;

public class BurnBot {
	
	private IRCConnection connection;
	
	public BurnBot(String ip, int port) {
		connection = new IRCConnection(ip, port);
	}
	
	public void start() {
		connection.connect();
	}
	
	public IRCConnection getConnection() {
		return connection;
	}
	
}
