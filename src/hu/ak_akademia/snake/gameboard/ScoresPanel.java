package hu.ak_akademia.snake.gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hu.ak_akademia.snake.model.BestScore;

public class ScoresPanel extends JPanel implements JPanelController {

	private static final long serialVersionUID = 1L;
	private JLabel scores = new JLabel();
	private final JLabel playGround = new JLabel(new ImageIcon("resources/pictures/background/playGround.png"));
	private final JLabel player = new JLabel(new ImageIcon("resources/pictures/background/player.png"));
	private final JLabel score = new JLabel(new ImageIcon("resources/pictures/background/scores.png"));
	private final JLabel timer = new JLabel(new ImageIcon("resources/pictures/background/timer.png"));
	
	@Override
	public JPanel createPanel() {
		player.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		score.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		timer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		playGround.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		scores.setFont(new Font("monospaced", 0, 20));
		JPanel pn = new JPanel();
		pn.setBackground(Color.decode("#8cb404"));
		pn.add(new JLabel(new ImageIcon("resources/pictures/background/snakeMainPicture.png")), BorderLayout.NORTH);
		pn.add(createMainPanel(1, 4), BorderLayout.CENTER);
		pn.add(new JLabel(new ImageIcon("resources/pictures/background/menuSouthPicture.png")), BorderLayout.SOUTH);
		return pn;
	}

	@Override
	public JPanel createMainPanel(int row, int column) {
		JPanel pn = new JPanel();
		pn.setBackground(Color.decode("#8cb404"));
		pn.setLayout(new GridLayout(row, column));
		pn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		pn.add(playGround);
		pn.add(score);
		pn.add(timer);
		pn.add(player);
		List<String> scoresList = new ArrayList<>();
		scoresList = new BestScore().getScores();
		Font font = new Font("Arial", Font.BOLD, 20);
		for(int i = 0; i < scoresList.size(); i++) {
			String text = scoresList.get(i);
			JLabel temp = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
			temp.setBackground(Color.decode("#8cb404"));
			temp.setOpaque(true);
			temp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			temp.setFont(font);
			pn.add(temp);
		}
		return pn;
	}

}
