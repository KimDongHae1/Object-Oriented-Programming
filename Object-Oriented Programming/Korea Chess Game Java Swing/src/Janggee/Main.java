package Janggee;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Main extends JFrame{
	static JFrame frame;
	static Board board = new Board();
	JPanel Boardpanel;
	
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	
	
	JButton Startbu;
	JButton Endbu;

	
	JLabel label;
	JLabel label2;
	

	MakePanel make = new MakePanel();
	
	private static final int DEFAULT_WIDTH = 900;
	private static final int DEFAULT_HEIGHT = 700;
	
	
	public static void main(String[] args) {
		
		frame = new Main();
		frame.setTitle("Mini-jangki");
		frame.setBounds(300,400
				, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
//		int count2 = 0;
//		int count3 = 0;
//		 for (int k = 0 ; k < 7 ; k++){
//				for (int l = 0 ; l < 7  ; l++) {
//					if(board.getSpot(k, l).getHorse().getTurn() == true) {
//						count2++;
//					}
//					else if (board.getSpot(k, l).getHorse().getTurn() == false) {
//						count3++;
//					}
//				}
//			}
//			if(count2 == 0 || count3 == 0) {
//				System.out.println("종료");
//			}
//			count2 = 0;
//			count3 =0;

	}
	
	public Main() {
		Boardpanel = make.Makepanel();
		add(BorderLayout.WEST,Boardpanel);
//		==========	==========	==========	==========	==========	==========
		
		JPanel MessagePanel = new JPanel();
//		tf1 = new JTextField(); 
//		Button button = new Button("메세지 창 : ");
//		tf1.setColumns(50);
//		MessagePanel.add(BorderLayout.WEST,button);
//		MessagePanel.add(tf1);
		MessagePanel = make.Message();
		add(BorderLayout.SOUTH,MessagePanel);
		
//		==========	==========	==========	==========	==========	==========
		
		JPanel ControlPanel = new JPanel();

		tf2 = make.tf2();
		tf3 = make.tf3();
		add(tf2);
		add(tf3);
		
		label = new JLabel();
		label2 = new JLabel();
		label.setBounds(610,140,50,40);
		label.setText("Han : ");
		label2.setBounds(610,170,50,40);
		label2.setText("Cho : ");
		add(label);
		add(label2);
		
		Startbu = make.start();
		Endbu = new JButton();
		Endbu.setBounds(710,350,100,120);
		Endbu.setText("종료");
		add(Startbu);
		add(Endbu);
	
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b =(JButton)e.getSource();
				if (b.getText().equals("종료")){
					int choice = JOptionPane.showOptionDialog (null, 
						      "정말로 종료 하시겠습니까?", 
						      "종료 하시겠습니까?", 
						      JOptionPane.YES_NO_OPTION, 
						      JOptionPane.QUESTION_MESSAGE, 
						      null, null, null); 

						  // 사용자의 선택을 해석 
						  if (choice == JOptionPane.YES_OPTION) 
						  { 
						    System.exit (0); 
						  } 
						}
				}
		};
		add(ControlPanel);
		Endbu.addActionListener(action);
	}
	
}

