package hu.ak_akademia.snake.gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	public JPanel createPanel(JButton[] buttons) {
		player.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		score.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		timer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		playGround.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		scores.setFont(new Font("monospaced", 0, 20));
		JPanel headerPn = new CreateJPanel().createPanel();
		headerPn.setLayout(new GridLayout(1, 4));
		headerPn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		headerPn.add(playGround);
		headerPn.add(score);
		headerPn.add(timer);
		headerPn.add(player);
		JPanel pn = new CreateJPanel().createPanel();
		pn.setLayout(new GridLayout(3, 1));
		pn.add(new JLabel(new ImageIcon("resources/pictures/background/snakeMainPicture.png")), BorderLayout.NORTH);
		pn.add(headerPn);
		pn.add(createMainPanel(10, 4, buttons), BorderLayout.SOUTH);
		return pn;
	}

	@Override
	public JPanel createMainPanel(int row, int column, JButton[] buttons) {
		JPanel bigPn = new CreateJPanel().createPanel();
		JPanel pn = new CreateJPanel().createPanel();
		bigPn.setLayout(new GridLayout(2, 1));
		pn.setLayout(new GridLayout(row, column));
		List<String> scoresList = new ArrayList<>();
		scoresList = new BestScore().getScores();
		Font font = new Font("Arial", 0, 20);
		for(int i = 0; i < scoresList.size(); i++) {
			JLabel temp = new JLabel(scoresList.get(i));
			temp.setHorizontalAlignment(JLabel.CENTER);
			temp.setBackground(Color.decode("#8cb404"));
			temp.setOpaque(true);
			temp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			temp.setFont(font);
			pn.add(temp);
		}
		bigPn.add(pn);
		bigPn.add(buttons[0]);
		return bigPn;
	}
}
