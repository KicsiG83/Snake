package hu.ak_akademia.snake.model;

public class Player {

	private int timeInSeconds;
	private int minutes;
	private int seconds;
	private String time;
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

	public int getTimeInSeconds() {
		return timeInSeconds;
	}

	public String getTime() {
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

		return "Idő: " + convertSecondsIntoTime() + " Pont: " + point;
	}

	private String convertSecondsIntoTime() {
		timeInSeconds = (int) ((System.currentTimeMillis() - startTime) / 1000);
		minutes = timeInSeconds / 60;
		seconds = timeInSeconds - (minutes * 60);
		if (minutes < 10) {
			if (seconds < 10) {
				time = "0" + minutes + ":0" + seconds;
			} else {
				time = "0" + minutes + ":" + seconds;
			}
		} else {
			if (seconds < 10) {
				time = minutes + ":0" + seconds;
			} else {
				time = minutes + ":" + seconds;
			}

		}
		return time;
	}
}
