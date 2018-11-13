package hu.ak_akademia.snake.gameboard;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hu.ak_akademia.snake.model.BestScore;
import hu.ak_akademia.snake.model.Player;
import hu.ak_akademia.snake.model.Score;

public class GameOverPanel extends JPanel implements JPanelController {

	private static final long serialVersionUID = 1L;
	private JTextField playerNameTF = new JTextField("", 20);
	private JButton btOk = new Buttons().createButton("resources/pictures/buttons/ok.png");
	private JButton btExit = new Buttons().createButton("resources/pictures/buttons/gameOverExit.png");
	private JButton btReturn = new Buttons().createButton("resources/pictures/buttons/return.png");
	private JLabel lbGetName = new JLabel("Játékos neve");
	private JLabel lbScore;
	private Player player;

	public GameOverPanel(Player player) {
		this.player = player;
	}

	@Override
	public JPanel createPanel() {
		JPanel pn = new CreateJPanel().createPanel();
		pn.setLayout(new BorderLayout(3, 1));
		pn.add(new JLabel(new ImageIcon("resources/pictures/background/gameOver.png")), BorderLayout.NORTH);
		pn.add(createMainPanel(1, 6), BorderLayout.CENTER);
		pn.add(new JLabel(new ImageIcon("resources/pictures/background/menuSouthPicture.png")), BorderLayout.SOUTH);
		return pn;
	}

	@Override
	public JPanel createMainPanel(int row, int column) {
		JPanel dataPn = new CreateJPanel().createPanel();
		dataPn.setLayout(new FlowLayout());
		dataPn.add(createGameOverPanel(createGetInputPanel()));
		return dataPn;
	}

	private boolean checkNewHighscore(Player player) {
		Score playerScore = new Score(player.getPoint(), player.getTime());
		Score highScore = new BestScore(player.getSelectedBoard());
		boolean highscore = false;
		switch (highScore.compareTo(playerScore)) {
		case 1:
			highscore = false;
		case 0:
			highscore = false;
		case -1:
			highscore = true;
		}
		return highscore;
	}

	private JPanel createGameOverPanel(JPanel getInput) {
		JPanel gameOverPn = new CreateJPanel().createPanel();
		gameOverPn.add(getInput, BorderLayout.CENTER);
		return gameOverPn;
	}

	private JPanel createGetInputPanel() {
		JPanel getInput = new CreateJPanel().createPanel();
		lbGetName.setFont(new Font("Ariel", 0, 30));
		lbScore = new JLabel("Elért pontszám: " + player.getPoint());
		lbScore.setHorizontalAlignment(JLabel.CENTER);
		lbScore.setFont(new Font("Ariel", 0, 30));
		getInput.add(lbScore, BorderLayout.CENTER);
		if (checkNewHighscore(player)) {
			getInput.setLayout(new GridLayout(6, 1));
			lbGetName.setHorizontalAlignment(JLabel.CENTER);
			getInput.add(lbGetName);
			getInput.add(playerNameTF);
			getInput.add(btOk);
			getInput.add(btReturn);
			getInput.add(btExit);
		} else {
			getInput.setLayout(new GridLayout(3, 1));
			getInput.add(btReturn);
			getInput.add(btExit);
		}
		return getInput;
	}
}