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
	private static JTextField playerNameTF = new JTextField("", 10);
	private JLabel lbGetName = new JLabel("Játékos neve");
	private JLabel lbScore;
	private JLabel lbTime;
	private Player player;

	public GameOverPanel(Player player) {
		this.player = player;
	}

	public static String getPlayerNameTF() {
		return playerNameTF.getText();
	}

	@Override
	public JPanel createPanel(JButton[] buttons) {
		JPanel pn = new CreateJPanel().createPanel();
		pn.setLayout(new BorderLayout());
		pn.add(new JLabel(new ImageIcon("resources/pictures/background/gameOver.png")), BorderLayout.WEST);
		pn.add(createMainPanel(0, 1, buttons), BorderLayout.CENTER);
		return pn;
	}

	@Override
	public JPanel createMainPanel(int row, int column, JButton[] buttons) {
		JPanel dataPn = new CreateJPanel().createPanel();
		dataPn.setLayout(new FlowLayout());
		dataPn.add(createGameOverPanel(createGetInputPanel(buttons)));
		return dataPn;
	}

	private JPanel createGetInputPanel(JButton[] buttons) {
		JPanel getInput = new CreateJPanel().createPanel();
		getInput.setLayout(new GridLayout(0, 1, 5, 5));
		lbGetName.setFont(new Font("Ariel", 0, 20));
		lbScore = new JLabel("Elért pontszám: " + player.getPoint());
		lbScore.setHorizontalAlignment(JLabel.CENTER);
		lbScore.setFont(new Font("Ariel", 0, 20));
		lbTime = new JLabel("Teljesített idő: " + player.getTime() + " mp");
		lbTime.setHorizontalAlignment(JLabel.CENTER);
		lbTime.setFont(new Font("Ariel", 0, 20));
		if (checkNewHighscore(player)) {
			getInput.add(lbScore, BorderLayout.CENTER);
			getInput.add(lbTime, BorderLayout.CENTER);
			lbGetName.setHorizontalAlignment(JLabel.CENTER);
			getInput.add(lbGetName);
			getInput.add(playerNameTF);
			getInput.add(new CreateReturnPanel().createPanel(buttons, 0));
		} else {
			getInput.add(lbScore, BorderLayout.CENTER);
			getInput.add(lbTime, BorderLayout.CENTER);
			getInput.add(new CreateReturnPanel().createPanel(buttons, 1));
		}
		return getInput;
	}

	private boolean checkNewHighscore(Player player) {
		Score playerScore = new Score(player.getPoint(), player.getTime());
		Score highScore = new BestScore(player.getSelectedBoard());
		boolean highscore = false;
		switch (highScore.compareTo(playerScore)) {
		case 1:
			highscore = false;
			break;
		case 0:
			highscore = false;
			break;
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
}