package hu.ak_akademia.snake.control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.ReadBoardFromFile;
import hu.ak_akademia.snake.model.Snake;
import hu.ak_akademia.snake.view.SnakeListener;

public class Controller extends JFrame{

	private static final long serialVersionUID = 1L;
	private final ImageIcon icon = new ImageIcon("resources/snake-icon.png");

	public void start(Board field) {
		JFrame snakeFrame = new JFrame("A&K - Snake");
		snakeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		snakeFrame.setIconImage(icon.getImage());
		snakeFrame.setResizable(false);
		snakeFrame.setSize(1024, 768);
		TextArea screen = new TextArea();
		TextField scoring = new TextField();
		screen.setBackground(new Color(141, 181, 5));
		Snake snake = new Snake(3);
		snakeFrame.setLocationRelativeTo(null);
		SnakeController sc = new SnakeController(snake, field, screen, scoring);
		SnakeListener listener = new SnakeListener(sc);
		snakeFrame.addKeyListener(listener);
		sc.timer.start();
		screen.setFont(new Font("Monospaced", 0, 12));
		snakeFrame.add(scoring,BorderLayout.NORTH);
		snakeFrame.add(screen);
		snakeFrame.setVisible(true);
		snakeFrame.setFocusable(true);
	}
	
	public void startDemo() {
		JFrame snakeFrame = new JFrame("A&K - Snake");
		TextArea screen = new TextArea();
		snakeFrame.setIconImage(icon.getImage());
		snakeFrame.setResizable(false);
		snakeFrame.add(screen);
		snakeFrame.setSize(1024, 768);
		Snake snake = new Snake(3);
		TextField scoring = new TextField();
		snakeFrame.add(scoring,BorderLayout.NORTH);
		new ReadBoardFromFile("resources/demoBoard.txt");
		Board field = new Board(ReadBoardFromFile.getBoard());
		SnakeController sc = new DemoController(snake, field, screen,scoring);
		SnakeListener listener= new SnakeListener(sc);
		snakeFrame.addKeyListener(listener);
		sc.timer.start();
		snakeFrame.setLocationRelativeTo(null);
		snakeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		screen.setFont(new Font("Monospaced", 0, 12));
		snakeFrame.setVisible(true);
		snakeFrame.setFocusable(true);
	}
}
