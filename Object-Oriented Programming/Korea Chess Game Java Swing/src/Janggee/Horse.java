package Janggee;

public abstract class Horse { // 체스 말을 나타낼 추상 클래스.
	private int x;
	private int y;
	private boolean available; // 죽었을 경우 false, 그렇지 않으면 true
	private int color; // 초나라 0, 한나라 1
	private String type;
	private boolean turn;

	public Horse(int x, int y, boolean available, int color, String type, boolean turn) { 
		this.x = x;
		this.y = y;
		this.available = available;
		this.color = color;
		this.type = type;
		this.turn = turn;
	}
	public void turnchange() {
		if(this.getTurn() == true) {
			this.setTurn(false);
		}
		else if (this.getTurn() == false) {
			this.setTurn(true);
		}
	}
	public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) { // 말이 이동하고자 하는 위치로 이동 가능한지 확인할 메소드
	    if((toX != fromX || toY != fromY) && toX >= 0 && toX <= 7 && toY >= 0 && toY <= 7 && (board.getSpot(toX, toY).getHorse() == null)) {
	        return true;
        }// 제자리 이동일 경우와 이동하고자 하는 위치가 체스 판을 벗어날 경우. 그리고 이동하고자 하는 위치에 말이 있을 경우에 이동이 불가능 하도록 함.
        try {
            if (board.getSpot(toX, toY).getHorse() != null&& board.getSpot(toX, toY).getHorse().getColor() != getColor()) { // 이동하고자 하는 위치에 다른 색의 말이 있을 경우.
                board.getSpot(toX, toY).occupySpot(this);
                return true;
            }
           
        } catch (ArrayIndexOutOfBoundsException e) { 
	        return false;
        }

		return false;
	}
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	public boolean getTurn() {
		return turn;
	}
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
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
}

