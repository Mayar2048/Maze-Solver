package eg.edu.alexu.csd.ds.maze.cs74.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class Original_Maze extends JFrame {

	private Dimension dim;
	/**
	 * Create the frame.
	 */
	public Original_Maze(String[][] therandom, int x, int y) {
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, 550, 550);
		setLayout(new GridLayout(x, y));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Original Maze ^_^");
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);
		

		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (therandom[i][j].charAt(0) == 'S') {
					JLabel a = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					a.setBorder(border);
					Image img1 = new ImageIcon(this.getClass().getResource("/merooo.jpg")).getImage();
					a.setIcon(new ImageIcon(img1));
					add(a);

				} else if (therandom[i][j].charAt(0) == 'E') {// done
					JLabel b = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					b.setBorder(border);
					Image img2 = new ImageIcon(this.getClass().getResource("/princess.jpg")).getImage();
					b.setIcon(new ImageIcon(img2));
					add(b);

				} else if (therandom[i][j].charAt(0) == '#') {// done
					JLabel c = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					c.setBorder(border);
					c.setBackground(new Color(128, 0, 128));
					
					c.setOpaque(true);
					add(c);

				} else if (therandom[i][j].charAt(0) == '.') {// done
					JLabel d = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					d.setBorder(border);
					Image img4 = new ImageIcon(this.getClass().getResource("/heart-purple-3-icon.png")).getImage();
					d.setIcon(new ImageIcon(img4));
					d.setOpaque(true);
					add(d);

				} else if (therandom[i][j].charAt(0) == '&') {// done
					JLabel e = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					e.setBorder(border);
					Image img5 = new ImageIcon(this.getClass().getResource("/enter.jpg")).getImage();
					e.setIcon(new ImageIcon(img5));
					add(e);

				} else if (therandom[i][j].charAt(0) == '@') {// done
					JLabel f = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					f.setBorder(border);
					Image img6 = new ImageIcon(this.getClass().getResource("/Scary-Monsters-icon.png")).getImage();
					f.setIcon(new ImageIcon(img6));
					add(f);

				} else if (therandom[i][j].charAt(0) == 'G') {
					JLabel g = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					g.setBorder(border);
					Image img7 = new ImageIcon(this.getClass().getResource("/exit.jpg")).getImage();
					g.setIcon(new ImageIcon(img7));
					add(g);

				} else {
					JOptionPane.showMessageDialog(null, "Wrong");
				}
			}
		}		
	}
}
