package hu.ak_akademia.snake.main;

import hu.ak_akademia.snake.control.Controller;
import hu.ak_akademia.snake.gameboard.MainBoard;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		
		Controller controller = new Controller();
		controller.start();
		
//		new MainBoard();
	}
}
