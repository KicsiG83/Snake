package hu.ak_akademia.snake.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import hu.ak_akademia.snake.gameboard.Buttons;

public class TestFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton btGameOverOk = new Buttons().createButton("resources/pictures/buttons/ok.png");
	private JButton btGameOverExit = new Buttons().createButton("resources/pictures/buttons/gameOverExit.png");
	private JButton btGameOverReturn = new Buttons().createButton("resources/pictures/buttons/gameOverReturn.png");

	public static void main(String[] args) {
		new TestFrame();
	}

	public TestFrame() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("A&K Snake");
		setSize(1920, 1080);
		setBackground(Color.decode("#8cb404"));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setIconImage(new ImageIcon("resources/pictures/background/snake-icon.png").getImage());
		setLocationRelativeTo(null);

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

		JLabel lblNewLabel_1 = new JLabel("Timer");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Scoring");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Player name");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);

		JTextArea textArea = new JTextArea(1, 20);
		textArea.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(textArea);

		panel_1.add(btGameOverOk);

		panel_1.add(btGameOverReturn);

		panel_1.add(btGameOverExit);
		
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


		btGameOverOk.setBackground(Color.decode("#8cb404"));

		btGameOverReturn.setBackground(Color.decode("#8cb404"));

		btGameOverExit.setBackground(Color.decode("#8cb404"));

		mainPn.add(panel);
		mainPn.add(panel_1);
		
		add(mainPn);
		setVisible(true);
	}
}
