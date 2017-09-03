package sudoku;

import java.io.IOException;

import javax.swing.JOptionPane;

public class SocketController {
	static int porter;
public static void socketRole () {
	System.out.println("role");

 porter = JOptionPane.showConfirmDialog(null, "is the a seer on the port 7777 on your local network");
	

 if(porter == JOptionPane.NO_OPTION) {
	 try {
		// Server.go();
	} catch (IOException e) {
		e.printStackTrace();
	}
 }else if(porter == JOptionPane.YES_OPTION) {
	 try {
		// Client.go();
	} catch (Exception e) {
		e.printStackTrace();
	}
 }
}
}
