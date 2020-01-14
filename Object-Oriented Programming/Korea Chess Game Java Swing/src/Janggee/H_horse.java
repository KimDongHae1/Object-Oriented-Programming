package Janggee;



public class H_horse extends Horse {
	public H_horse(int x, int y, boolean available, int color, String type, boolean turn) {
		super(x, y, available, color, type, turn);
	}

	@Override
	public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
		
		if (!super.isValid(board, fromX, fromY, toX, toY))
			return false;
		
		if ((toY - fromY) == 2 && (toX-fromX) == 1){
			for (int i = 1; i < 2; i++) {
				if (board.getSpot(fromX, fromY + i).getHorse() != null ) {
					return false;
				}
			}
			return true;
		}
		else if ((toY - fromY) == 2 && (toX - fromX) == -1) {
			for (int i = 1; i < 2; i++) {
				if (board.getSpot(fromX, fromY + i).getHorse() != null ) {
					return false;
				}
			}
			return true;
		}
		else if((toY - fromY) == -2 && (toX - fromX) == +1) {
			for (int i = -1; i < -2; i--) {
				if (board.getSpot(fromX, fromY + i).getHorse() != null ) {
					return false;
				}
			}
			return true;
		}
		else if((toY - fromY) == -2 && (toX - fromX) == -1) {
			for (int i = -1; i < -2; i--) {
				if (board.getSpot(fromX, fromY + i).getHorse() != null ) {
					return false;
				}
			}
			return true;
		}
		else if ((toY - fromY) == 1 && (toX - fromX) == 2){
			for (int i = 1; i < 2; i++) {
				if (board.getSpot(fromX+i , fromY).getHorse() != null ) {
					return false;
				}
			}
			return true;
		}
		else if  ((toY - fromY) == -1 && (toX-fromX) == 2){
			for (int i = 1; i < 2; i++) {
				if (board.getSpot(fromX+i, fromY).getHorse() != null ) {
					return false;
				}
			}
			return true;
		}
		else if((toY - fromY) == 1 && (toX-fromX) == -2){
			for (int i = 1; i < 2; i++) {
				if (board.getSpot(fromX -i, fromY ).getHorse() != null ) {
					return false;
				}
			}
			return true;
		}
		else if ((toY - fromY) == -1 && (toX-fromX) == -2){
			for (int i = 1; i < 2; i++) {
				if (board.getSpot(fromX -i, fromY ).getHorse() != null ) {
					return false;
				}
			}
			return true;
			}
		return false;
	}
}
