package hu.ak_akademia.snake.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.ak_akademia.snake.control.JDBC;

public class BestScore {

	int bestScore = -1;
	String bestTime;
	String bestName;

	public BestScore(int mapNumber) {
		try {
			Connection connect = new JDBC().buildConnection();
			PreparedStatement statement = connect.prepareStatement("SELECT * FROM SNEAK_HIGHSCORES WHERE MAP_NO = " + mapNumber);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				bestScore = rs.getInt("BESTSCORE");
				bestTime = rs.getString("BESTTIME");
				bestName = rs.getString("BESTNAME");
			} else {
				System.out.println("Nincs m�g t�rolt rekord ehhez a p�ly�hoz!");
			}
			connect.close();
		} catch (Exception e) {
			System.out.println("Elhal�s van a BestScore beolvas�sn�l.");
			System.out.println(e);
		}
	}

	public int getBestScore() {
		return bestScore;
	}

	public String getBestTime() {
		return bestTime;
	}

	public String getBestName() {
		return bestName;
	}

	public void setBest(int mapNumber, int bestScore, String bestTime, String bestName) {
		if (this.bestScore < 0) {
			try {
				Connection connect = new JDBC().buildConnection();
				PreparedStatement statement = connect.prepareStatement("INSERT INTO SNEAK_HIGHSCORES (MAP_NO, BESTSCORE, BESTTIME, BESTNAME) VALUES (?,?,?,?)");
				statement.setString(1, String.valueOf(mapNumber));
				statement.setString(2, String.valueOf(bestScore));
				statement.setString(3, bestTime);
				statement.setString(4, bestName);
				statement.executeUpdate();
				connect.close();
			} catch (SQLException e) {
				//e.printStackTrace();
				System.out.println("Nem siker�lt az �j rekord besz�r�sa!");
			}
		} else {
			try {
				Connection connect = new JDBC().buildConnection();
				PreparedStatement statement = connect.prepareStatement("UPDATE SNEAK_HIGHSCORES SET BESTSCORE = ?, BESTTIME = ?, BESTNAME = ? WHERE MAP_NO = ?");
				statement.setString(1, String.valueOf(bestScore));
				statement.setString(2, bestTime);
				statement.setString(3, bestName);
				statement.setString(4, String.valueOf(mapNumber));
				statement.executeUpdate();
				connect.close();
			} catch (SQLException e) {
				//e.printStackTrace();
				System.out.println("Nem siker�lt a rekord m�dos�t�sa!");
			}
		}
		this.bestScore = bestScore;
		this.bestTime = bestTime;
		this.bestName = bestName;
	}
}