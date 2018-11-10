package hu.ak_akademia.snake.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

	private Connection connection;

	public Connection buildConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "SNAKE";
		String password = "snakePass";
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.err.println("A játék nem tudott csatlakozni az adatbázishoz!");
			System.out.println(e.toString());
		}
		return connection;
	}
}