package me.burnblader.burnbot.main;

import me.burnblader.burnbot.BurnBot;

public class Main {
	
	public static void main(String[] args) {
		BurnBot b = new BurnBot("irc.freenode.net", 6667);
		b.start();
	}
	
}
