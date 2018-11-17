package hu.ak_akademia.snake.model;

public class Player {

	private int time;
	private int point;
	private long startTime = System.currentTimeMillis();
	private int selectedBoard;
	private String name;

	public Player(int boardIndex) {
		selectedBoard = boardIndex;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSelectedBoard() {
		return selectedBoard;
	}

	public int getTime() {
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
		time = (int) ((System.currentTimeMillis() - startTime) / 1000);
		return "Time: " + time + "s Points: " + point;
	}
}
