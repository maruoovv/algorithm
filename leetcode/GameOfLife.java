public class GameOfLife {
	public void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;

		int[][][] map = new int[m][n][2];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j][0] = board[i][j];
			}
		}
		// map[][][0] : before
		// map[][][1] : next
		// 1 : live, 0 : die

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j][0] == 0) {
					// dead : live == 3 => live
					int liveCnt = getNeighborsCount(map, i, j, 1, m, n);
					if (liveCnt == 3) map[i][j][1] = 1;
				} else {
					// live < 2 => die
					// live == 2 or 3 => live
					// live > 3 => die

					int liveCnt = getNeighborsCount(map, i, j, 1, m, n);
					if (liveCnt == 2 || liveCnt == 3) map[i][j][1] = 1;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = map[i][j][1];
			}
		}
	}

	public int getNeighborsCount(int[][][] map, int x, int y, int val, int m, int n) {
		int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1,1}};
		int cnt = 0;
		for (int i = 0; i < dir.length; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];

			if (dx >= 0 && dy >= 0 && dx < m && dy < n && map[dx][dy][0] == val) {
				cnt++;
			}
		}

		return cnt;
	}
}
