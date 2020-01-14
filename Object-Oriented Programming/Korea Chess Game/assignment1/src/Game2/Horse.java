package Game2;

import java.util.Random;

public class Horse 
{
	/*
	 * 말의 객체에 필요한 정보.
	 */
	private int x;
	private int y;
	
	public Horse(int x, int y) // 말의 객체를 초기화했다.
	{
		this.x = x;
		this.y = y;
	}
	
	public boolean isValid(int toX, int toY, int N) // 이 메소드는 말이 움직일 수 있는 범위를 나타낸 것이다.
	{
		if(toX >= 0 && toX < N && toY >= 0 && toY < N) {
			return true;
		}
		else {
			return false;
		}
	}

	public int getX() //x의 값을 return한다.
	{
		return x;
	}

	public void setX(int x)//x의 값으 변경하는데 이용한다.
	{
		this.x = x;
	}

	public int getY() // y의 값을 return한다.
	{
		return y;
	}

	public void setY(int y) // y의 값을 변경하는 데 이용한다.
	{
		this.y = y;
	}
	
	public void Current (int x, int y) // 현재위치를 나타내는 메소드.
	{
		System.out.println("(" + this.x + ","+ this.y + ")");
	}
	/*
	 *  여기 밑에서 부터는 말이 이동하는 모든 경우의 수를 이용해 메소드를 만들었다.
	 */
	public void CurrentMove(int x, int y,int N) // 현재 움직일 수 있는 위치를 나타내는 메소드.
	{
		int a = 0;
		int b = 0;
		for (int i = 1 ; i < 9 ; i ++) // 8가지의 경우의 수를 모두 비교하기 위해 반복문을 사용했다.
		{
			if(i == 1) {
				if(this.isValid(this.getX()+2, this.getY()+1,N) == true) {
					a = this.getX()+2;
					b = this.getY()+1;
					System.out.print("(" + a + ","+ b +")");
				}
			}
			else if (i == 2) {
				if (this.isValid(this.getX()+2, this.getY()-1,N) == true) {
					a = this.getX()+2;
					b = this.getY()-1;
					System.out.print("(" + a + ","+ b +")");
				}
			}
			else if (i == 3) {
				if (this.isValid(this.getX()-2, this.getY()+1,N) == true) {
					a = this.getX()-2;
					b = this.getY()+1;
					System.out.print("(" + a + ","+ b +")");
				
				}
			}
			else if (i == 4) {
				if (this.isValid(this.getX()-2, this.getY()-1,N) == true) {
					a = this.getX()-2;
					b = this.getY()-1;
					System.out.print("(" + a + ","+ b +")");
					
				}
			}
			else if (i == 5) {
				if (this.isValid(this.getX()+1, this.getY()+2,N) == true) {
					a = this.getX()+1;
					b = this.getY()+2;
					System.out.print("(" + a + ","+ b +")");
					
				}
			}	
			else if (i == 6) {
				if (this.isValid(this.getX()+1, this.getY()-2,N) == true) {
					a = this.getX()+1;
					b = this.getY()-2;
					System.out.print("(" + a + ","+ b +")");
					
				}
			}
			else if (i == 7) {
				if (this.isValid(this.getX()-1, this.getY()+2,N) == true) {
					a = this.getX()-1;
					b = this.getY()+2;
					System.out.print("(" + a + ","+ b +")");
					
				}
			}
			else if (i == 8) {
				if (this.isValid(this.getX()-1, this.getY()-2,N) == true) {
					a = this.getX()-1;
					b = this.getY()-2;
					System.out.print("(" + a + ","+ b +")");
			
				}
			}
		}
	}
	/*
	 * isValid 메소드가 true일 경우와 랜덤함수를 비교해 둘다 트루일 경우 setX(),setY()메소드를 이용해 실제로 움직이도록 구현했다. 
	 */
	public void RealityMove(int x, int y, int N) {
		Random random = new Random();
		
		boolean RandomMove = true;
		
		while(RandomMove) {
			int move = random.nextInt(8)+1;
			if (move == 1) {
				if(this.isValid(this.getX()+2, this.getY()+1,N)) {
					this.setX(x+2);
					this.setY(y+1);
					System.out.println("(" + this.getX() + "," + this.getY() + ")으로 이동!");
					RandomMove = false;
				}
			}
			else if (move == 2) {
				if(this.isValid(this.getX()+2, this.getY()-1,N)) {
					this.setX(x+2);
					this.setY(y-1);
					System.out.println("(" + this.getX() + "," + this.getY() + ")으로 이동!");
					RandomMove = false;
				}
			}
			else if (move == 3) {
				if(this.isValid(this.getX()-2, this.getY()+1,N)) {
					this.setX(x-2);
					this.setY(y+1);
					System.out.println("(" + this.getX() + "," + this.getY() + ")으로 이동!");
					RandomMove = false;
				}
			}
			else if (move == 4) {
				if(this.isValid(this.getX()-2, this.getY()-1,N)) {
					this.setX(x-2);
					this.setY(y-1);
					System.out.println("(" + this.getX() + "," + this.getY() + ")으로 이동!");
					RandomMove = false;
				}
			}
			else if (move == 5) {
				if(this.isValid(this.getX()+1, this.getY()+2,N)) {
					this.setX(x+1);
					this.setY(y+2);
					System.out.println("(" + this.getX() + "," + this.getY() + ")으로 이동!");
					RandomMove = false;
				}
			}
			else if (move == 6) {
				if(this.isValid(this.getX()+1, this.getY()-2,N)) {
					this.setX(x+1);
					this.setY(y-2);
					System.out.println("(" + this.getX() + "," + this.getY() + ")으로 이동!");
					RandomMove = false;
				}
			}
			else if (move == 7) {
				if(this.isValid(this.getX()-1, this.getY()+2,N)) {
					this.setX(x-1);
					this.setY(y+2);
					System.out.println("(" + this.getX() + "," + this.getY() + ")으로 이동!");
					RandomMove = false;
				}
			}
			else if (move == 8) {
				if(this.isValid(this.getX()-1, this.getY()-2,N)) {
					this.setX(x-1);
					this.setY(y-2);
					System.out.println("(" + this.getX() + "," + this.getY() + ")으로 이동!");
					RandomMove = false;
				}
			}
		}
	}
	// 내가 움직일 수 있는 곳에 상대의 말이 있으면 경기를 끝내는 메소드이다.
	public boolean GameEnd(Horse horse, int x, int y, int N ) {
		for (int i = 1 ; i < 9 ; i ++) {
			int a = 0;
			int b = 0;
			if(i == 1) {
				if(this.isValid(this.getX()+2, this.getY()+1,N) == true) {
					a = this.getX()+2;
					b = this.getY()+1;
					if (horse.getX() == a && horse.getY() == b ) {
						return false;
				}
				}
			}
			else if (i == 2) {
				if (this.isValid(this.getX()+2, this.getY()-1,N) == true) {
					a = this.getX()+2;
					b = this.getY()-1;
					if (horse.getX() == a && horse.getY() == b ) {
						return false;
				}
			}
		}
			else if (i == 3) {
				if (this.isValid(this.getX()-2, this.getY()+1,N) == true) {
					a = this.getX()-2;
					b = this.getY()+1;
					if (horse.getX() == a && horse.getY() == b ) {
						return false;
				}
			}
		}
			else if (i == 4) {
				if (this.isValid(this.getX()-2, this.getY()-1,N) == true) {
					a = this.getX()-2;
					b = this.getY()-1;
					if (horse.getX() == a && horse.getY() == b ) {
						return false;
				}
			}
		}
			else if (i == 5) {
				if (this.isValid(this.getX()+1, this.getY()+2,N) == true) {
					a = this.getX()+1;
					b = this.getY()+2;
					if (horse.getX() == a && horse.getY() == b ) {
						return false;
				}
					
				}
			}	
			else if (i == 6) {
				if (this.isValid(this.getX()+1, this.getY()-2,N) == true) {
					a = this.getX()+1;
					b = this.getY()-2;
					if (horse.getX() == a && horse.getY() == b ) {
						return false;
				}
					
				}
			}
			else if (i == 7) {
				if (this.isValid(this.getX()-1, this.getY()+2,N) == true) {
					a = this.getX()-1;
					b = this.getY()+2;
					if (horse.getX() == a && horse.getY() == b ) {
						return false;
				}
					
				}
			}
			else if (i == 8) {
				if (this.isValid(this.getX()-1, this.getY()-2,N) == true) {
					a = this.getX()-1;
					b = this.getY()-2;
					if (horse.getX() == a && horse.getY() == b ) {
						return false;
					}
				}
			}
		}
		return true;
	}
}

			

