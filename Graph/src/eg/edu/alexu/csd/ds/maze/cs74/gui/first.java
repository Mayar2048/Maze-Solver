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
public class first extends JFrame {
	JFrame x = new JFrame();
	private Dimension dim;
	private JPanel contentPane;
	boolean flag;
	
	/**
	 * Create the frame.
	 */
	public first() {
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);

		JButton btn2 = new JButton("Scan Maze");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag = false;
				first.this.dispose();
				second obj1 = new second(flag);
				obj1.setVisible(true);
			}
		});
		btn2.setForeground(new Color(128, 0, 128));
		btn2.setFont(new Font("Buxton Sketch", Font.BOLD, 20));
		btn2.setBackground(new Color(255, 255, 224));
		btn2.setBounds(70, 256, 164, 51);
		contentPane.add(btn2);

		JButton btn1 = new JButton("Random Maze");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag = true;
				first.this.dispose();
				second obj2 = new second(flag);
				obj2.setVisible(true);
			}
		});
		btn1.setForeground(new Color(128, 0, 128));
		btn1.setFont(new Font("Buxton Sketch", Font.BOLD, 20));
		btn1.setBackground(new Color(255, 255, 224));
		btn1.setBounds(60, 171, 190, 51);
		contentPane.add(btn1);
		
		JLabel label = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		label.setIcon(new ImageIcon(img1));		
		label.setBounds(-157, 0, 941, 820);
		contentPane.add(label);
	}

}
