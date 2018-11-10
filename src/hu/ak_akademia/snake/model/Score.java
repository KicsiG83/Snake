package hu.ak_akademia.snake.model;

public class Score implements Comparable<Score> {
	protected int point;
	protected long time;

	public Score(int point, long time) {
		this.point = point;
		this.time = time;
	}

	public Score() {
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public long getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public int compareTo(Score score) {
		int result = Integer.compare(this.point, score.point);
		if(result != 0) {
			return result;
		}
		else {
			return Long.compare(score.time, this.time);
			
		}
	}

}
