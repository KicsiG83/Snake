package hu.ak_akademia.snake.control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.Player;
import hu.ak_akademia.snake.model.Snake;
import hu.ak_akademia.snake.view.SnakeListener;

public class Controller extends JPanel {

	private static final long serialVersionUID = 1L;
	private final ImageIcon icon = new ImageIcon("resources/snake-icon.png");
	Player player = new Player();

	public Controller(Player player) {
		this.player = player;
	}
	
	public void start(Board field, int index) {
		JFrame snakeFrame = new JFrame("A&K - Snake");
		snakeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		snakeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		snakeFrame.setIconImage(icon.getImage());
		snakeFrame.setResizable(false);
		snakeFrame.setSize(1920, 1080);
		JTextPane screen = new JTextPane();
		TextField scoring = new TextField();
		screen.setBackground(new Color(141, 181, 5));
		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
		screen.setParagraphAttributes(attribs, true);
		Snake snake = new Snake(3);
		snakeFrame.setLocationRelativeTo(null);
		SnakeController sc;
		if (index == 0) {
			sc = new DemoController(snake, field, screen, scoring, player);
		} else {
			sc = new SnakeController(snake, field, screen, scoring, player);
		}
		SnakeListener listener = new SnakeListener(sc);
		snakeFrame.addKeyListener(listener);
		sc.timer.start();
		screen.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		snakeFrame.add(scoring, BorderLayout.NORTH);
		snakeFrame.add(screen);
		snakeFrame.setVisible(true);
		snakeFrame.setFocusable(true);
	}
}
