package eg.edu.alexu.csd.ds.maze.cs74.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class second extends JFrame {

	private JPanel contentPane;
	boolean algorithm;
	private Dimension dim;

	/**
	 * Create the frame.
	 */
	public second(final boolean flag) {
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);

		JButton btnDfs = new JButton("DFS");
		btnDfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				algorithm = false;
				if (flag) {
					second.this.dispose();
					Solved_random x = new Solved_random(algorithm);
					x.frame.setVisible(true);

				} else {
					second.this.dispose();
					Solved_scan y = new Solved_scan(algorithm);
					y.setVisible(true);
				}

			}
		});
		btnDfs.setBounds(95, 187, 135, 43);
		btnDfs.setFont(new Font("Buxton Sketch", Font.BOLD, 20));
		btnDfs.setBackground(new Color(255, 255, 224));
		btnDfs.setForeground(new Color(128, 0, 128));
		contentPane.add(btnDfs);

		JButton btnBfs = new JButton("BFS");
		btnBfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				algorithm = true;
				if (flag) {
					second.this.dispose();
					Solved_random x = new Solved_random(algorithm);
					x.frame.setVisible(true);

				} else {
					second.this.dispose();
					Solved_scan y = new Solved_scan(algorithm);
					y.setVisible(true);
				}
			}
		});
		btnBfs.setFont(new Font("Buxton Sketch", Font.BOLD, 20));
		btnBfs.setBackground(new Color(255, 255, 224));
		btnBfs.setForeground(new Color(128, 0, 128));
		btnBfs.setBounds(95, 264, 135, 43);
		contentPane.add(btnBfs);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		label.setIcon(new ImageIcon(img));		
		label.setBounds(-157, 0, 941, 820);
		contentPane.add(label);
	}

}
