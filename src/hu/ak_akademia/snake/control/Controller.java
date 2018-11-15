package hu.ak_akademia.snake.control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import hu.ak_akademia.snake.gameboard.CreateJPanel;
import hu.ak_akademia.snake.gameboard.MainBoard;
import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.Player;
import hu.ak_akademia.snake.model.Snake;
import hu.ak_akademia.snake.view.SnakeListener;

public class Controller extends JPanel {

	private static final long serialVersionUID = 1L;

	private int selectedBoardIndex;
	private SnakeController sc;
	Player player = new Player(selectedBoardIndex);

	public Controller(Player player) {
		this.player = player;
		selectedBoardIndex = player.getSelectedBoard();
	}

	public JPanel start(Board field, int index) {
		JPanel mainPn = new CreateJPanel().createPanel();
		mainPn.setLayout(new GridLayout());
		JPanel northPn = new CreateJPanel().createPanel();
		northPn.setLayout(new GridLayout(1, 1));
		JPanel southPn = new CreateJPanel().createPanel();
		southPn.setLayout(new GridLayout(1, 1));
		JTextPane screen = new JTextPane();
		JLabel scoring = new JLabel();
		scoring.setHorizontalAlignment(JLabel.CENTER);
		screen.setBackground(Color.decode("#8cb404"));
		screen.add(scoring, BorderLayout.NORTH);
		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
		screen.setParagraphAttributes(attribs, true);
		Snake snake = new Snake(3);
		if (index == 0) {
			sc = new DemoController(snake, field, screen, scoring, player);
		} else {
			sc = new SnakeController(snake, field, screen, scoring, player);
		}
		sc.timer.start();
		screen.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		screen.addKeyListener(new SnakeListener(sc));
//		northPn.add(scoring, BorderLayout.CENTER);
		southPn.add(screen);
//		mainPn.add(northPn);
		mainPn.add(southPn);
		JPanel buttonPn = new CreateJPanel().createPanel();
		for (int i = 0; i < MainBoard.snakeControllerButtons.length; i++) {
			buttonPn.add(MainBoard.snakeControllerButtons[i]);
		}
		screen.add(buttonPn, BorderLayout.SOUTH);
		return mainPn;
	}
}
