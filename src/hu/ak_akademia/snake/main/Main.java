package hu.ak_akademia.snake.main;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import hu.ak_akademia.snake.gameboard.GameOverPanel;
import hu.ak_akademia.snake.model.Player;

public class Main extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
//		 new MainBoard();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("A&K Snake");
		setSize(1920, 1080);
		this.setBackground(Color.decode("#8cb404"));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setIconImage(new ImageIcon("resources/pictures/background/snake-icon.png").getImage());
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		JPanel pn = new JPanel();
		pn.setBackground(Color.decode("#8cb404"));
		Player player = new Player();
		pn = new GameOverPanel(player).createPanel();
//		pn = new ScoresPanel().createPanel();
		add(pn);
		setVisible(true);
	}
}
