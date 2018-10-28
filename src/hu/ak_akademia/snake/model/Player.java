package hu.ak_akademia.snake.model;

public class Player {
	
	private int time;
	private int point;
	
	public Player() {
		super();
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
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
