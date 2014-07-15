package me.burnblader.burnbot.main;

import me.burnblader.burnbot.BurnBot;

public class Main {
	
	private static BurnBot burnBot;
	
	public static void main(String[] args) {
		burnBot = new BurnBot("oBurnBoto", "irc.freenode.net", 6667, "haskell");
		burnBot.start();
	}
	
	public static BurnBot getBot() {
		return burnBot;
	}
	
}
