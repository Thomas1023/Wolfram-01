package sudoku;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Monitor {
	static int yp = 0;
	static int xp = 0;
	static JTextField[][] textField = new JTextField[9][9];
	static String[][] sget = new String[9][9];
	static String[][] sset = new String[9][9];
	static int x;
	static int y;
	static int[][] Pos = new int[9][9];
	boolean called = false;
	static boolean turnType = true;
	static boolean isWinner = false;
	static String winner;

	// j column
	// i row
	static void generator() {
		JPanel GP = new JPanel();
		JFrame GF = new JFrame();
		GF.setSize(1000, 1000);
		GF.setVisible(true);
		// GF.add(GP);
		GF.setResizable(false);
		GF.setLayout(new GridLayout(9, 9));
		// GP.setLayout(null);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				textField[i][j] = new JTextField(1);

				// textField[i][j].setBounds(50 + xp, 50 + yp, 50, 50);
				GF.add(textField[i][j]);
				textField[i][j].setFont(new Font("blab", 1, 80));
				xp = xp + 60;
				if (j <= 2 && i <= 2 || j > 5 && i <= 2 || j >= 3 && j <= 5 && i >= 3 && i <= 5 || j > 5 && i > 5
						|| j < 3 && i > 5) {
					textField[i][j].setBackground(Color.LIGHT_GRAY);
				}
			}
			yp = yp + 60;
			xp = 0;
		}
		GF.pack();
		GF.setSize(750, 750);
		//
		// }
		// GP.add(textField[0][0]);
		turnPush();
	}

	static void turnPush() {
		pull();

		while (Client.turn) {
			for (int rows = 0; rows < 9; rows++) {
				for (int columns = 0; columns < 9; columns++) {

				}
				stateCheck();
			}
			push();
		}
	}

	static void pull() {
		for (int rows = 0; rows < 9; rows++) {
			for (int columns = 0; columns < 9; columns++) {
				sget[rows][columns] = new String();

				sget[rows][columns] = textField[rows][columns].getText();

			}
		}
	}

	static void push() {
		for (int rows = 0; rows < 9; rows++) {
			for (int columns = 0; columns < 9; columns++) {
				sset[rows][columns] = new String();
				System.out.print(rows);
				System.out.print(columns);
				System.out.println("");
				sset[rows][columns] = textField[rows][columns].getText();
				if (sset[rows][columns].matches(sget[rows][columns])) {

				} else {
					x = rows;
					y = columns;
					scan();

					System.out.println("turn");
					Client.turn = false;
					turnType = !turnType;
					try {
						Timer.run();
						turnPush();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

	}
	static void stateCheck() {
		System.err.println("checked");
		if(isWinner) {
			System.err.println("checked in");
			if(turnType) {
				JOptionPane.showMessageDialog(null, "player 2 wins");
			}else {
				JOptionPane.showMessageDialog(null, "player 1 wins");
			}
		}
	}

	static void scan() {
		System.err.print(x);
		System.err.print(y);
		for (int rows = 0; rows < 9; rows++) {
			for (int columns = 0; columns < 9; columns++) {
				// sset[rows][columns]

				if (x == 0 && y == 0 || x == 0 && y == 1 || x == 0 && y == 2 || x == 1 && y == 0 || x == 1 && y == 1
						|| x == 1 && y == 2 || x == 2 && y == 0 || x == 2 && y == 1 || x == 2 && y == 2) {
					System.out.println("upper left");
					if (rows == 0 && columns == 0 || rows == 0 && y == 1 || rows == 0 && columns == 2
							|| rows == 1 && columns == 0 || rows == 1 && columns == 1 || rows == 1 && columns == 2
							|| rows == 2 && columns == 0 || rows == 2 && columns == 1 || rows == 2 && columns == 2) {
						if (x == rows && y == columns) {
						} else if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
							System.err.print(columns);
							System.err.print(rows);
							isWinner = true;
						}

					}
				} if (x == 3 && y == 3 || x == 3 && y == 4 || x == 3 && y == 5 || x == 4 && y == 3
						|| x == 4 && y == 4 || x == 4 && y == 5 || x == 5 && y == 3 || x == 5 && y == 4
						|| x == 5 && y == 5) {
					System.out.println("center center");
					if (rows == 3 && columns == 3 || rows == 3 && columns == 4 || rows == 3 && columns == 5
							|| rows == 4 && columns == 3 || rows == 4 && columns == 4 || rows == 4 && columns == 5
							|| rows == 5 && columns == 3 || rows == 5 && columns == 4 || rows == 5 && columns == 5) {
						System.out.println("part of th hive");
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
								isWinner = true;
								System.out.println("winnnnner");
							}
						}
					}
				} else if (x == 6 && y == 6 || x == 6 && y == 7 || x == 6 && y == 8 || x == 7 && y == 6
						|| x == 7 && y == 7 || x == 7 && y == 8 || x == 8 && y == 7 || x == 8 && y == 7
						|| x == 8 && y == 8) {
					System.out.println("lower right");
					if (rows == 6 && columns == 6 || rows == 6 && columns == 7 || rows == 6 && columns == 8
							|| rows == 7 && columns == 6 || rows == 7 && columns == 7 || rows == 7 && columns == 8
							|| rows == 8 && columns == 7 || rows == 8 && columns == 7 || rows == 8 && columns == 8) {
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
								isWinner = true;
							}
						}
					}
				} else if (x == 3 && y == 6 || x == 3 && y == 7 || x == 3 && y == 8 || x == 4 && y == 6
						|| x == 4 && y == 7 || x == 4 && y == 8 || x == 5 && y == 7 || x == 5 && y == 7
						|| x == 5 && y == 8) {
					System.out.println("center right");
					if (rows == 3 && columns == 6 || rows == 3 && columns == 7 || rows == 3 && columns == 8
							|| rows == 4 && columns == 6 || rows == 4 && columns == 7 || rows == 4 && columns == 8
							|| rows == 5 && columns == 7 || rows == 5 && columns == 7 || rows == 5 && columns == 8) {
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
								isWinner = true;
							}
						}
					}
				} else if (x == 6 && y == 3 || x == 6 && y == 4 || x == 6 && y == 5 || x == 7 && y == 3
						|| x == 7 && y == 4 || x == 7 && y == 5 || x == 8 && y == 3 || x == 8 && y == 4
						|| x == 8 && y == 5) {
					System.out.println("lower center");
					if (rows == 6 && columns == 3 || rows == 6 && columns == 4 || rows == 6 && columns == 5
							|| rows == 7 && columns == 3 || rows == 7 && columns == 4 || rows == 7 && columns == 5
							|| rows == 8 && columns == 3 || rows == 8 && columns == 4 || rows == 8 && columns == 5) {
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
								
								isWinner = true;
							}
						}
					}
				} else if (x == 0 && y == 3 || x == 0 && y == 4 || x == 0 && y == 5 || x == 1 && y == 3
						|| x == 1 && y == 4 || x == 1 && y == 5 || x == 2 && y == 3 || x == 2 && y == 4
						|| x == 2 && y == 5) {
					System.out.println("upper center");
					if (rows == 0 && columns == 3 || rows == 0 && columns == 4 || rows == 0 && columns == 5
							|| rows == 1 && columns == 3 || rows == 1 && columns == 4 || rows == 1 && columns == 5
							|| rows == 2 && columns == 3 || rows == 2 && columns == 4 || rows == 2 && columns == 5) {
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
								isWinner = true;
							}
						}
					}
				} else if (x == 0 && y == 6 || x == 0 && y == 7 || x == 0 && y == 8 || x == 1 && y == 6
						|| x == 1 && y == 7 || x == 1 && y == 8 || x == 2 && y == 7 || x == 2 && y == 7
						|| x == 2 && y == 8) {
					System.out.println("upper right");
					if (rows == 0 && columns == 6 || rows == 0 && columns == 7 || rows == 0 && columns == 8
							|| rows == 1 && columns == 6 || rows == 1 && columns == 7 || rows == 1 && columns == 8
							|| rows == 2 && columns == 7 || rows == 2 && columns == 7 || rows == 2 && columns == 8) {
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
								isWinner = true;
							}
						}
					}
				} else if (x == 3 && y == 0 || x == 3 && y == 1 || x == 3 && y == 2 || x == 4 && y == 0
						|| x == 4 && y == 1 || x == 4 && y == 2 || x == 5 && y == 0 || x == 5 && y == 1
						|| x == 5 && y == 2) {
					System.out.println("center left");
					if (rows == 3 && columns == 0 || rows == 3 && columns == 1 || rows == 3 && columns == 2
							|| rows == 4 && columns == 0 || rows == 4 && columns == 1 || rows == 4 && columns == 2
							|| rows == 5 && columns == 0 || rows == 5 && columns == 1 || rows == 5 && columns == 2) {
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
							}
						}
					}
				} else if (x == 6 && y == 0 || x == 6 && y == 1 || x == 6 && y == 2 || x == 7 && y == 0
						|| x == 7 && y == 1 || x == 7 && y == 2 || x == 8 && y == 0 || x == 8 && y == 1
						|| x == 8 && y == 2) {
					System.out.println("lower left");
					if (rows == 6 && columns == 0 || rows == 6 && columns == 1 || rows == 6 && columns == 2
							|| rows == 7 && columns == 0 || rows == 7 && columns == 1 || rows == 7 && columns == 2
							|| rows == 8 && columns == 0 || rows == 8 && columns == 1 || rows == 8 && columns == 2) {
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
								isWinner = true;
							}
						}
					}
				}
				// columns vertical

				if (y == 0) {
					if (columns == 0) {
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
								isWinner = true;
							}
						}
					}
				} else if (y == 1) {
					if (columns == 1) {
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
								isWinner = true;
							}
						}
					}
				} else if (y == 2) {
					if (columns == 2) {
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
								isWinner = true;
							}
						}
					}
				} else if (y == 3) {
					if (columns == 3) {
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
								isWinner = true;
							}
						}
					}
				} else if (y == 4) {
					if (columns == 4) {
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
								isWinner = true;
							}
						}
					}
				} else if (y == 5) {
					if (columns == 5) {
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
								isWinner = true;
							}
						}
					}
				} else if (y == 6) {
					if (columns == 6) {
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
								isWinner = true;
							}
						}
					}
				} else if (y == 7) {
					if (columns == 7) {
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
								isWinner = true;
							}
						}
					}
				} else if (y == 8) {
					if (columns == 8) {
						if (x == rows && y == columns) {
						} else {
							if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
								isWinner = true;
							}
						}
					}
				}

				//rows
				
				 if (x == 0) {
						if (rows == 0) {
							if (x == rows && y == columns) {
							} else {
								if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
									isWinner = true;
								}
							}
						}
					} else if (x == 1) {
						if (rows == 1) {
							if (x == rows && y == columns) {
							} else {
								if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
									isWinner = true;
								}
							}
						}
					} else if (x == 2) {
						if (rows == 2) {
							if (x == rows && y == columns) {
							} else {
								if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
									isWinner = true;
								}
							}
						}
					} else if (x == 3) {
						if (rows == 3) {
							if (x == rows && y == columns) {
							} else {
								if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
									isWinner = true;
								}
							}
						}
					} else if (x == 4) {
						if (rows == 4) {
							if (x == rows && y == columns) {
							} else {
								if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
									isWinner = true;
								}
							}
						}
					} else if (x == 5) {
						if (rows == 5) {
							if (x == rows && y == columns) {
							} else {
								if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
									isWinner = true;
								}
							}
						}
					} else if (x == 6) {
						if (rows == 6) {
							if (x == rows && y == columns) {
							} else {
								if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
									isWinner = true;
								}
							}
						}
					} else if (x == 7) {
						if (rows == 7) {
							if (x == rows && y == columns) {
							} else {
								if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
									isWinner = true;
								}
							}
						}
					} else if (x == 8) {
						if (rows == 8) {
							if (x == rows && y == columns) {
							} else {
								if (sset[x][y].equals(sset[rows][columns]) && !sset[rows][columns].equals("")) {
									isWinner = true;
								}
							}
						}
					}
				 stateCheck();
				 if(isWinner) {
						System.err.println("checked in");
						if(turnType) {
							JOptionPane.showMessageDialog(null, "player 2 wins");
						}else {
							JOptionPane.showMessageDialog(null, "player 1 wins");
						}
					}
			}
		}
	}

}
