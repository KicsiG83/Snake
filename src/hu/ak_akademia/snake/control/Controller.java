package hu.ak_akademia.snake.control;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.Snake;
import hu.ak_akademia.snake.view.SnakeListener;

public class Controller extends JFrame{

	private static final long serialVersionUID = 1L;
	private final ImageIcon icon = new ImageIcon("resources/snake-icon.png");

	public void start(Board field) {
		JFrame snakeFrame = new JFrame("A&K - Snake");
		snakeFrame.setIconImage(icon.getImage());
		snakeFrame.setResizable(false);
		snakeFrame.setSize(1024, 768);
		TextArea screen = new TextArea();
		TextField scoring = new TextField();
		Snake snake = new Snake(3);
		snakeFrame.setLocationRelativeTo(null);
		
		Timer timer = new Timer(100, sc);
		SnakeListener listener = new SnakeListener(sc);
		SnakeController sc = new SnakeController(snake, field, screen, scoring);
		snakeFrame.addKeyListener(listener);
		sc.timer.start();
		snakeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		screen.setFont(new Font("Monospaced", 0, 12));
		snakeFrame.add(scoring,BorderLayout.NORTH);
		snakeFrame.add(screen);
		snakeFrame.setSize(1024, 768);
		snakeFrame.setVisible(true);
	}
	
	public void startDemo() {
		JFrame snakeFrame = new JFrame("A&K - Snake");
		TextArea screen = new TextArea();
		Snake snake = new Snake(3);
		TextField scoring = new TextField();
		Board field = new Board(new ReadBoardFromFile("resources\\demoBoard.txt").getBoard());
		SnakeController sc = new DemoController(snake, field, screen,scoring);
		SnakeListener listener= new SnakeListener(sc);
		snakeFrame.addKeyListener(listener);
		
		sc.timer.start();
		snakeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		screen.setFont(new Font("Monospaced", 0, 12));
		snakeFrame.add(screen);
		snakeFrame.add(scoring,BorderLayout.NORTH);
		snakeFrame.setSize(1024, 768);
		snakeFrame.setVisible(true);
		snakeFrame.setFocusable(true);
		
		
	}
	
}
