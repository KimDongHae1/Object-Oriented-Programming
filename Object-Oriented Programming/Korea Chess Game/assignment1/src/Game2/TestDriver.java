package Game2;

import java.util.Scanner;

public class TestDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean set = true;
		Board board = new Board(); // 판 생성.
		board.makeBoard(); // 판의 크기 생성.
		int a = board.inputFromUserBoardSize()-1;
		int b = board.makeBoard();
		if (a == 4) {
			board.setInitialHorsePotision2(b,a); // 말의 위치를 정한다.
			
		}
		else if (a == 3 || a == 5) {
			board.setInitialHorsePotision(b,a); // 말의 위치를 정한다.
		}
		
		board.GameStart(); // 게임 시작한다.
		while(set) // 게임 재실행.
			{
				System.out.println("게임을 다시 시작하겠습니까? y / n");
				String GameReset = sc.nextLine();
			 	if(GameReset.equals("y") == true) {
			 		board.makeBoard(); // 판의 크기 생성.
			 		a = board.inputFromUserBoardSize()-1;
			 		b = board.makeBoard();
			 		if (a == 4) {
			 			board.setInitialHorsePotision2(b,a);
			 			set = true;
			 		}
				
			 		else if (a == 3 || a == 5 ) {
			 			board.setInitialHorsePotision(b,a);
			 		}// 말의 위치를 정한다.
			 			board.GameStart(); // 게임 시작한다.
			 			set = true;
			}
			 	else if (GameReset.equals("n")== true) {
			 		System.exit(0);
			}
		}
	}
}