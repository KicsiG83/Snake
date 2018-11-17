package hu.ak_akademia.snake.gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
	public JPanel createPanel(JButton[] jbuttons) {
		JPanel mainPn = new JPanel();
		mainPn.setBackground(Color.decode("#8cb404"));
		mainPn.setLayout(new GridLayout(0, 1, 30, 1));

		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#8cb404"));
		panel.setLayout(new GridLayout(0, 1, 30, 30));
		add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel(new ImageIcon("resources/pictures/background/gameOver.png"));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#8cb404"));
		panel_1.setLayout(new GridLayout(0, 1, 5, 10));
		add(panel_1, BorderLayout.CENTER);

		lbTime = new JLabel("Teljesített idő: " + player.getTime() + " mp");
		lbTime.setFont(new Font("Ariel", Font.BOLD, 20));
		lbTime.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbTime);

		lbScore = new JLabel("Elért pontszám: " + player.getPoint());
		lbScore.setFont(new Font("Arial", Font.BOLD, 20));
		lbScore.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbScore);
		
		if (checkNewHighscore(player)) {
			lbGetName.setFont(new Font("Arial", Font.BOLD, 20));
			lbGetName.setHorizontalAlignment(SwingConstants.CENTER);
			panel_1.add(lbGetName);
			panel_1.add(playerNameTF);
			panel_1.add(new CreateReturnPanel().createPanel(jbuttons, 0));
		} else {
			panel_1.add(new CreateReturnPanel().createPanel(jbuttons, 1));
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#8cb404"));
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setHgap(280);
		add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#8cb404"));
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setHgap(280);
		add(panel_3, BorderLayout.WEST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.decode("#8cb404"));
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setVgap(50);
		add(panel_4, BorderLayout.SOUTH);

		mainPn.add(panel);
		mainPn.add(panel_1);
		return mainPn;
	}

	@Override
	public JPanel createMainPanel(int row, int column, JButton[] jbuttons) {
		return null;
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
	
}