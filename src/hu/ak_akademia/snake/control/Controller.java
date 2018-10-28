package hu.ak_akademia.snake.control;

import java.awt.*;
import javax.swing.*;

import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.Snake;
import hu.ak_akademia.snake.model.ReadBoardFromFile;
import hu.ak_akademia.snake.view.SnakeListener;

public class Controller {

	public void start() {
		JFrame snakeFrame = new JFrame("A&K - Snake");
		TextArea screen = new TextArea();
		Snake snake = new Snake(3);
		Board field = new Board(ReadBoardFromFile.getBoard());
		SnakeController sc = new SnakeController(snake, field, screen);
		Timer timer = new Timer(100, sc);
		SnakeListener listener= new SnakeListener(sc);
		snakeFrame.addKeyListener(listener);
		
		timer.start();
		snakeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		screen.setFont(new Font("Monospaced", 0, 12));
		snakeFrame.add(screen);
		snakeFrame.setSize(1024, 768);
		snakeFrame.setVisible(true);
		snakeFrame.setFocusable(true);
	}
	
}
