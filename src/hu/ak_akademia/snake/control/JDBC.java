package hu.ak_akademia.snake.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

	private Connection connection;

	public Connection buildConnection() {
		try {
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:admin/admin@localhost:1521:xe");
		} catch (SQLException e) {
			System.err.println("A j�t�k nem tudott csatlakozni az adatb�zishoz!");
			//System.out.println(e.toString());
		}

		return connection;

	}
}