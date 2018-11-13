package hu.ak_akademia.snake.main;

import javax.swing.JFrame;

import hu.ak_akademia.snake.gameboard.MainBoard;

public class Main extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		 new MainBoard();
	}
}
