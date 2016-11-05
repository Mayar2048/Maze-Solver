package eg.edu.alexu.csd.ds.maze.cs74;

import java.awt.Point;

import eg.edu.alexu.csd.ds.maze.IMaze;
import eg.edu.alexu.csd.ds.maze.collect;

public class BFS implements IMaze {

	collect queue = new LinkedList_implementation();
	collect path = new Stack_Impelmentation();
	boolean[][] visited, game;
	Point[][] parent;
	Point start, end, enter, exit;
	int dimx, dimy;

	public BFS(Point first, Point target, Point Enter, Point Exit,
			boolean[][] maze, int x, int y) {
		visited = new boolean[x][y];
		parent = new Point[x][y];
		start = first;
		end = target;
		game = maze;
		if(Enter != null)
			enter = Enter ;
		
		if(Exit != null)
			exit = Exit;
		dimx = x;
		dimy = y;
	}

	public collect PrintPath() {
		// TODO Auto-generated method stub

		visited[start.x][start.y] = true;
		queue.add(start);
		while (!queue.isEmpty()) {
			Point begin = new Point((Point) queue.remove());

			if (begin.y == end.y) {
				if (begin.x - 1 == end.x) {
					visited[begin.x - 1][begin.y] = true;
					parent[begin.x - 1][begin.y] = begin;
					break;
				} else if (begin.x + 1 == end.x) {
					visited[begin.x + 1][begin.y] = true;
					parent[begin.x + 1][begin.y] = begin;
					break;
				}
			} else if (begin.x == end.x) {
				if (begin.y - 1 == end.y) {
					visited[begin.x][begin.y - 1] = true;
					parent[begin.x][begin.y - 1] = begin;
					break;
				} else if (begin.y + 1 == end.y) {
					visited[begin.x][begin.y + 1] = true;
					parent[begin.x][begin.y + 1] = begin;
					break;
				}
			}

			if (enter != null && exit != null && begin.x == enter.x && begin.y == enter.y) {
				Point newStart = new Point(exit.x, exit.y);
				visited[exit.x][exit.y] = true;
				queue.add(newStart);
				parent[exit.x][exit.y] = begin;

			} else {

				// left
				if (begin.x - 1 >= 0 && game[begin.x - 1][begin.y]
						&& !visited[begin.x - 1][begin.y]) {

					Point newStart = new Point(begin.x - 1, begin.y);
					visited[begin.x - 1][begin.y] = true;
					queue.add(newStart);
					parent[begin.x - 1][begin.y] = begin;
				}

				// right
				if (begin.x + 1 < dimx && game[begin.x + 1][begin.y]
						&& !visited[begin.x + 1][begin.y]) {

					Point newStart = new Point(begin.x + 1, begin.y);
					visited[begin.x + 1][begin.y] = true;
					queue.add(newStart);
					parent[begin.x + 1][begin.y] = begin;
				}

				// up
				if (begin.y - 1 >= 0 && game[begin.x][begin.y - 1]
						&& !visited[begin.x][begin.y - 1]) {

					Point newStart = new Point(begin.x, begin.y - 1);
					visited[begin.x][begin.y - 1] = true;
					queue.add(newStart);
					parent[begin.x][begin.y - 1] = begin;
				}

				// down
				if (begin.y + 1 < dimy && game[begin.x][begin.y + 1]
						&& !visited[begin.x][begin.y + 1]) {

					Point newStart = new Point(begin.x, begin.y + 1);
					visited[begin.x][begin.y + 1] = true;
					queue.add(newStart);
					parent[begin.x][begin.y + 1] = begin;
				}
			}
		}

		if (!visited[end.x][end.y]) {
			return path;
		} else {
			int m = end.x;
			int n = end.y;
			Point p = new Point(m, n);
			path.add(p);
			while (p.x != start.x || p.y != start.y) {
				m = parent[p.x][p.y].x;
				n = parent[p.x][p.y].y;
				p = new Point(m, n);
				path.add(p);
			}
		}
		return path;
	}
}

/*
 * 
 * Point printable = new Point(); while(!path.isEmpty()){ printable = (Point)
 * path.remove(); System.out.println(printable.x + " - " + printable.y); } } }
 */

