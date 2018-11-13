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

public class MainBoard extends JFrame {

	private static final long serialVersionUID = 1L;
	private Player player;
	private final JButton btGame = new Buttons().createButton("resources/pictures/buttons/game.png");
	private final JButton btDemo = new Buttons().createButton("resources/pictures/buttons/demo.png");
	private final JButton btScores = new Buttons().createButton("resources/pictures/buttons/scores.png");
	private final JButton btExit = new Buttons().createButton("resources/pictures/buttons/exit.png");
	private final JButton btBoard1 = new Buttons().createButton("resources/pictures/boards/01.png");
	private final JButton btBoard2 = new Buttons().createButton("resources/pictures/boards/02.png");
	private final JButton btBoard3 = new Buttons().createButton("resources/pictures/boards/03.png");
	private final JButton btBoard4 = new Buttons().createButton("resources/pictures/boards/04.png");
	private final JButton btBoard5 = new Buttons().createButton("resources/pictures/boards/05.png");
	private final JButton btBoard6 = new Buttons().createButton("resources/pictures/boards/06.png");
	private final JButton btBoard7 = new Buttons().createButton("resources/pictures/boards/07.png");
	private final JButton btBoard8 = new Buttons().createButton("resources/pictures/boards/08.png");
	private final JButton btBoard9 = new Buttons().createButton("resources/pictures/boards/09.png");
	private final JButton btBoard10 = new Buttons().createButton("resources/pictures/boards/10.png");
	private final JButton btReturn = new Buttons().createButton("resources/pictures/buttons/return.png");
	private final JButton btScoreReturn = new Buttons().createButton("resources/pictures/buttons/return.png");
	private static JButton btGameOverOk = new Buttons().createButton("resources/pictures/buttons/ok.png");
	private static JButton btGameOverExit = new Buttons().createButton("resources/pictures/buttons/gameOverExit.png");
	private static JButton btGameOverReturn = new Buttons().createButton("resources/pictures/buttons/return.png");
	private final JButton snakeControllerReturn = new Buttons().createButton("resources/pictures/buttons/return.png");
	private final JButton snakeControllerExit = new Buttons().createButton("resources/pictures/buttons/exit.png");
	private final JButton[] mainButtons = { btGame, btDemo, btScores, btExit };
	private final JButton[] boardButtons = { btBoard1, btBoard2, btBoard3, btBoard4, btBoard5, btBoard6, btBoard7,
			btBoard8, btBoard9, btBoard10, btReturn };
	private final JButton[] scoreButton = { btReturn };
	private final static JButton[] gameOverButtons = { btGameOverOk, btGameOverExit, btGameOverReturn };
	private JPanel mainPanel = new JPanel();
	private JPanel scorePanel = new JPanel();
	private JPanel gameSelectMainPanel = new JPanel();
	private JPanel boardPanel = new JPanel();
	private JPanel gameOverPanel = new JPanel();

	public static JButton[] getGameOverButtons() {
		return gameOverButtons;
	}

	public MainBoard() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("A&K Snake");
		setSize(1920, 1080);
		setBackground(Color.decode("#8cb404"));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setIconImage(new ImageIcon("resources/pictures/background/snake-icon.png").getImage());
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setJpanels();
		addActionListenerToButtons();
		add(mainPanel, BorderLayout.CENTER);
		setVisible(true);
	}

	private void addActionListenerToButtons() {
		btGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btGame.getName())) {
					jPanelController(mainPanel, gameSelectMainPanel);
				}
			}
		});
		btDemo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btDemo.getName())) {
					jPanelController(mainPanel, callController("resources/boards/demoBoard.txt", 0));
				}
			}
		});
		btScores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btScores.getName())) {
					jPanelController(mainPanel, scorePanel);
				}
			}
		});
		btExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btExit.getName())) {
					setVisible(false);
					dispose();
				}
			}
		});
		btBoard1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btBoard1.getName())) {
					player = new Player();
					boardPanel = callController("resources/boards/emptyBoard.txt", 1);
					selectedGame(1, 1, gameSelectMainPanel, boardPanel);
				}
			}
		});
		btBoard2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btBoard2.getName())) {
					player = new Player();
					boardPanel = callController("resources/boards/emptyBoard.txt", 1);
					selectedGame(2, 1, gameSelectMainPanel, boardPanel);
				}
			}
		});
		btBoard3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btBoard3.getName())) {
					player = new Player();
					boardPanel = callController("resources/boards/emptyBoard.txt", 1);
					selectedGame(3, 1, gameSelectMainPanel, boardPanel);
				}
			}
		});
		btBoard4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btBoard4.getName())) {
					player = new Player();
					boardPanel = callController("resources/boards/emptyBoard.txt", 1);
					selectedGame(4, 1, gameSelectMainPanel, boardPanel);
				}
			}
		});
		btBoard5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btBoard5.getName())) {
					player = new Player();
					boardPanel = callController("resources/boards/emptyBoard.txt", 1);
					selectedGame(5, 1, gameSelectMainPanel, boardPanel);
				}
			}
		});
		btBoard6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btBoard6.getName())) {
					player = new Player();
					boardPanel = callController("resources/boards/emptyBoard.txt", 1);
					selectedGame(6, 1, gameSelectMainPanel, boardPanel);
				}
			}
		});
		btBoard7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btBoard7.getName())) {
					player = new Player();
					boardPanel = callController("resources/boards/emptyBoard.txt", 1);
					selectedGame(7, 1, gameSelectMainPanel, boardPanel);
				}
			}
		});
		btBoard8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btBoard8.getName())) {
					player = new Player();
					boardPanel = callController("resources/boards/emptyBoard.txt", 1);
					selectedGame(8, 1, gameSelectMainPanel, boardPanel);
				}
			}
		});
		btBoard9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btBoard9.getName())) {
					player = new Player();
					boardPanel = callController("resources/boards/emptyBoard.txt", 1);
					selectedGame(9, 1, gameSelectMainPanel, boardPanel);
				}
			}
		});
		btBoard10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btBoard10.getName())) {
					player = new Player();
					boardPanel = callController("resources/boards/emptyBoard.txt", 1);
					selectedGame(10, 1, gameSelectMainPanel, boardPanel);
				}
			}
		});

		btReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btReturn.getName())) {
					jPanelController(gameSelectMainPanel, mainPanel);
				}
			}
		});
		btScoreReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btScoreReturn.getName())) {
					jPanelController(scorePanel, mainPanel);
					repaint();
				}
			}
		});
		btGameOverReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getName().equals(btGameOverReturn.getName())) {
					jPanelController(gameOverPanel, mainPanel);
				}
			}
		});
	}

	private void setJpanels() {
		mainPanel = new MainPanel().createPanel(mainButtons);
		gameSelectMainPanel = new GameSelectPanel().createPanel(boardButtons);
		scorePanel = new ScoresPanel().createPanel(scoreButton);
	}

	private void jPanelController(JPanel oldPanel, JPanel newPanel) {
		remove(oldPanel);
		add(newPanel);
		repaint();
		setVisible(true);
	}

	private JPanel callController(String filePath, int index) {
		setVisible(false);
		Controller controller = new Controller(player);
		new ReadBoardFromFile(filePath);
		return controller.start(new Board(ReadBoardFromFile.getBoard()), index);
	}

	public void disposeFrame() {
		setVisible(false);
		dispose();
	}

	private void selectedGame(int boardNumber, int gameTypeIndex, JPanel oldPanel, JPanel newPanel) {
		player = new Player();
		player.setSelectedBoard(boardNumber);
		jPanelController(oldPanel, newPanel);
	}

}