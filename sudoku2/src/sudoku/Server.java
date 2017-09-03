package sudoku;

import java.net.*;
import java.io.*;

public class Server {
	static ServerSocket servSock;
	static Socket socket;
	static DataOutputStream out;
	static boolean isTap = true;
	static int users = 2;
	static DataInputStream in;

	static void server() throws IOException {
		System.out.println("starting server...");
		servSock = new ServerSocket(7777);
		System.out.println("started server");
		while (isTap) {
			socket = servSock.accept();
			System.out.println("Connected to: " + socket.getInetAddress());
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			send();
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

	// class Ports implements Runnable {
	// DataOutputStream out;
	// DataInputStream in;
	// Ports port[];
	// //Ports[] port = new Ports[users];
	//
	// public Ports(DataOutputStream out, DataInputStream in, Ports[] port) {
	// this.out = out;
	// this.in = in;
	// this.port = port;
	// }
	//
	// public void run() {
	// while (isTap) {
	//
	// }
	// }

}
