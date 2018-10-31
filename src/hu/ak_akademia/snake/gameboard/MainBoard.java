package hu.ak_akademia.snake.gameboard;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class MainBoard extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Timer gameTimer = new Timer(0, this);
	private JLabel jlTimer = new JLabel();

	public MainBoard() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Teszt ablak");
		setSize(1024, 768);
		setResizable(false);
		jlTimer.setHorizontalAlignment(SwingConstants.LEFT);
		jlTimer.setFont(new Font("Arial", Font.BOLD, 12));
		add(jlTimer);
		setVisible(true);
		gameTimer.start();
		gameTimer.setDelay(1000);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		jlTimer.setText(DateFormat.getTimeInstance(DateFormat.MEDIUM).format(new Date()));
	}
}