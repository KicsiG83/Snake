package hu.ak_akademia.snake.model;

public class Player {

	private long time;
	private int point;
	private long startTime = System.currentTimeMillis();
	private int selectedBoard;

	public Player(int boardIndex) {
		selectedBoard = boardIndex;
	}
	
	public int getSelectedBoard() {
		return selectedBoard;
	}

	public long getTime() {
		return time;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		time = (System.currentTimeMillis() - startTime) / 1000;
		return "Time: " + time + "s Points: " + point;
	}
}
