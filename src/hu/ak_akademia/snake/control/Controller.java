package hu.ak_akademia.snake.control;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.*;

import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.ReadBoardFromFile;
import hu.ak_akademia.snake.model.Snake;
import hu.ak_akademia.snake.view.SnakeListener;

public class Controller extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final String[] CAREER = { "Pálya 1", "Pálya 2", "Pálya 3", "Pálya 4", "Pálya 5", "Pálya 6" };
	private final ImageIcon icon = new ImageIcon("resources/snake-icon.png");
	private Timer gameTimer = new Timer(0, this);
	private JLabel jlTimer = new JLabel();

	public void start() {
		JFrame snakeFrame = new JFrame("A&K - Snake");
		snakeFrame.setIconImage(icon.getImage());
		snakeFrame.setResizable(false);
		TextArea screen = new TextArea();
		Snake snake = new Snake(3);
		Board field = new Board(ReadBoardFromFile.getBoard());
		SnakeController sc = new SnakeController(snake, field, screen);
		Timer timer = new Timer(100, sc);
		SnakeListener listener = new SnakeListener(sc);
		snakeFrame.addKeyListener(listener);
		jlTimer.setFont(new Font("Monospaced", 0, 12));
		timer.start();
		snakeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		screen.setFont(new Font("Monospaced", 0, 12));
		setLayout(new FlowLayout());
		JPanel pn = new JPanel();
		JPanel innerPn = new JPanel();
		pn.add(innerPn, BorderLayout.WEST);
		gameTimer.start();
		gameTimer.setDelay(1000);
		innerPn.add(jlTimer);
		innerPn.add(new JLabel("Pályák: "));
		innerPn.add(new JComboBox(CAREER));
		innerPn.add(new JButton("Ok"));
		innerPn.add(new JButton("Mégsem"));
		innerPn.add(new JButton("Kilép"));
		snakeFrame.add(pn, BorderLayout.NORTH);
		snakeFrame.add(screen, BorderLayout.CENTER);
		snakeFrame.setSize(1024, 768);
		snakeFrame.setVisible(true);
		snakeFrame.setFocusable(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		jlTimer.setText(DateFormat.getTimeInstance(DateFormat.MEDIUM).format(new Date()));
	}
}
