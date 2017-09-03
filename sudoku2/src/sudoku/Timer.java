package sudoku;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Timer {
	static JFrame SF = new JFrame();
	static JPanel SP = new JPanel();
	static JLabel timedisplay = new JLabel();
	static int time =5;
	static int disTime;
static void timerBuild() {
	
	SF.add(SP);
	SF.setSize(200, 200);
	SF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    SF.setResizable(false);
    SF.setVisible(true);
	start();
}
static void start() {
	SP.add(timedisplay);
	
	timedisplay.setFont(new Font ("tic", 1, 100));
	
	timedisplay.setText(""+time);
	run();
}
static void run(){
	for (int i = 0; i < time; i++) {
		try{

			  Thread.sleep(250);
			  Monitor.push();
			  if(Monitor.isWinner) {
				break;  
			  }
			  Thread.sleep(250);
			  Monitor.stateCheck();
			  
			  Monitor.push();
			  Monitor.stateCheck();
			  if(Monitor.isWinner) {
					break;  
				  }
			  Thread.sleep(250);
			  Monitor.push();
			  Monitor.stateCheck();
			  if(Monitor.isWinner) {
					break;  
				  }
			  Thread.sleep(250);
			  Monitor.stateCheck();
			}catch(InterruptedException ex){
			
			}
		disTime = time-i;
		timedisplay.setText(""+disTime);
		if(i==time) {
			Monitor.isWinner = true;
			Monitor.stateCheck();
		}
	}
	//other player losses
	
	Monitor.stateCheck();
}

}
