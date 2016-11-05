package eg.edu.alexu.csd.ds.maze.cs74.gui;

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
import eg.edu.alexu.csd.ds.maze.cs74.RandomMaze;
import eg.edu.alexu.csd.ds.maze.cs74.Stack_Impelmentation;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Random;

@SuppressWarnings("serial")
public class Solved_random extends JFrame{

	JLabel[][] grid;
	JFrame frame = new JFrame();
	private static RandomMaze maze;
	private Point start = null;
	private Point enter = null;
	private Point exit = null;
	private Point target = null;
	private Dimension dim;
	int x, y;
	

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public Solved_random(boolean algorithm) {

		Random rand = new Random();
		x = rand.nextInt(10 - 6 + 1) + 6;
		y = rand.nextInt(10 - 6 + 1) + 6;
		maze = new RandomMaze();
		String[][] therandom = maze.randomMaze(x, y);

		// show the Original Maze
		Original_Maze original = new Original_Maze(therandom, x, y);
		original.setVisible(true);
		
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLayout(new GridLayout(x, y));
		frame.pack();
		frame.setVisible(true);
		frame.setBounds(100, 100, 550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Solved Maze ^_^");
		frame.setLocation(dim.width / 2 - frame.getWidth() / 2, dim.height / 2 - frame.getHeight() / 2);
		grid = new JLabel[x][y];

		boolean game1[][] = new boolean[x][y];
		for (int k = 0; k < x; k++) {
			for (int m = 0; m < y; m++) {
				if (therandom[k][m] == ".") {
					game1[k][m] = true;
				} else if (therandom[k][m] == "S") {
					game1[k][m] = true;
					start = new Point(k, m);
				} else if (therandom[k][m] == "&") {
					game1[k][m] = true;
					enter = new Point(k, m);
				} else if (therandom[k][m] == "G") {
					game1[k][m] = true;
					exit = new Point(k, m);
				} else if (therandom[k][m] == "E") {
					game1[k][m] = true;
					target = new Point(k, m);
				}
			}
		}

		if (algorithm) {
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
						therandom[step.x][step.y] = num;
						counter++;
					//}
				}
			}	
		} else {
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
					//		&& !(step.x == target.x && step.y == target.y)) {
						String num = Integer.toString(counter);
						therandom[step.x][step.y] = num;
						counter++;
					//}
				}
			}
		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (therandom[i][j] == "S") {
					JLabel a = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					a.setBorder(border);
					Image img1 = new ImageIcon(this.getClass().getResource("/merooo.jpg")).getImage();
					a.setIcon(new ImageIcon(img1));
					frame.add(a);

				} else if (therandom[i][j] == "E") {
					JLabel b = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					b.setBorder(border);
					Image img2 = new ImageIcon(this.getClass().getResource("/princess.jpg")).getImage();
					b.setIcon(new ImageIcon(img2));
					frame.add(b);

				} else if (therandom[i][j] == "#") {
					JLabel c = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					c.setBorder(border);
					c.setBackground(new Color(128, 0, 128));
					c.setOpaque(true);
					frame.add(c);

				} else if (therandom[i][j] == ".") {
					JLabel d = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					d.setBorder(border);
					Image img4 = new ImageIcon(this.getClass().getResource("/heart-purple-3-icon.png")).getImage();
					d.setIcon(new ImageIcon(img4));
					d.setOpaque(true);
					frame.add(d);

				} else if (therandom[i][j] == "&") {
					JLabel e = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					e.setBorder(border);
					Image img5 = new ImageIcon(this.getClass().getResource("/enter.jpg")).getImage();
					e.setIcon(new ImageIcon(img5));
					frame.add(e);

				} else if (therandom[i][j] == "@") {
					JLabel f = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					f.setBorder(border);
					Image img6 = new ImageIcon(this.getClass().getResource("/Scary-Monsters-icon.png")).getImage();
					f.setIcon(new ImageIcon(img6));
					frame.add(f);

				} else if (therandom[i][j] == "G") {
					JLabel g = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					g.setBorder(border);
					Image img7 = new ImageIcon(this.getClass().getResource("/exit.jpg")).getImage();
					g.setIcon(new ImageIcon(img7));
					frame.add(g);

				}else {
					JLabel h = new JLabel(therandom[i][j]);
					Border border = BorderFactory.createLineBorder(Color.getColor(null), 2);
					h.setFont(new Font("Cambria", Font.BOLD, 20));
					h.setBorder(border);
					frame.add(h);
				}
			}
		}
	}
	// *****************************************************************************************************************//
	/*
	 * String[][] read = null; final String fileName =
	 * "E:/eClipse_projeCts/Graph/" + "random.txt"; WriteFile fileWrite = new
	 * WriteFile(fileName); fileWrite.write(therandom, x, y);
	 * 
	 * final String file_name = "E:/eClipse_projeCts/Graph/" + "random.txt";
	 * ReadFile file = new ReadFile(file_name); x = file.deminsionx; y =
	 * file.deminsiony; try { read = file.OpenFile(); } catch (IOException e1) {
	 * // TODO Auto-generated catch block e1.printStackTrace(); }
	 */

}
