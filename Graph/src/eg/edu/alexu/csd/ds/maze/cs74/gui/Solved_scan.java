package eg.edu.alexu.csd.ds.maze.cs74.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import eg.edu.alexu.csd.ds.maze.IMaze;
import eg.edu.alexu.csd.ds.maze.collect;
import eg.edu.alexu.csd.ds.maze.cs74.BFS;
import eg.edu.alexu.csd.ds.maze.cs74.DFS;
import eg.edu.alexu.csd.ds.maze.cs74.ReadFile;
import eg.edu.alexu.csd.ds.maze.cs74.Stack_Impelmentation;

@SuppressWarnings("serial")
public class Solved_scan extends JFrame {

	JFrame frame = new JFrame();
	JLabel[][] grid;
	String[][] scanned;
	private Point start = null;
	private Point enter = null;
	private Point exit = null;
	private Point target = null;
	private Dimension dim;
	int x, y;

	/**
	 * Create the frame.
	 */
	public Solved_scan(boolean algorithm) {

		final String file_name = "E://Barbie//" +"game.txt";
		ReadFile file = new ReadFile(file_name);
		String[][] scanned = new String[x][y];
		try {
			scanned = file.OpenFile();
			x = file.dimentionx;
			y = file.dimentiony;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Original_Maze original = new Original_Maze(scanned, x, y);
		original.setVisible(true);
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLayout(new GridLayout(x, y));
		this.setVisible(true);
		this.pack();
		this.setBounds(100, 100, 550, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Solved Maze ^_^");
		this.setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);
		grid = new JLabel[x][y];
		
		
		boolean game1[][] = new boolean[x][y];
		for (int k = 0; k < x; k++) {
			for (int m = 0; m < y; m++) {
				if (scanned[k][m].charAt(0) == '.') {
					game1[k][m] = true;
				} else if (scanned[k][m].charAt(0) == 'S') {
					game1[k][m] = true;
					start = new Point(k, m);
				} else if (scanned[k][m].charAt(0) == 'E') {
					game1[k][m] = true;
					target = new Point(k, m);
				} else if (scanned[k][m].charAt(0) == '&') {
					game1[k][m] = true;
					enter = new Point(k, m);
				} else if (scanned[k][m].charAt(0) == 'G') {
					game1[k][m] = true;
					exit = new Point(k, m);
				}
			}
		}		

		if (algorithm) {//bfs
			collect path = new Stack_Impelmentation();
			IMaze solution = new BFS(start, target, enter, exit, game1, x, y);
			path = solution.PrintPath();
			
			if (path.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Maze has no solution !!!");
				System.exit(0);	
			} else {
				int counter = 1;
				while (!path.isEmpty()) {
					Point step = (Point) path.remove();
					//if (!(step.x == start.x && step.y == start.y)
						//	&& !(step.x == target.x && step.y == target.y)) {
						String num = Integer.toString(counter);
						scanned[step.x][step.y] = num;
						counter++;
				//	}
				}
			}	
		} else {//dfs
			collect path = new Stack_Impelmentation();
			IMaze solution = new DFS(start, target, enter, exit, game1, x, y);
			path = solution.PrintPath();

			if (path.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Maze has no solution !!!");
				System.exit(0);
			} else {
				int counter = 1;
				while (!path.isEmpty()) {
					Point step = (Point) path.remove();
					//if (!(step.x == start.x && step.y == start.y)
						//	&& !(step.x == target.x && step.y == target.y)) {
						String num = Integer.toString(counter);
						scanned[step.x][step.y] = num;
						counter++;
					//}
				}
			}
		}
		
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (scanned[i][j].charAt(0) == 'S') {
					JLabel a = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					a.setBorder(border);
					Image img1 = new ImageIcon(this.getClass().getResource("/merooo.jpg")).getImage();
					a.setIcon(new ImageIcon(img1));
					this.add(a);

				} else if (scanned[i][j].charAt(0) == 'E') {
					JLabel b = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					b.setBorder(border);
					Image img2 = new ImageIcon(this.getClass().getResource("/princess.jpg")).getImage();
					b.setIcon(new ImageIcon(img2));
					this.add(b);

				} else if (scanned[i][j].charAt(0) == '#') {
					JLabel c = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					c.setBorder(border);
					c.setBackground(new Color(128, 0, 128));
					c.setOpaque(true);
					this.add(c);

				} else if (scanned[i][j].charAt(0) == '.') {
					JLabel d = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					d.setBorder(border);
					Image img4 = new ImageIcon(this.getClass().getResource("/heart-purple-3-icon.png")).getImage();
					d.setIcon(new ImageIcon(img4));
					d.setOpaque(true);
					this.add(d);

				} else if (scanned[i][j].charAt(0) == '&') {
					JLabel e = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					e.setBorder(border);
					Image img5 = new ImageIcon(this.getClass().getResource("/enter.jpg")).getImage();
					e.setIcon(new ImageIcon(img5));
					this.add(e);

				} else if (scanned[i][j].charAt(0) == '@') {
					JLabel f = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					f.setBorder(border);
					Image img6 = new ImageIcon(this.getClass().getResource("/Scary-Monsters-icon.png")).getImage();
					f.setIcon(new ImageIcon(img6));
					this.add(f);

				} else if (scanned[i][j].charAt(0) == 'G') {
					JLabel g = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					g.setBorder(border);
					Image img7 = new ImageIcon(this.getClass().getResource("/exit.jpg")).getImage();
					g.setIcon(new ImageIcon(img7));
					this.add(g);

				}else {
					JLabel h = new JLabel(scanned[i][j]);
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					h.setBorder(border);
					this.add(h);
				}
			}
		}
	}
}
