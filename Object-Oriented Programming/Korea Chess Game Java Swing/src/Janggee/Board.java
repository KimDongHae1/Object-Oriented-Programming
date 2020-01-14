package Janggee;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Board { // 체스판 클래스
	private Spot[][] spots = new Spot[7][7]; // 체스 판에서 각 자리를 의미하는 배열 생성

	public Board() { //체스 판을 생성함.
		for (int i = 0; i < spots.length; i++) {
			for (int j = 0; j < spots.length; j++) {
				this.spots[i][j] = new Spot(i, j, 3); // 체스 판의 색을 1과 0이 번갈아가며 나타내도록 함.		
			}
		}
	}
	public void makeHorse() { 
	  
	    //한나라 말 장
            spots[0][1].occupySpot(new H_horse(1, 0, true, 1, "H", true));
            spots[0][5].occupySpot(new H_horse(5, 0, true, 1, "H",true));
            spots[2][0].occupySpot(new W2_horse(0, 2, true, 1, "W",true));
            spots[2][3].occupySpot(new W2_horse(3, 2, true, 1, "W", true));
            spots[2][6].occupySpot(new W2_horse(6, 2, true, 1, "W", true));
        //초나라 말 장
            spots[6][1].occupySpot(new H_horse(1, 6, true, 0, "H",false));
            spots[6][5].occupySpot(new H_horse(5, 6, true, 0, "H",false));
            spots[4][0].occupySpot(new W_horse(0, 4, true, 0, "W",false));
            spots[4][3].occupySpot(new W_horse(3, 4, true, 0, "W",false));
            spots[4][6].occupySpot(new W_horse(6, 4, true, 0, "W",false));
    }
	public void make() {
		 for (int i = 0 ; i < 7; i++) {
		    	for (int j = 0; j < 7; j++) {
		            this.spots[j][i].setHorse(null); // 체스판 위의 말을 초기화
	            }
	        }
	}
	public Spot getSpot(int x, int y) {
		return spots[y][x]; //x, y 각 객체의 위치.
	}
	public void printBoard() { //체스판 출력
		for(int i = 0; i < spots.length; i++) {
			for(int j = 0; j < spots.length; j++) {
				if (this.spots[i][j].getHorse() != null && this.spots[i][j].getHorse().isAvailable()) // 말이 있고, 죽지 않았을 경우
					System.out.format("%4s%d", this.spots[i][j].getHorse().getType(), this.spots[i][j].getHorse().getColor()); // 말의 종류와 색을 출력
				else 
					System.out.format("%5d", this.spots[i][j].getColor()); // 체스 판의 색을 출력
			}
			System.out.println();
		}
	}
//	public void GameEnd() {
//		int count = 0;
//		int count1 = 0;
//		for(int i = 0; i < spots.length; i++) {
//			for(int j = 0; j < spots.length; j++) {
//				if(this.getSpot(j, i).getHorse().getColor() == 1) {
//					count++;
//				}
//				else if(this.getSpot(j, i).getHorse().getColor() == 0) {
//					count1++;
//				}
//			}
//		}
//		if (count1 == 5 || count == 5) {
//			System.exit(0);
//		}
//		count = 0;
//		count1 = 0;
//	}
}
