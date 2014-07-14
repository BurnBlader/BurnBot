package me.burnblader.burnbot.log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Log {
	
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
	
	public static void info(String tag, String info) {
		System.out.println(timeFormat.format(Calendar.getInstance().getTime()) + " INFO: " + tag + " - " + info);
	}
	
	public static void info(String info) {
		System.out.println(timeFormat.format(Calendar.getInstance().getTime()) + " INFO: " + info);
	}
	
	public static void error(String tag, String info) {
		System.out.println(timeFormat.format(Calendar.getInstance().getTime()) + " ERROR: " + tag + " - " + info);
	}
	
	public static void error(Exception e) {
		System.out.println(timeFormat.format(Calendar.getInstance().getTime()) + " Something went wrong =( - " + e.getClass().getName());
	}
	
}
