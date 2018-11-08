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

import hu.ak_akademia.snake.control.Controller;
import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.ReadBoardFromFile;

public class MainBoard extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JButton btGame = new JButton(new ImageIcon("resources/pictures/game.png"));
	private final JButton btDemo = new JButton(new ImageIcon("resources/pictures/demo.png"));
	private final JButton btScores = new JButton(new ImageIcon("resources/pictures/scores.png"));
	private final JButton btExit = new JButton(new ImageIcon("resources/pictures/exit.png"));
	private final JButton btBoard1 = new JButton(new ImageIcon("resources/pictures/BoardOne.png"));
	private final JButton btBoard2 = new JButton(new ImageIcon("resources/pictures/BoardTwo.png"));
	private final JButton btBoard3 = new JButton(new ImageIcon("resources/pictures/BoardThree.png"));
	private final JButton btReturn = new JButton(new ImageIcon("resources/pictures/return.png"));
	private JPanel pn = new JPanel();
	private JPanel gsb = new JPanel();

	public MainBoard() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("A&K Snake");
		setSize(1024, 770);
		setResizable(false);
		setIconImage(new ImageIcon("resources/pictures/snake-icon.png").getImage());
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		add(new JLabel(new ImageIcon("resources/pictures/snakeMainPicture.jpg")), BorderLayout.NORTH);
		add(new JLabel(new ImageIcon("resources/pictures/menuLittle.jpg")), BorderLayout.WEST);
		add(new JLabel(new ImageIcon("resources/pictures/menuLittle.jpg")), BorderLayout.EAST);
		add(createMainPanel());
		add(new JLabel(new ImageIcon("resources/pictures/menuSouthPicture.png")), BorderLayout.SOUTH);
		setVisible(true);
	}
	
	private JPanel createGameSelectPanel() {
		btBoard1.addActionListener(this);
		btBoard2.addActionListener(this);
		btBoard3.addActionListener(this);
		btReturn.addActionListener(this);
		gsb.setLayout(new GridLayout(4, 1));
		gsb.add(btBoard1);
		gsb.add(btBoard2);
		gsb.add(btBoard3);
		gsb.add(btReturn);
		return gsb;
	}

	private JPanel createMainPanel() {
		btGame.addActionListener(this);
		btDemo.addActionListener(this);
		btScores.addActionListener(this);
		btExit.addActionListener(this);
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
			/**TODO
			 * Össze kell kötni a DB-vel és a megjelenítésre alkalmas frame-et összeállítani
			 */
		} else if (e.getSource().equals(btBoard1)) {
			callController("resources/boards/emptyBoard.txt", 1);
		} else if (e.getSource().equals(btBoard2)) {
			callController("resources/boards/testBoard.txt", 1);
		} else if (e.getSource().equals(btBoard3)) {
			callController("resources/boards/testBoard.txt", 1);
		} else if (e.getSource().equals(btReturn)) {
			jPanelController(gsb, createMainPanel());
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
}