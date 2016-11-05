package eg.edu.alexu.csd.ds.maze.cs74;

import java.util.Random;

public class RandomMaze {
	public static String[][] randomMaze( int dx,int dy) {

		Random rn = new Random();
		int x = dx;
		int y = dy;
		int countdot = 0;
		String[][] game = new String[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				game[i][j] = "#";
			}
		}

		int startx = Math.abs(rn.nextInt() % x);
		int starty = Math.abs(rn.nextInt() % y);
		game[startx][starty] = ".";
		int targetx = 0, targety = 0, entx = 0, enty = 0, exitx = 0, exity = 0, monsterx = 0, monstery = 0, connectx = 0, connecty = 0, counter = 0;
		boolean found1 = false, found2 = false, found3 = false, found4 = false, found5 = false;

		while (true) {
			if (!found5) {
				connectx = Math.abs(rn.nextInt() % x);
				connecty = Math.abs(rn.nextInt() % y);
				if (connectx != startx && connecty != starty)

				{
					found5 = true;
					game[connectx][connecty] = ".";
					for (int j = 1; j <= Math.abs(startx - connectx); j++) {
						if (startx > connectx) {
							game[startx - j][starty] = ".";
						} else {
							game[startx + j][starty] = ".";
						}
						countdot++;
					}
					for (int j = 1; j <= Math.abs(starty - connecty); j++) {
						if (starty > connecty) {
							game[connectx][starty - j] = ".";
						} else {
							game[connectx][starty + j] = ".";
						}
						countdot++;
					}
				}
			}
			//******************************************************************************//
			if (!found1 && found5) {
				targetx = Math.abs(rn.nextInt() % x);
				targety = Math.abs(rn.nextInt() % y);

				if ((game[targetx][targety] != ".") && targety != starty
						&& targety != connecty && targetx != connectx
						&& Math.abs(startx - targetx) > 1) {
					found1 = true;
					game[targetx][targety] = ".";
					for (int j = 1; j <= Math.abs(connectx - targetx); j++) {
						if (connectx > targetx) {
							game[connectx - j][connecty] = ".";
						} else {
							game[connectx + j][connecty] = ".";
						}
						countdot++;
					}
					for (int j = 1; j <= Math.abs(connecty - targety); j++) {
						if (connecty > targety) {
							game[targetx][connecty - j] = ".";
						} else {
							game[targetx][connecty + j] = ".";
						}
						countdot++;
					}
				}
			}
			//******************************************************************************//

			if (!found2 && found1 && found5) {
				entx = Math.abs(rn.nextInt() % x);
				enty = Math.abs(rn.nextInt() % y);

				if ((game[entx][enty] != ".") && enty != targety) {
					found2 = true;
					game[entx][enty] = ".";
				}
			}
			//******************************************************************************//

			if (!found3 && found1 && found2 && found5) {
				if (targetx < x - 1)
					exitx = targetx + 1;
				else
					exitx = targetx - 1;
				exity = targety;
				game[exitx][exity] = ".";
				found3 = true;
			}
			//******************************************************************************//

			if (!found4 && found1 && found2 && found3 && found5) {
				monsterx = Math.abs(rn.nextInt() % x);
				monstery = Math.abs(rn.nextInt() % y);

				if ((game[monsterx][monstery] != ".")) {
					found4 = true;
				}
			}
			//******************************************************************************//
			if (found1 && found2 && found3 && found4 && found5) {
				break;
			}
		}
		game[startx][starty] = "S";
		game[targetx][targety] = "E";
		game[entx][enty] = "&";
		game[exitx][exity] = "G";
		game[monsterx][monstery] = "@";

		while (counter != ((x * y) - countdot) / 2) {
			int randomPointx = Math.abs(rn.nextInt() % x);
			int randomPointy = Math.abs(rn.nextInt() % y);
			if (game[randomPointx][randomPointy] == "#") {
				game[randomPointx][randomPointy] = ".";
				counter++;
			}
		}
		return game;
	}
}
