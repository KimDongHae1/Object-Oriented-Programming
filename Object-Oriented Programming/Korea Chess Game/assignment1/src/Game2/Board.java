package Game2;

import java.util.Scanner;

public class Board {
	int boardSize; 
	Horse cho;
	Horse han;
	
	public Board() {
		cho = new Horse(0,0);
		han = new Horse(0,0);
	} // 말을 생성하는 메소드이다.
		
	public int inputFromUserBoardSize() {
		
		Scanner sc = new Scanner(System.in);
		int a;
		boolean gamesize = true;
		while(gamesize)
			{
			System.out.println("보드의 크기를 입력하세요!4,5,6중에 ");
			a = sc.nextInt();
			this.boardSize = a;
			if(a == 4 || a == 5 || a == 6 ) {
				return this.boardSize;
			}
			else {
				
			}
		}
		return 0;
	} // 판의 크기를 입력받는 메소드이다.
	
	public int makeBoard() {
		int base = 0;		
		if ( this.boardSize == 4 ) {
			base = (this.boardSize/2)-1;
		}
		else if (this.boardSize == 5) {
			base = ((this.boardSize+1)/2)-1;
		}
		else if (this.boardSize == 6) {
			base = (this.boardSize/2)-1;
		}
		return base;
	} // 사용자가 받을 수 있는 board판의 크기를 입력받는 메소드이다.

	public void setInitialHorsePotision(int x, int y) // 처음 말들이 시작하는 위치를 입력하는 메소드이다.
	{
		cho.setX(x);
		cho.setY(0);
		han.setX(x+1);
		han.setY(y);
	}
	public void setInitialHorsePotision2(int x, int y) // 처음 말들이 시작하는 위치를 입력하는 메소드이다.
	{
		cho.setX(x);
		cho.setY(0);
		han.setX(x);
		han.setY(y);
	}
		
	
	public void GameStart() // 실제로 경기를 실행하는 메소드이다.
	{
		boolean gama = true;
		while (gama) {
			Scanner sc = new Scanner(System.in);
			System.out.print("> 초나라 공격! enter키를 누르세요!");
			String enter = sc.nextLine();
			System.out.print("현재 위치 : ");
			cho.Current(cho.getX(), cho.getY());
			System.out.print("현재 말이 움직일 수 있는 위치 : ");
			cho.CurrentMove(cho.getX(), cho.getY(),this.boardSize);
			System.out.println("");
			if(cho.GameEnd(han, cho.getX(), cho.getY(), this.boardSize)== false) {
				System.out.println("공격 성공!! 초나라 승리!!");
				System.out.println("경기 종료!");
				break;
			}
			else {
				cho.RealityMove(cho.getX(), cho.getY(), this.boardSize);
			}
			System.out.println();
			System.out.print("> 한나라 공격! enter키를 누르세요!");
			enter = sc.nextLine();
			System.out.print("현재 위치 : ");
			han.Current(han.getX(), han.getY());
			System.out.print("현재 말이 움직일 수 있는 위치 : ");
			han.CurrentMove(han.getX(), han.getY(),this.boardSize);
			System.out.println("");
			if(han.GameEnd(cho, han.getX(), han.getY(), this.boardSize)== false) {
				System.out.println("공격 성공 한나라 승리!");
				System.out.println("경기 종료!");
				break;
			}
			else {
				han.RealityMove(han.getX(), han.getY(), this.boardSize);
			}
			System.out.println();
				}	
		}
}	
	



		
	


