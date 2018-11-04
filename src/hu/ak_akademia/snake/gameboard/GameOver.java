package hu.ak_akademia.snake.gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GameOver extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField playerNameTF = new JTextField("", 20);
	private JLabel gameOverMessage = new JLabel();
	private JButton btOk = new JButton(new ImageIcon("resources/ok.png"));
	private JButton btExit = new JButton(new ImageIcon("resources/exit.png"));
	private JButton btReturn = new JButton(new ImageIcon("resources/return.png"));

	public GameOver() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SNAKE");
		setSize(1024, 768);
		setResizable(false);
		setIconImage(new ImageIcon("resources/snake-icon.png").getImage());
		setLocationRelativeTo(null);
		btOk.setBackground(Color.decode("#8cb404"));
		btReturn.setBackground(Color.decode("#8cb404"));
		btExit.setBackground(Color.decode("#8cb404"));
		setLayout(new BorderLayout());
		JPanel pn = new JPanel();
		pn.setBackground(Color.decode("#8cb404"));
		JPanel gameOverPn = new JPanel();
		gameOverPn.setBackground(Color.decode("#8cb404"));
		gameOverPn.add(new JLabel(new ImageIcon("resources/gameOver.png")), BorderLayout.NORTH);
		gameOverPn.add(pn);
		JPanel getInput = new JPanel();
		getInput.setBackground(Color.decode("#8cb404"));
		getInput.setLayout(new GridLayout(5, 1));
		
		/**
		 * TODO
		 * A pontszámot át kell hozni erre az ablakra
		 */
		JLabel lbScore = new JLabel("Elért pontszám: " + 30);
		lbScore.setFont(new Font("Ariel", 0, 30));
		getInput.add(lbScore);
		
		/**
		 * TODO
		 * Rendezés miatt az oldalt több JPanelre kell osztani
		 */
		JLabel lbGetName = new JLabel("Jétékos neve");
		lbGetName.setFont(new Font("Ariel", 0, 30));
		getInput.add(lbGetName);
		getInput.add(playerNameTF);
		getInput.add(btOk);
		getInput.add(btReturn);
		getInput.add(btExit);
		gameOverPn.add(getInput, BorderLayout.CENTER);
		add(gameOverPn);
		gameOverMessage.setAlignmentX(SwingConstants.CENTER);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btOk)) {
			setVisible(false);
		}else if(e.getSource().equals(btReturn)) {
			setVisible(false);
			new MainBoard();
		}else {
			setVisible(false);
			dispose();
		}
	}
}