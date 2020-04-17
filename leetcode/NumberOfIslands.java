import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	// 섬의 개수를 세는 문제.
	// BFS 를 이용해 해결.
	// O(N^2)
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) return 0;

		int row = grid.length;
		int col = grid[0].length;

		boolean[][] visit = new boolean[row][col];
		int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		int res = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1' && !visit[i][j]) {
					Queue<Point> queue = new LinkedList<>();

					visit[i][j] = true;
					queue.add(new Point(i,j));
					res++;

					while(!queue.isEmpty()) {
						Point cur = queue.poll();
						int curX = cur.x;
						int curY = cur.y;

						for (int d = 0; d < 4; d++) {
							int dx = curX + direction[d][0];
							int dy = curY + direction[d][1];

							if (dx >= 0 && dy >= 0 && dx < row && dy < col && !visit[dx][dy] && grid[dx][dy] == '1') {
								visit[dx][dy] = true;
								queue.add(new Point(dx, dy));
							}

						}

					}

				}
			}
		}

		return res;
	}
}
