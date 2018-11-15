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
	private final JButton btReturn = new Buttons().createButton("resources/pictures/buttons/return.png");
	private final JButton btScoreReturn = new Buttons().createButton("resources/pictures/buttons/return.png");
	private static JButton btGameOverOk = new Buttons().createButton("resources/pictures/buttons/ok.png");
	private static JButton btGameOverExit = new Buttons().createButton("resources/pictures/buttons/gameOverExit.png");
	private static JButton btGameOverReturn = new Buttons().createButton("resources/pictures/buttons/return.png");
	private static JButton snakeControllerReturn = new Buttons().createButton("resources/pictures/buttons/return.png");
	private static JButton snakeControllerExit = new Buttons().createButton("resources/pictures/buttons/exit.png");
	private final JButton[] mainButtons = { btGame, btDemo, btScores, btExit };
	private final JButton[] boardButtons = { btBoard1, btBoard2, btBoard3, btBoard4, btBoard5, btReturn };
	private final JButton[] scoreButton = { btScoreReturn };
	public final static JButton[] gameOverButtons = { btGameOverOk, btGameOverExit, btGameOverReturn };
	public final static JButton[] snakeControllerButtons = { };
	/**TODO
	 * a demo controllert el kel különíteni a snake-től
	 */
	public final static JButton[] demoControllerButtons = { snakeControllerReturn };
	private JPanel mainPanel = new JPanel();
	private JPanel scorePanel = new JPanel();
	private JPanel gameSelectMainPanel = new JPanel();
	private JPanel boardPanel = new JPanel();
	private JPanel gameOverPanel = new JPanel();

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

	private void addActionListenerToButtons() {
		btGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jPanelController(mainPanel, gameSelectMainPanel);
			}
		});
		btDemo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player = new Player(0);
				jPanelController(mainPanel, callController("resources/boards/demoBoard.txt", 0));
			}
		});
		btScores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jPanelController(mainPanel, scorePanel);
			}
		});
		btExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		btBoard1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player = new Player(1);
				boardPanel = callController("resources/boards/emptyBoard.txt", 1);
				jPanelController(gameSelectMainPanel, boardPanel);
			}
		});
		btBoard2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player = new Player(2);
				boardPanel = callController("resources/boards/emptyBoard.txt", 1);
				jPanelController( gameSelectMainPanel, boardPanel);
			}
		});
		btBoard3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player = new Player(3);
				boardPanel = callController("resources/boards/emptyBoard.txt", 1);
				jPanelController( gameSelectMainPanel, boardPanel);
			}
		});
		btBoard4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player = new Player(4);
				boardPanel = callController("resources/boards/emptyBoard.txt", 1);
				jPanelController( gameSelectMainPanel, boardPanel);
			}
		});
		btBoard5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player = new Player(5);
				boardPanel = callController("resources/boards/emptyBoard.txt", 1);
				jPanelController( gameSelectMainPanel, boardPanel);
			}
		});
		btReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jPanelController(gameSelectMainPanel, mainPanel);
			}
		});
		btScoreReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jPanelController(scorePanel, mainPanel);
				repaint();
			}
		});
		btGameOverReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jPanelController(gameOverPanel, mainPanel);
			}
		});
		snakeControllerReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jPanelController(boardPanel, mainPanel);
			}
		});
		snakeControllerExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
	}
}