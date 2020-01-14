package Janggee;

public class W_horse extends Horse {
	public W_horse(int x, int y, boolean available, int color, String type, boolean turn) {
		super(x, y, available, color, type, turn);
	}

	@Override
	public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
		if (!super.isValid(board, fromX, fromY, toX, toY))
			return false;
		if(Math.abs(toX- fromX) >= 2 || Math.abs(toY - fromY) >= 2) {
			return false;
		}
		if(fromY - toY < 0) {
			return false;
		}
		return true; 
	}
}
