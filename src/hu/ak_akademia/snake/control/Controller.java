package hu.ak_akademia.snake.control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

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
		setLayout(new BorderLayout());
		JTextPane screen = new JTextPane();
		JLabel scoring = new JLabel();
		scoring.setBackground(Color.decode("#8cb404"));
		scoring.setHorizontalAlignment(JLabel.CENTER);
		screen.setBackground(Color.decode("#8cb404"));
		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
		screen.setParagraphAttributes(attribs, true);
		Snake snake = new Snake(3);
		if (index == 0) {
			sc = new DemoController(snake, field, screen, scoring, player);
			add(MainBoard.demoControllerButtons[0], BorderLayout.SOUTH);
		} else {
			sc = new SnakeController(snake, field, screen, scoring, player);
		}
		sc.timer.start();
		screen.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		screen.addKeyListener(new SnakeListener(sc));
		add(scoring, BorderLayout.NORTH);
		add(screen);
		MainBoard.setBoardPanel(this);
		MainBoard.setGameOverPanel(this);
		return this;
	}
}
