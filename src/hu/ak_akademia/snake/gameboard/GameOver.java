package hu.ak_akademia.snake.gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GameOver extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField playerNameTF = new JTextField("", 20);
	private JLabel gameOverMessage = new JLabel();
	private JButton btOk = new JButton(new ImageIcon("resources/pictures/buttons/ok.png"));
	private JButton btExit = new JButton(new ImageIcon("resources/pictures/buttons/exit.png"));
	private JButton btReturn = new JButton(new ImageIcon("resources/pictures/buttons/return.png"));
	private JLabel lbGetName = new JLabel("Játékos neve");
	private JLabel lbScore = new JLabel("Elért pontszám: " + 30);

	public GameOver() {
		btOk.addActionListener(this);
		btOk.setBackground(Color.decode("#8cb404"));
		btReturn.addActionListener(this);
		btReturn.setBackground(Color.decode("#8cb404"));
		btExit.addActionListener(this);
		btExit.setBackground(Color.decode("#8cb404"));
		setLayout(new BorderLayout());

		
		/**
		 * TODO
		 * A pontszámot át kell hozni erre az ablakra
		 * Rendezés miatt az oldalt több JPanelre kell osztani
		 */
		JPanel mainPn = new JPanel();
		mainPn.add(createDataPanel(), BorderLayout.CENTER);
		mainPn.add(createGameOverPanel(createGetInputPanel()), BorderLayout.SOUTH);
		add(mainPn);
		gameOverMessage.setAlignmentX(SwingConstants.CENTER);
		setVisible(true);
	}


	private JPanel createDataPanel() {
		JPanel dataPn = new JPanel();
		dataPn.setLayout(new FlowLayout());
		dataPn.add(lbScore);
		return dataPn;
	}

	private JPanel createGameOverPanel(JPanel getInput) {
		JPanel gameOverPn = new JPanel();
		gameOverPn.setBackground(Color.decode("#8cb404"));
		gameOverPn.add(new JLabel(new ImageIcon("resources/pictures/background/gameOver.png")), BorderLayout.NORTH);
		gameOverPn.add(getInput, BorderLayout.CENTER);
		return gameOverPn;
	}

	private JPanel createGetInputPanel() {
		JPanel getInput = new JPanel();
		lbGetName.setFont(new Font("Ariel", 0, 30));
		getInput.setBackground(Color.decode("#8cb404"));
		getInput.setLayout(new GridLayout(5, 1));
		getInput.add(lbGetName);
		getInput.add(playerNameTF);
		getInput.add(btOk);
		getInput.add(btReturn);
		getInput.add(btExit);
		return getInput;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btOk)) {
			setVisible(false);
		} else if (e.getSource().equals(btReturn)) {
			this.setVisible(false);
			new MainBoard();
		} else {
			setVisible(false);
			System.exit(0);
		}
	}
}