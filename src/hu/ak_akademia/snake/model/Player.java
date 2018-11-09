package hu.ak_akademia.snake.model;

public class Player {

	private long time;
	private int point;
	private long startTime = System.currentTimeMillis();
	private int selectedBoard = 0;

	public int getSelectedBoard() {
		return selectedBoard;
	}

	public void setSelectedBoard(int selectedBoard) {
		this.selectedBoard = selectedBoard;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Time: " + (System.currentTimeMillis() - startTime) / 1000 + "s  Points: " + point;
	}
}
