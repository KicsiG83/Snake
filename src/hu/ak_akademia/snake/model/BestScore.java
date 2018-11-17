package hu.ak_akademia.snake.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.snake.control.JDBC;

public class BestScore extends Score {

	private int bestScore = -1;
	private String bestTime;
	private String bestName;

	public int getBestScore() {
		return bestScore;
	}

	public String getBestTime() {
		return bestTime;
	}

	public String getBestName() {
		return bestName;
	}

	public BestScore() {
	}

	public BestScore(int mapNumber) {
		try {
			Connection connect = new JDBC().buildConnection();
			PreparedStatement statement = connect
					.prepareStatement("SELECT * FROM SNAKE_HIGHSCORES WHERE MAP_NO = " + mapNumber);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				bestScore = rs.getInt("BESTSCORE");
				bestTime = rs.getString("BESTTIME");
				bestName = rs.getString("BESTNAME");
				super.point = bestScore;
				super.time = convertTime(bestTime);
			} else {
				System.out.println("Nincs még tárolt rekord ehhez a pályához!");
			}
			connect.close();
		} catch (Exception e) {
			System.out.println("Elhalás van a BestScore beolvasásnál.");
			System.out.println(e);
		}
	}

	public List<String> getScores() {
		List<String> result = new ArrayList<String>();
		try (Connection connection = new JDBC().buildConnection();
				PreparedStatement statStatement = connection
						.prepareStatement("SELECT * FROM SNAKE.SNAKE_HIGHSCORES order by MAP_NO asc");
				ResultSet rs = statStatement.executeQuery()) {
			while (rs.next()) {
				result.add(Integer.toString(rs.getInt(1)));
				result.add(Integer.toString(rs.getInt(2)));
				result.add(rs.getString(3));
				result.add(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void setBest(int mapNumber, int bestScore, String bestTime, String bestName) {
		if (this.bestScore > 0) {
			try {
				Connection connect = new JDBC().buildConnection();
				PreparedStatement statement = connect.prepareStatement(
						"INSERT INTO SNAKE_HIGHSCORES (MAP_NO, BESTSCORE, BESTTIME, BESTNAME) VALUES (?,?,?,?)");
				statement.setString(1, String.valueOf(mapNumber));
				statement.setString(2, String.valueOf(bestScore));
				statement.setString(3, bestTime);
				statement.setString(4, bestName);
				statement.executeUpdate();
				connect.close();
			} catch (SQLException e) {
				System.out.println("Nem sikerült az új rekord beszúrása!");
				e.printStackTrace();
			}
		} else {
			try {
				Connection connect = new JDBC().buildConnection();
				PreparedStatement statement = connect.prepareStatement(
						"UPDATE SNAKE_HIGHSCORES SET BESTSCORE = ?, BESTTIME = ?, BESTNAME = ? WHERE MAP_NO = ?");
				statement.setString(1, String.valueOf(bestScore));
				statement.setString(2, bestTime);
				statement.setString(3, bestName);
				statement.setString(4, String.valueOf(mapNumber));
				statement.executeUpdate();
				connect.close();
			} catch (SQLException e) {
				System.out.println("Nem sikerült a rekord módosítása!");
				e.printStackTrace();
			}
		}
		this.bestScore = bestScore;
		this.bestTime = bestTime;
		this.bestName = bestName;
	}

	private long convertTime(String bestTime) {
		String[] splittedTime = bestTime.split(":");
		int n = splittedTime.length;
		Long time = 0L;
		for (int i = n - 1; i >= 0; i--) {
			time = time + (long) (Integer.parseInt(splittedTime[i])) * ((int) Math.pow(60, n - 1 - i));
		}
		return time;
	}
}
