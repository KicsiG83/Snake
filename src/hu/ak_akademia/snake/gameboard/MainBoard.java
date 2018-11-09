package hu.ak_akademia.snake.gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hu.ak_akademia.snake.control.Controller;
import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.ReadBoardFromFile;

public class MainBoard extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JButton btGame = new JButton(new ImageIcon("resources/pictures/buttons/game.png"));
	private final JButton btDemo = new JButton(new ImageIcon("resources/pictures/buttons/demo.png"));
	private final JButton btScores = new JButton(new ImageIcon("resources/pictures/buttons/scores.png"));
	private final JButton btExit = new JButton(new ImageIcon("resources/pictures/buttons/exit.png"));
	private final JButton btBoard1 = new JButton(new ImageIcon("resources/pictures/boards/01.png"));
	private final JButton btBoard2 = new JButton(new ImageIcon("resources/pictures/boards/02.png"));
	private final JButton btBoard3 = new JButton(new ImageIcon("resources/pictures/boards/03.png"));
	private final JButton btBoard4 = new JButton(new ImageIcon("resources/pictures/boards/04.png"));
	private final JButton btBoard5 = new JButton(new ImageIcon("resources/pictures/boards/05.png"));
	private final JButton btBoard6 = new JButton(new ImageIcon("resources/pictures/boards/06.png"));
	private final JButton btBoard7 = new JButton(new ImageIcon("resources/pictures/boards/07.png"));
	private final JButton btBoard8 = new JButton(new ImageIcon("resources/pictures/boards/08.png"));
	private final JButton btBoard9 = new JButton(new ImageIcon("resources/pictures/boards/09.png"));
	private final JButton btBoard10 = new JButton(new ImageIcon("resources/pictures/boards/10.png"));
	private final JButton btReturn = new JButton(new ImageIcon("resources/pictures/buttons/return.png"));
	private JPanel gameSelectMainPanel = new JPanel();
	private JPanel pn = new JPanel();
	private JPanel gsb = new JPanel();

	public MainBoard() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("A&K Snake");
		setSize(1920, 1080);
		this.setBackground(Color.decode("#8cb404"));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setIconImage(new ImageIcon("resources/pictures/background/snake-icon.png").getImage());
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		add(new JLabel(new ImageIcon("resources/pictures/background/snakeMainPicture.png")), BorderLayout.NORTH);
		add(new JLabel(new ImageIcon("resources/pictures/background/menuLittle.jpg")), BorderLayout.WEST);
		add(new JLabel(new ImageIcon("resources/pictures/background/menuLittle.jpg")), BorderLayout.EAST);
		add(createMainPanel());
		add(new JLabel(new ImageIcon("resources/pictures/background/menuSouthPicture.png")), BorderLayout.SOUTH);
		setVisible(true);
	}

	private JPanel createGameSelectPanel() {
		gameSelectMainPanel.setBackground(Color.decode("#8cb404"));
		btBoard1.addActionListener(this);
		btBoard1.setBackground(Color.decode("#8cb404"));
		btBoard2.addActionListener(this);
		btBoard2.setBackground(Color.decode("#8cb404"));
		btBoard3.addActionListener(this);
		btBoard3.setBackground(Color.decode("#8cb404"));
		btBoard4.addActionListener(this);
		btBoard4.setBackground(Color.decode("#8cb404"));
		btBoard5.addActionListener(this);
		btBoard5.setBackground(Color.decode("#8cb404"));
		btBoard6.addActionListener(this);
		btBoard6.setBackground(Color.decode("#8cb404"));
		btBoard7.addActionListener(this);
		btBoard7.setBackground(Color.decode("#8cb404"));
		btBoard8.addActionListener(this);
		btBoard8.setBackground(Color.decode("#8cb404"));
		btBoard9.addActionListener(this);
		btBoard9.setBackground(Color.decode("#8cb404"));
		btBoard10.addActionListener(this);
		btBoard10.setBackground(Color.decode("#8cb404"));
		btReturn.addActionListener(this);
		gsb.setLayout(new GridLayout(5, 2));
		gsb.add(btBoard1);
		gsb.add(btBoard2);
		gsb.add(btBoard3);
		gsb.add(btBoard4);
		gsb.add(btBoard5);
		gsb.add(btBoard6);
		gsb.add(btBoard7);
		gsb.add(btBoard8);
		gsb.add(btBoard9);
		gsb.add(btBoard10);
		gameSelectMainPanel.add(gsb);
		gameSelectMainPanel.add(createReturnPanel());
		return gameSelectMainPanel;
	}

	private JPanel createReturnPanel() {
		JPanel returnPanel = new JPanel();
		returnPanel.setBackground(Color.decode("#8cb404"));
		btReturn.setBackground(Color.decode("#8cb404"));
		returnPanel.add(btReturn);
		return returnPanel;
	}

	private JPanel createMainPanel() {
		btGame.addActionListener(this);
		btGame.setBackground(Color.decode("#8cb404"));
		btDemo.addActionListener(this);
		btDemo.setBackground(Color.decode("#8cb404"));
		btScores.addActionListener(this);
		btScores.setBackground(Color.decode("#8cb404"));
		btExit.addActionListener(this);
		btExit.setBackground(Color.decode("#8cb404"));
		pn.setLayout(new GridLayout(4, 1));
		pn.add(btGame);
		pn.add(btDemo);
		pn.add(btScores);
		pn.add(btExit);
		return pn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btGame)) {
			jPanelController(pn, createGameSelectPanel());
		} else if (e.getSource().equals(btDemo)) {
			callController("resources/boards/demoBoard.txt", 0);
		} else if (e.getSource().equals(btScores)) {
			
			/**
			 * TODO Össze kell kötni a DB-vel és a megjelenítésre alkalmas frame-et
			 * összeállítani
			 */
		
		} else if (e.getSource().equals(btReturn)) {
			jPanelController(gameSelectMainPanel, createMainPanel());
		} else if (e.getSource().equals(btBoard1)) {
			callController("resources/boards/emptyBoard.txt", 1);
		} else if (e.getSource().equals(btBoard2)) {
			callController("resources/boards/testBoard.txt", 1);
		} else if (e.getSource().equals(btBoard3)) {
			callController("resources/boards/testBoard.txt", 1);
		} else if (e.getSource().equals(btBoard4)) {
			callController("resources/boards/emptyBoard.txt", 1);
		} else if (e.getSource().equals(btBoard5)) {
			callController("resources/boards/emptyBoard.txt", 1);
		} else if (e.getSource().equals(btBoard6)) {
			callController("resources/boards/emptyBoard.txt", 1);
		} else if (e.getSource().equals(btBoard7)) {
			callController("resources/boards/testBoard.txt", 1);
		} else if (e.getSource().equals(btBoard8)) {
			callController("resources/boards/testBoard.txt", 1);
		} else if (e.getSource().equals(btBoard9)) {
			callController("resources/boards/emptyBoard.txt", 1);
		} else if (e.getSource().equals(btBoard10)) {
			callController("resources/boards/emptyBoard.txt", 1);
		} else {
			setVisible(false);
			dispose();
		}
	}

	private void jPanelController(JPanel oldPanel, JPanel newPanel) {
		remove(oldPanel);
		add(newPanel);
		repaint();
		setVisible(true);
	}

	private void callController(String filePath, int index) {
		setVisible(false);
		Controller controller = new Controller();
		new ReadBoardFromFile(filePath);
		controller.start(new Board(ReadBoardFromFile.getBoard()), index);
	}
	
	public void disposeFrame(){
		setVisible(false);
		dispose();
	}
}