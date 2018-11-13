package hu.ak_akademia.snake.control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import hu.ak_akademia.snake.gameboard.CreateJPanel;
import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.Player;
import hu.ak_akademia.snake.model.Snake;
import hu.ak_akademia.snake.view.SnakeListener;

public class Controller extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private SnakeController sc;
	Player player = new Player();

	public Controller(Player player) {
		this.player = player;
	}

	public JPanel start(Board field, int index) {
		JPanel pn = new CreateJPanel().createPanel();
		pn.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
		JTextPane screen = new JTextPane();
		TextField scoring = new TextField();
		screen.setBackground(Color.decode("#8cb404"));
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
		screen.add(scoring, BorderLayout.NORTH);
		pn.addKeyListener(new SnakeListener(sc));
		pn.add(screen);
		pn.requestFocus();
		return pn;
	}
}
