package Janggee;

public class Spot { // 체스 판위의 한 칸을 나타낼 클래스
	private int x;
	private int y;
	private int color; //
	private Horse horse; // 말이 없을 경우 null, 말이 있을 경우 타입별로 매칭.
	public Spot(int x, int y, int color) {
		this.x = x;
		this.y = y;
		this.color = color;
		horse = null;
	}
	public void occupySpot(Horse horse) { // 말을 그 자리에 배치하는 메소드
		if (this.horse != null) {
			this.horse.setAvailable(false); // 자리에 말이 있을 경우, 그 말을 죽임
		}
		this.horse = horse;
	}

	public boolean isOccupied() { // 말이 있는지 없는지 확인할 메소드
		return this.horse != null;
	}

	public Horse getHorse() {
		return horse;
	}

	public void setHorse(Horse horse) {
		this.horse = horse;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
}

