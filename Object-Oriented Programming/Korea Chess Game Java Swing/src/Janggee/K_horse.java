package Janggee;


public class K_horse extends Horse {
	public K_horse(int x, int y, boolean available, int color, String type, boolean turn) {
		super(x, y, available, color, type, turn);
	}
	@Override
	public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
		if (Math.abs(toX-fromX)+ Math.abs(toY-fromY) > -1) {
		return false;
		}
		return false;
	}
	
}
