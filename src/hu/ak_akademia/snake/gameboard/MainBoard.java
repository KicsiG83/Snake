package hu.ak_akademia.snake.gameboard;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainBoard extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JButton btGame = new JButton(new ImageIcon("resources/game.png"));
	private final JButton btDemo = new JButton(new ImageIcon("resources/demo.png"));
	private final JButton btScores = new JButton(new ImageIcon("resources/scores.png"));
	private final JButton btExit = new JButton(new ImageIcon("resources/exit.png"));

	public MainBoard() {
		btGame.addActionListener(this);
		btDemo.addActionListener(this);
		btScores.addActionListener(this);
		btExit.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SNAKE");
		setSize(1024, 770);
		setResizable(false);
		setIconImage(new ImageIcon("resources/snake-icon.png").getImage());
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		add(new JLabel(new ImageIcon("resources/snakeMainPicture.jpg")), BorderLayout.NORTH);
		add(new JLabel(new ImageIcon("resources/menuLittle.jpg")), BorderLayout.WEST);
		add(new JLabel(new ImageIcon("resources/menuLittle.jpg")), BorderLayout.EAST);
		JPanel pn = new JPanel();
		pn.setLayout(new GridLayout(4, 1));
		pn.add(btGame);
		pn.add(btDemo);
		pn.add(btScores);
		pn.add(btExit);
		add(pn);
		add(new JLabel(new ImageIcon("resources/menuSouthPicture.png")), BorderLayout.SOUTH);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btGame)) {
			setVisible(false);
			new GameSelectBoard();
		}else if(e.getSource().equals(btDemo)) {
			
		}else if(e.getSource().equals(btScores)) {

		}
		else {
			setVisible(false);
			dispose(); 
		}
	}
}