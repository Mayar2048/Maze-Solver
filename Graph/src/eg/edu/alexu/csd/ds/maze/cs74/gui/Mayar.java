package eg.edu.alexu.csd.ds.maze.cs74.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;


public class Mayar {

	public JFrame frame;
	private JTextField txtTheMaze;
	private JButton btnExit;
	private Dimension dim;
	private JLabel label2;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mayar window = new Mayar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mayar() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		frame.getContentPane().setBackground(new Color(128, 0, 128));
		frame.getContentPane().setForeground(Color.PINK);
		frame.setPreferredSize(new Dimension(10000, 10000));
		frame.setBounds(100, 100, 550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getWidth() / 2, dim.height / 2 - frame.getHeight() / 2);
		
		JButton btnNewButton = new JButton("Solve Maze\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				first obj = new first();
				obj.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(128, 0, 128));
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(255, 255, 224));
		btnNewButton.setBounds(68, 222, 164, 50);
		frame.getContentPane().add(btnNewButton);
		
		txtTheMaze = new JTextField();
		txtTheMaze.setEditable(false);
		txtTheMaze.setFont(new Font("Broadway", Font.BOLD, 24));
		txtTheMaze.setForeground(new Color(128, 0, 128));
		txtTheMaze.setBackground(new Color(255, 255, 224));
		txtTheMaze.setHorizontalAlignment(SwingConstants.CENTER);
		txtTheMaze.setText("Barbie Maze");
		txtTheMaze.setBounds(48, 112, 209, 75);
		frame.getContentPane().add(txtTheMaze);
		txtTheMaze.setColumns(10);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setForeground(new Color(128, 0, 128));
		btnExit.setFont(new Font("Buxton Sketch", Font.BOLD, 20));
		btnExit.setBackground(new Color(255, 255, 224));
		btnExit.setBounds(85, 300, 130, 50);
		frame.getContentPane().add(btnExit);

		label2 = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		label2.setIcon(new ImageIcon(img5));		
		label2.setBounds(-157, 0, 941, 820);
		frame.getContentPane().add(label2);
	}
}
