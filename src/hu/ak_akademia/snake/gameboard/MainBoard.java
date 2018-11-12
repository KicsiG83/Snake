package hu.ak_akademia.snake.gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import hu.ak_akademia.snake.control.Controller;
import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.Player;
import hu.ak_akademia.snake.model.ReadBoardFromFile;

public class MainBoard extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Player player = new Player();
	private JButton btGame = new JButton();
	private JButton btDemo = new JButton();
	private JButton btScores = new JButton();
	private JButton btExit = new JButton();
	private JButton btBoard1 = new JButton();
	private JButton btBoard2 = new JButton();
	private JButton btBoard3 = new JButton();
	private JButton btBoard4 = new JButton();
	private JButton btBoard5 = new JButton();
	private JButton btBoard6 = new JButton();
	private JButton btBoard7 = new JButton();
	private JButton btBoard8 = new JButton();
	private JButton btBoard9 = new JButton();
	private JButton btBoard10 = new JButton();
	private JButton btReturn = new JButton();
	private JPanel mainPanel = new JPanel();
	private JPanel gameSelectMainPanel = new JPanel();

	public MainBoard() {
		player = new Player();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("A&K Snake");
		setSize(1920, 1080);
		this.setBackground(Color.decode("#8cb404"));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setIconImage(new ImageIcon("resources/pictures/background/snake-icon.png").getImage());
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		mainPanel = new MainPanel().createPanel();
		setMainButtons();
		add(mainPanel, BorderLayout.CENTER);
		setVisible(true);
	}

	private void setMainButtons() {
		JPanel temp = (JPanel) mainPanel.getComponent(1);
		btGame = (JButton) temp.getComponent(0);
		btGame.addActionListener(this);
		btDemo = (JButton) temp.getComponent(1);
		btDemo.addActionListener(this);
		btScores = (JButton) temp.getComponent(2);
		btScores.addActionListener(this);
		btExit = (JButton) temp.getComponent(3);
		btExit.addActionListener(this);
	}
	
	private void setGameSelectButtons() {
		JPanel buttonPanel = (JPanel) gameSelectMainPanel.getComponent(1);
		JPanel firstPanel = (JPanel) buttonPanel .getComponent(0);
		JPanel secondPanel = (JPanel) buttonPanel .getComponent(1);
		btBoard1 = (JButton) firstPanel.getComponent(0);
		btBoard1.addActionListener(this);
		btBoard2 = (JButton) firstPanel.getComponent(1);
		btBoard2.addActionListener(this);
		btBoard3 = (JButton) firstPanel.getComponent(2);
		btBoard3.addActionListener(this);
		btBoard4 = (JButton) firstPanel.getComponent(3);
		btBoard4.addActionListener(this);
		btBoard5 = (JButton) firstPanel.getComponent(4);
		btBoard5.addActionListener(this);
		btBoard6 = (JButton) firstPanel.getComponent(5);
		btBoard6.addActionListener(this);
		btBoard7 = (JButton) firstPanel.getComponent(6);
		btBoard7.addActionListener(this);
		btBoard8 = (JButton) firstPanel.getComponent(7);
		btBoard8.addActionListener(this);
		btBoard9 = (JButton) firstPanel.getComponent(8);
		btBoard9.addActionListener(this);
		btBoard10 = (JButton) firstPanel.getComponent(9);
		btBoard10.addActionListener(this);
		btReturn = (JButton) secondPanel.getComponent(0);
		btReturn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btGame)) {
			gameSelectMainPanel = new GameSelectPanel().createPanel();
			setGameSelectButtons();
			jPanelController(mainPanel, gameSelectMainPanel);
		} else if (e.getSource().equals(btDemo)) {
			callController("resources/boards/demoBoard.txt", 0);
		} else if (e.getSource().equals(btScores)) {
			
		} else if (e.getSource().equals(btReturn)) {
			jPanelController(gameSelectMainPanel, new MainPanel().createPanel());
		} else if (e.getSource().equals(btBoard1)) {
			player.setSelectedBoard(1);
			callController("resources/boards/emptyBoard.txt", 1);
		} else if (e.getSource().equals(btBoard2)) {
			player.setSelectedBoard(2);
			callController("resources/boards/testBoard.txt", 1);
		} else if (e.getSource().equals(btBoard3)) {
			player.setSelectedBoard(3);
			callController("resources/boards/testBoard.txt", 1);
		} else if (e.getSource().equals(btBoard4)) {
			player.setSelectedBoard(4);
			callController("resources/boards/emptyBoard.txt", 1);
		} else if (e.getSource().equals(btBoard5)) {
			player.setSelectedBoard(5);
			callController("resources/boards/emptyBoard.txt", 1);
		} else if (e.getSource().equals(btBoard6)) {
			player.setSelectedBoard(6);
			callController("resources/boards/emptyBoard.txt", 1);
		} else if (e.getSource().equals(btBoard7)) {
			player.setSelectedBoard(7);
			callController("resources/boards/testBoard.txt", 1);
		} else if (e.getSource().equals(btBoard8)) {
			player.setSelectedBoard(8);
			callController("resources/boards/testBoard.txt", 1);
		} else if (e.getSource().equals(btBoard9)) {
			player.setSelectedBoard(9);
			callController("resources/boards/emptyBoard.txt", 1);
		} else if (e.getSource().equals(btBoard10)) {
			player.setSelectedBoard(10);
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
		Controller controller = new Controller(player);
		new ReadBoardFromFile(filePath);
		controller.start(new Board(ReadBoardFromFile.getBoard()), index);
	}
	
	public void disposeFrame(){
		setVisible(false);
		dispose();
	}
}