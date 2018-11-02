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

public class GameSelectBoard extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private final JButton btBoard1 = new JButton(new ImageIcon("resources/BoardOne.png"));
	private final JButton btBoard2 = new JButton(new ImageIcon("resources/BoardTwo.png"));
	private final JButton btBoard3 = new JButton(new ImageIcon("resources/BoardThree.png"));
	private final JButton btReturn = new JButton(new ImageIcon("resources/return.png"));

	public GameSelectBoard() {
		btBoard1.addActionListener(this);
		btBoard2.addActionListener(this);
		btBoard3.addActionListener(this);
		btReturn.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SNAKE");
		setSize(1024, 768);
		setResizable(false);
		setIconImage(new ImageIcon("resources/snake-icon.png").getImage());
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		add(new JLabel(new ImageIcon("resources/snakeMainPicture.jpg")), BorderLayout.NORTH);
		add(new JLabel(new ImageIcon("resources/menuLittle.jpg")), BorderLayout.WEST);
		add(new JLabel(new ImageIcon("resources/menuLittle.jpg")), BorderLayout.EAST);
		JPanel pn = new JPanel();
		pn.setLayout(new GridLayout(4, 1));
		pn.add(btBoard1);
		pn.add(btBoard2);
		pn.add(btBoard3);
		pn.add(btReturn);
		add(pn);
		add(new JLabel(new ImageIcon("resources/menuSouthPicture.png")), BorderLayout.SOUTH);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Controller controller = new Controller();
		if(e.getSource().equals(btBoard1)) {
			setVisible(false);
			new ReadBoardFromFile("resources/emptyBoard.txt");
			controller.start(new Board(ReadBoardFromFile.getBoard()));
		}else if(e.getSource().equals(btBoard2)) {
			setVisible(false);
			new ReadBoardFromFile("resources/testBoard.txt");
			controller.start(new Board(ReadBoardFromFile.getBoard()));
		}else if(e.getSource().equals(btBoard3)) {
			setVisible(false);
			new ReadBoardFromFile("resources/testBoard.txt");
			controller.start(new Board(ReadBoardFromFile.getBoard()));
		}
		else {
			setVisible(false);
			new MainBoard();
		}
	}
}