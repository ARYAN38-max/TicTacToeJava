package tic_tac_toe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tic_tac_toe_code implements ActionListener {
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_Panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] button = new JButton[9];
	boolean player1_turn;

	tic_tac_toe_code() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		textfield.setBackground(new Color(25, 25, 25));
		textfield.setForeground(new Color(25, 255, 0));
		textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("TIC-TAC-TOE");
		textfield.setOpaque(true);

		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 800, 100);

		button_Panel.setLayout(new GridLayout(3, 3));
		button_Panel.setBackground(Color.DARK_GRAY);

		for (int i = 0; i < 9; i++) {
			button[i] = new JButton();
			button_Panel.add(button[i]);
			button[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			button[i].setFocusable(false);
			button[i].addActionListener(this);

		}

		title_panel.add(textfield);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_Panel);
		First_turn();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == button[i]) {
				if (player1_turn) {
					if (button[i].getText() == "") {
						button[i].setForeground(new Color(255, 0, 0));
						button[i].setText("X");
						player1_turn = false;
						textfield.setText("O - TURN ");
						check();
					}
				} else {
					if (button[i].getText() == "") {
						button[i].setForeground(new Color(255, 0, 0));
						button[i].setText("O");
						player1_turn = true;
						textfield.setText("X - TURN ");
						check();
					}
				}
			}

		}
	}

	public void First_turn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (random.nextInt(2) == 0) {
			player1_turn = true;
			textfield.setText("X-TURN");
		} else {
			player1_turn = false;
			textfield.setText("O-TURN");
		}

	}

	public void check() {
		// x win
		if ((button[0].getText() == "X")
				&& (button[1].getText() == "X") &&
				(button[2].getText() == "X")) {
			xWin(0, 1, 2);
			

		}
		if ((button[3].getText() == "X")
				&& (button[4].getText() == "X") &&
				(button[5].getText() == "X")) {
			xWin(3, 4, 5);
			}
		if ((button[6].getText() == "X")
				&& (button[7].getText() == "X") &&
				(button[8].getText() == "X")) {
			xWin(6, 7, 8);
			}
		if ((button[0].getText() == "X")
				&& (button[3].getText() == "X") &&
				(button[6].getText() == "X")) {
			xWin(0, 3, 6);
			}
		if ((button[1].getText() == "X")
				&& (button[4].getText() == "X") &&
				(button[7].getText() == "X")) {
			xWin(1, 4, 7);
			}
		if ((button[2].getText() == "X")
				&& (button[5].getText() == "X") &&
				(button[8].getText() == "X")) {
			xWin(2, 5, 8);
			}
		if ((button[0].getText() == "X")
				&& (button[4].getText() == "X") &&
				(button[8].getText() == "X")) {
			xWin(0, 4, 8);
			}
		if ((button[2].getText() == "X")
				&& (button[4].getText() == "X") &&
				(button[6].getText() == "X")) {
			xWin(2, 4, 6);
			}
		//o win
		if ((button[0].getText() == "O")
				&& (button[1].getText() == "O") &&
				(button[2].getText() == "O")) {
			oWin(0, 1, 2);
			

		}
		if ((button[3].getText() == "O")
				&& (button[4].getText() == "O") &&
				(button[5].getText() == "O")) {
			oWin(3, 4, 5);
			}
		if ((button[6].getText() == "O")
				&& (button[7].getText() == "O") &&
				(button[8].getText() == "O")) {
			oWin(6, 7, 8);
			}
		if ((button[0].getText() == "O")
				&& (button[3].getText() == "O") &&
				(button[6].getText() == "O")) {
			oWin(0, 3, 6);
			}
		if ((button[1].getText() == "O")
				&& (button[4].getText() == "O") &&
				(button[7].getText() == "O")) {
			oWin(1, 4, 7);
			}
		if ((button[2].getText() == "O")
				&& (button[5].getText() == "O") &&
				(button[8].getText() == "O")) {
			oWin(2, 5, 8);
			}
		if ((button[0].getText() == "O")
				&& (button[4].getText() == "O") &&
				(button[8].getText() == "O")) {
			oWin(0, 4, 8);
			}
		if ((button[2].getText() == "O")
				&& (button[4].getText() == "O") &&
				(button[6].getText() == "O")) {
			oWin(2, 4, 6);
			}

	}

	public void xWin(int a, int b, int c) {
		button[a].setBackground(Color.black);
		button[b].setBackground(Color.black);
		button[c].setBackground(Color.black);
		
		for(int i = 0 ;i < 9;i++) {
			 button[i].setEnabled(false);
		}
		textfield.setText("X WINS");

	}

	public void oWin(int a, int b, int c) {
		button[a].setBackground(Color.black);
		button[b].setBackground(Color.black);
		button[c].setBackground(Color.black);
		
		for(int i = 0 ;i < 9;i++) {
			 button[i].setEnabled(false);
		}
		textfield.setText("O WINS");

	}

}
