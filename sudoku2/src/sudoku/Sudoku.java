package sudoku;

import javax.swing.JOptionPane;

public class Sudoku {
	public static void main(String[] args) throws Exception {
		System.out.println("main");

		Sudoku Sudoku = new Sudoku();
		Sudoku.builder();

	}

	static void builder() throws Exception {
		System.out.println("builder");

		
		//SocketController.socketRole();
		Monitor.generator();
		//Timer.timerBuild();
	}
}
//https://www.youtube.com/watch?v=aIaFFPatJjY