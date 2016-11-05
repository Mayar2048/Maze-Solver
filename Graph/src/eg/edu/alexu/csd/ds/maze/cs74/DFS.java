package eg.edu.alexu.csd.ds.maze.cs74;

import java.awt.Point;

import eg.edu.alexu.csd.ds.maze.IMaze;

import eg.edu.alexu.csd.ds.maze.collect;

public class DFS implements IMaze {

	public int dimx, dimy;
	boolean[][] visited, game;
	Point node, target, enter, exit;

	collect df = new Stack_Impelmentation();
	collect dfs = new Stack_Impelmentation();

	public DFS(Point first, Point end, Point Enter, Point Exit, boolean[][] maze, int x, int y) {
		node = first;
		target = end;
		game = maze;
		dimx = x;
		dimy = y;
		if(Enter != null)
			enter = Enter ;
		
		if(Exit != null)
			exit = Exit;
		visited = new boolean[x][y];
	}

	public collect PrintPath() {
		// TODO Auto-generated method stub

		df.add(node);
		visited[node.x][node.y] = true;

		boolean flag = false;
		while (!df.isEmpty()) {
			Point start = (Point) df.peek();
			

			if (start.x == target.x && start.y == target.y) {
				break;

			} 
			 if ( enter != null && exit != null && start.x == enter.x && start.y == enter.y  && !flag) {

				Point newStart = new Point(exit.x, exit.y);
				df.add(newStart);
				visited[exit.x][exit.y] = true;
				flag = true;
				

			}
			 else if(flag && start.x == enter.x && start.y == enter.y){
				 df.remove();
			   }
			 else{
				if (start.x - 1 >= 0 && game[start.x - 1][start.y]
					&& !visited[start.x - 1][start.y]) {

				Point newStart = new Point(start.x - 1, start.y);
				visited[start.x - 1][start.y] = true;
				df.add(newStart);

			} else if (start.x + 1 < dimx && game[start.x + 1][start.y]
					&& !visited[start.x + 1][start.y]) {

				Point newStart = new Point(start.x + 1, start.y);
				visited[start.x + 1][start.y] = true;
				df.add(newStart);

			} else if (start.y - 1 >= 0 && game[start.x][start.y - 1]
					&& !visited[start.x][start.y - 1]) {

				Point newStart = new Point(start.x, start.y - 1);
				visited[start.x][start.y - 1] = true;
				df.add(newStart);

			} else if (start.y + 1 < dimy && game[start.x][start.y + 1]
					&& !visited[start.x][start.y + 1]) {

				Point newStart = new Point(start.x, start.y + 1);
				visited[start.x][start.y + 1] = true;
				df.add(newStart);

			} else {	
				
				df.remove();			
			}
			}
		}
		while(!df.isEmpty()){
			dfs.add(df.remove());
		}
		return dfs;
	}
}
