package sudoku;

import java.net.*;
import java.io.*;

public class Client {
	static Socket socket;
	static DataInputStream in;
	static DataOutputStream out;
	static boolean turn = true;
	static void client() throws Exception {
		System.out.println("Connecting...");
		socket = new Socket("localhost", 7777);
		System.out.println("connection sucsessful");
		in = new DataInputStream(socket.getInputStream());
		System.out.println("retriving info...");
		String test = in.readUTF();
		for (int rows = 0; rows < 9; rows++) {
			for (int columns = 0; columns < 9; columns++) {
		System.out.println("Message from server:" + test);
		
			}
		}
		
	}
	static void send() {
		for (int rows = 0; rows < 9; rows++) {
			for (int columns = 0; columns < 9; columns++) {
				try {
					out.writeUTF(Monitor.sset[rows][columns]);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	static void recive() {
		
				try {
					in.readUTF();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}

