package hu.ak_akademia.snake.model;

public class Player {

	private String time = "00:00";
	private int point;

	public Player() {
		super();
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
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
		return "Time: " + time + "s  Points: " + point;
	}
}
