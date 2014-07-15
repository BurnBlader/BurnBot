package me.burnblader.burnbot;

import me.burnblader.burnbot.connection.IRCConnection;
import me.burnblader.burnbot.log.Log;

public class BurnBot {
	
	private IRCConnection connection;
		
	private String channel, username;
	
	public BurnBot(String username, String ip, int port, String channel) {
		connection = new IRCConnection(ip, port);
		this.username = username;
		this.channel = channel;
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				connection.write("QUIT");
			}
		});
	}
	
	public void start() {
		connection.connect();
		login();
		stop();
	}
	
	public String getUsername() {
		return username;
	}
	
	public IRCConnection getConnection() {
		return connection;
	}
	
	public void stop() {
		while(true) {
			
		}
	}
	
	public String getChannel() {
		return channel;
	}
	
	public void login() {
		new Thread() {
			public void run() {
				
				connection.write("USER " + username + " . . :github.com/BurnBlader/BurnBot\r\n");
				Log.info("Sent user.");
				connection.write("NICK " + username + "\r\n");
				Log.info("Sent nickname.");
				connection.flush();
				Log.info("Flushed.");
				
				try {
					Thread.sleep(12000);
				} catch (InterruptedException e) {
					Log.error(e);
				}
				
				connection.write("JOIN #" + channel + "\r\n");
				connection.flush();
				Log.info("Joined channel #" + channel + ".");
				
			};
		}.start();
	}
	
}
