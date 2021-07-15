import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
	JFrame frame = new JFrame();
	JLabel textfield = new JLabel();
	JPanel title = new JPanel();
	JPanel ButtonPanel = new JPanel();
	JButton[] buttons = new JButton[9];
	Random computer = new Random();
	boolean player1;
	
	TicTacToe(){
		
		textfield.setBackground(new Color(224,238,238));
		textfield.setForeground(new Color(139,71,93));
		textfield.setFont(new Font("Serif",Font.BOLD,60));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setOpaque(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,700);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		title.setLayout(new BorderLayout());
		title.setBounds(0,0,800,100);
		
		ButtonPanel.setLayout(new GridLayout(3,3));
		ButtonPanel.setBackground(new Color(224,238,238));
		ButtonPanel.setBounds(100,100,300,150);

		for(int x=0;x<9;x++) {
			buttons[x] = new JButton();
			ButtonPanel.add(buttons[x]);
			buttons[x].setFont(new Font("Serif",Font.BOLD,90));
			buttons[x].setFocusable(false);
			buttons[x].addActionListener(this);			
		}
		
		frame.setBounds(450,130,600,600);
		frame.add(ButtonPanel, BorderLayout.CENTER);
		frame.add(title,BorderLayout.NORTH);
		title.add(textfield);
		turn();
	}
	
	public void turn() {
		if(computer.nextInt(2)==0) {
			player1=true;
			textfield.setText("X turn!");            
		}
		else {
			player1=false;
			textfield.setText("O turn!");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int x=0;x<9;x++) {
			if(e.getSource()==buttons[x]) {
				if(player1) {
					if(buttons[x].getText()=="") {
						buttons[x].setForeground(new Color(205,38,38));
						buttons[x].setText("X");
						player1=false;
						textfield.setText("O turn!");
						
						winner_control();
					}
				}
				
				else {
					if(buttons[x].getText()=="") {
						buttons[x].setForeground(new Color(58,95,205));
						buttons[x].setText("O");
						player1=true;
						textfield.setText("X turn!");
						
						winner_control();
					}
				}
			}			
		}
	}
	
	public void winner_control() {
		
		// Player X win conditions;
		
		if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()=="X")) {
			xWins(0,1,2);
		}
		if((buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[5].getText()=="X")) {
			xWins(3,4,5);
		}
		if((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&(buttons[8].getText()=="X")) {
			xWins(6,7,8);
		}
		if((buttons[0].getText()=="X")&&(buttons[3].getText()=="X")&&(buttons[6].getText()=="X")) {
			xWins(0,3,6);
		}
		if((buttons[1].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[7].getText()=="X")) {
			xWins(1,4,7);
		}
		if((buttons[2].getText()=="X")&&(buttons[5].getText()=="X")&&(buttons[8].getText()=="X")) {
			xWins(2,5,8);
		}
		if((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[8].getText()=="X")) {
			xWins(0,4,8);
		}
		if((buttons[2].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[6].getText()=="X")) {
			xWins(2,4,6);
		}
		
		// Player O win conditions;
		
		if((buttons[0].getText()=="O")&&(buttons[1].getText()=="O")&&(buttons[2].getText()=="O")) {
			oWins(0,1,2);
		}
		if((buttons[3].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[5].getText()=="O")) {
			oWins(3,4,5);
		}
		if((buttons[6].getText()=="O")&&(buttons[7].getText()=="O")&&(buttons[8].getText()=="O")) {
			oWins(6,7,8);
		}
		if((buttons[0].getText()=="O")&&(buttons[3].getText()=="O")&&(buttons[6].getText()=="O")) {
			oWins(0,3,6);
		}
		if((buttons[1].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[7].getText()=="O")) {
			oWins(1,4,7);
		}
		if((buttons[2].getText()=="O")&&(buttons[5].getText()=="O")&&(buttons[8].getText()=="O")) {
			oWins(2,5,8);
		}
		if((buttons[0].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[8].getText()=="O")) {
			oWins(0,4,8);
		}
		if((buttons[2].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[6].getText()=="O")) {
			oWins(2,4,6);
		}
	}
	
	//Winner conditions;
	
	public void xWins(int a, int b, int c) {
		for(int x=0;x<9;x++) {			
			buttons[x].setEnabled(false);
		}
		textfield.setText("Player X Winner!");
	}
	
	public void oWins(int a, int b, int c) {	
		for(int x=0;x<9;x++) {
			buttons[x].setEnabled(false);
		}
		textfield.setText("Player O Winner!");
	}
}		
