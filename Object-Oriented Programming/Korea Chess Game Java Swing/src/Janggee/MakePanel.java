package Janggee;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MakePanel extends JFrame {
	static int count = 1;
	static int count2 = 0;
	static int count3 = 0;
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	
	JButton Startbu;
	JButton Endbu;

	Board board = new Board();
	
	int fromX, fromY, toX, toY;
	
	ImageIcon horse = new ImageIcon(new ImageIcon("img/horse.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
	ImageIcon soldier = new ImageIcon(new ImageIcon("img/soldier.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
	ImageIcon king = new ImageIcon(new ImageIcon("img/king.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
	
	final JButton[][] button =  new JButton[7][7]; 
	
	public JPanel Makepanel() {
		JPanel BoardPanel = new JPanel();
		GridLayout grid = new GridLayout(7,7);
		BoardPanel.setLayout(grid);
		for (int i = 0 ; i < button.length ; i++){
			for (int j = 0 ; j < button.length  ; j++) {
				button[j][i] = new JButton();
				BoardPanel.add(button[j][i]);
			}
		}
	ActionListener action2 = new ActionListener() {
		int fromX, fromY, toX, toY;
		public void actionPerformed(ActionEvent e) {
			JButton b =(JButton)e.getSource();
			for (int i = 0 ; i < button.length ; i++){
				for (int j = 0 ; j < button.length  ; j++) {
					 if(b.equals(button[j][i]) && count == 1) {
							fromX = j;
							fromY = i;
							if(board.getSpot(fromX, fromY).getHorse().getColor() == 1) {
								if (board.getSpot(fromX, fromY).getHorse() == null) 
					                    tf1.setText("해당 위치에 말이 없습니다.");
								 else if(board.getSpot(fromX, fromY).getHorse() != null) 
								 {
									 tf1.setText("한나라 말 선택 완료.");
									 count++;
								 	}
							}
							else if (board.getSpot(fromX, fromY).getHorse().getColor() == 0) {
								if (board.getSpot(fromX, fromY).getHorse() == null) 
				                    tf1.setText("해당 위치에 말이 없습니다.");
							 else if(board.getSpot(fromX, fromY).getHorse() != null) 
							 {
								 tf1.setText("초나라 말 선택 완료.");
								 count++;
							 	}
							}
						}
						else if(b.equals(button[j][i]) && count == 2){
							toX = j;
							toY = i;
							 if (board.getSpot(fromX, fromY).getHorse().isValid(board, fromX, fromY, toX, toY)) 
			                    { // 말이 이동하고자 하는 위치에 이동가능한지 확인
			                    	if (board.getSpot(toX, toY) == board.getSpot(3, 0)) {
			                    		tf1.setText("경기가 종료되었습니다. 초나라가 승리하였습니다.");
			                    		int choice = JOptionPane.showOptionDialog (null, 
			      						      "경기가 끝났습니다. 재시작을 하시겠습니까??y/n", 
			      						      "종료 하시겠습니까?", 
			      						      JOptionPane.YES_NO_OPTION, 
			      						      JOptionPane.QUESTION_MESSAGE, 
			      						      null, null, null); 
			      						  // 사용자의 선택을 해석 
			      						  if (choice == JOptionPane.YES_OPTION) 
			      						  { 
			      						    board.makeHorse();
			      						  } 
			      						  else {
			      							  System.exit(0);;
			      						  }
			                    	}
			                    	
			                    	else if(board.getSpot(toX, toY) == board.getSpot(3, 6)) {
			                    		tf1.setText("경기가 종료되었습니다. 한나라가 승리하였습니다.");
			                    		int choice = JOptionPane.showOptionDialog (null, 
				      						      "경기가 끝났습니다. 재시작을 하시겠습니까??y/n", 
				      						      "종료 하시겠습니까?", 
				      						      JOptionPane.YES_NO_OPTION, 
				      						      JOptionPane.QUESTION_MESSAGE, 
				      						      null, null, null); 
				      						  // 사용자의 선택을 해석 
				      						  if (choice == JOptionPane.YES_OPTION) 
				      						  { 
				      						    board.makeHorse();
				      						  } 
				      						  else {
				      							  System.exit(0);;
				      						  }
			                    		
			                    	}
			                    	else {
			                        board.getSpot(toX, toY).setHorse(board.getSpot(fromX, fromY).getHorse()); // 말을 이동.
			                        board.getSpot(fromX, fromY).setHorse(null); // 원래 있던 위치의 말을 없앰
			                        board.getSpot(toX, toY).getHorse().setX(toX); // 말의 현재 위치를 변경해줌
			                        board.getSpot(toX, toY).getHorse().setY(toY); // 말의 현재 위치를 변경해줌
			                        tf1.setText("말을 "+toX+","+toY +"(으)로 이동 시켰습니다.");
			                    	button[toX][toY].setIcon(button[fromX][fromY].getIcon());
			                    	button[fromX][fromY].setIcon(null);
			                    	}
			                    }
			                    else
			                    {
			                        System.out.println("해당 위치로 이동할 수 없습니다.");
			                    }
							 count = 1;
					}
				
			}
		}
	}
};
		for (int i = 0 ; i < button.length ; i++){
			for (int j = 0 ; j < button.length  ; j++) {
				button[j][i].addActionListener(action2);
			}
		}		
		return BoardPanel;
	}

	
	public JPanel Message() {
		JPanel MessagePanel = new JPanel();
		tf1 = new JTextField(); 
		Button button = new Button("메세지 창 : ");
		tf1.setColumns(50);
		MessagePanel.add(BorderLayout.WEST,button);
		MessagePanel.add(tf1);
		return MessagePanel;
		
	}
	
	public JButton start() {
		Startbu = new JButton();
		Startbu.setBounds(610,350,100,120);
		Startbu.setText("시작");
		
		ActionListener action = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton b =(JButton)e.getSource();
			if(b.getText().equals("시작")) {
				board.makeHorse();
				this.makepan();
				tf2.setEnabled(false);
				tf3.setEnabled(false);
				b.setText("재시작!");
			}
			else if (b.getText().equals("재시작!")) {
				tf2.setEnabled(true);
				tf3.setEnabled(true);
				b.setText("시작");
				
			}
			}
		public void makepan() {
			
			for (int i = 0 ; i < button.length; i ++) {
				for(int j = 0 ; j < button.length; j++) {
					button[j][i].setIcon(null);
				}
			}
			button[1][0].setIcon(horse);
			button[3][0].setIcon(king);
			button[5][0].setIcon(horse);
			button[0][2].setIcon(soldier);
			button[3][2].setIcon(soldier);
			button[6][2].setIcon(soldier);
			
			button[1][6].setIcon(horse);
			button[3][6].setIcon(king);
			button[5][6].setIcon(horse);
			button[0][4].setIcon(soldier);
			button[3][4].setIcon(soldier);
			button[6][4].setIcon(soldier);
		}
		};
		Startbu.addActionListener(action);
		return Startbu;
	}
	public JTextField tf2() {

		tf2 = new JTextField("유방!"); 
		tf2.setColumns(15);
		tf2.setBounds(660,145,100,30);
		return tf2;
	}
	public JTextField tf3() {
		tf3 = new JTextField("항우!"); 
		tf3.setColumns(15);
		tf3.setBounds(660,175,100,30);
		return tf3;
	}

	
}
	
