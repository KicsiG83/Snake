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
		Snake snake = new Snake(3);
		snakeFrame.setLocationRelativeTo(null);
		
		SnakeController sc = new SnakeController(snake, field, screen);
		Timer timer = new Timer(100, sc);
		SnakeListener listener = new SnakeListener(sc);
		snakeFrame.addKeyListener(listener);
		timer.start();
		snakeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		screen.setFont(new Font("Monospaced", 0, 12));
		setLayout(new FlowLayout());
		JPanel pn = new JPanel();
		JPanel innerPn = new JPanel();
		pn.add(innerPn, BorderLayout.WEST);
		snakeFrame.add(pn, BorderLayout.NORTH);
		snakeFrame.add(screen, BorderLayout.CENTER);
		snakeFrame.setFocusable(true);
		snakeFrame.setVisible(true);
	}
}
