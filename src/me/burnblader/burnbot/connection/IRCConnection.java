package me.burnblader.burnbot.connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import me.burnblader.burnbot.connection.messages.Message;
import me.burnblader.burnbot.log.Log;

public class IRCConnection {
	
	private String ip;
	private int port;
	
	private Socket socket;
	private BufferedWriter output;
	private BufferedReader input;
	
	public IRCConnection(String ip, int port) {
		this.ip = ip;
		this.port = port;
		Log.info("IRCConnection instance created.");
	}
	
	public void connect() {
		try {
			socket = new Socket(ip, port);
			Log.info("Connection", "Socket connected.");
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			Log.info("Connection", "Output connected.");
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Log.info("Connection", "Input connected.");
			Log.info("Connection", "Complete.");
		} catch (IOException e) {
			Log.error(e);
		}
	}
	
	public String getIP() {
		return ip;
	}
	
	public int getPort() {
		return port;
	}
	
	public BufferedWriter getOutput() {
		return output;
	}
	
	public BufferedReader getInput() {
		return input;
	}
	
	public void write(String s) {
		try {
			output.write(s);
		} catch (IOException e) {
			Log.error(e);
		}
	}
	
	class ListenForInput extends Thread {
		
		private BufferedReader reader;
		
		private boolean running;
		
		public ListenForInput(BufferedReader reader) {
			this.reader = reader;
		}
		
		@Override
		public void run() {
			while(running) {
				try {
					String s = reader.readLine();
					if(s != "") {
						Message m = new Message(s);
						m.parse();
					}
				} catch (IOException e) { }
			}
		}
		
	}
	
}
