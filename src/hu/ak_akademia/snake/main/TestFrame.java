package hu.ak_akademia.snake.main;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.FlowLayout;

public class TestFrame extends JPanel {

	private JButton btGameOverOk = new Buttons().createButton("resources/pictures/buttons/ok.png");
	private JButton btGameOverExit = new Buttons().createButton("resources/pictures/buttons/gameOverExit.png");
	private JButton btGameOverReturn = new Buttons().createButton("resources/pictures/buttons/return.png");

	public static void main(String[] args) {
		new TestFrame();
	}

	public TestFrame() {

		JFrame frame = new JFrame();
		setBackground(Color.decode("#8cb404"));
		setLayout(new BorderLayout());

		JPanel mainPn = new JPanel();
		mainPn.setBackground(Color.decode("#8cb404"));

		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#8cb404"));
		add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel(new ImageIcon("resources/pictures/background/gameOver.png"));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#8cb404"));
		add(panel_1, BorderLayout.CENTER);
		GridLayout gl_panel_1 = new GridLayout(7, 1);
		gl_panel_1.setHgap(30);
		gl_panel_1.setVgap(50);
		panel_1.setLayout(gl_panel_1);

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
		flowLayout_1.setHgap(250);
		add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#8cb404"));
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setHgap(250);
		add(panel_3, BorderLayout.WEST);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setVgap(150);
		panel_4.setBackground(Color.decode("#8cb404"));
		add(panel_4, BorderLayout.SOUTH);


		btGameOverOk.setBackground(Color.decode("#8cb404"));

		btGameOverReturn.setBackground(Color.decode("#8cb404"));

		btGameOverExit.setBackground(Color.decode("#8cb404"));

		mainPn.add(panel);
		mainPn.add(panel_1);
		mainPn.add(panel_2);
		mainPn.add(panel_3);
		mainPn.add(panel_4);
		
		frame.getContentPane().add(mainPn);
		frame.setVisible(true);
	}

	private static final long serialVersionUID = 1L;

}
