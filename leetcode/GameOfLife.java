public class GameOfLife {
	public void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) board[i][j] = 2;

				board[i][j] *= 10;
			}
		}

		// 2 : die, 1 : live
		// [i][j] / 10 : cur, [i][j] % 10 : next;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] / 10 == 2) {
					// dead
					int liveCnt = getNeighborsCount(board, i, j, 1, m, n);
					if (liveCnt == 3) board[i][j] += 1;
				} else {
					// live < 2 => die
					// live == 2 or 3 => live
					// live > 3 => die

					int liveCnt = getNeighborsCount(board, i, j, 1, m, n);
					if (liveCnt == 2 || liveCnt == 3) board[i][j] += 1;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = board[i][j] % 10;
			}
		}
	}

	public int getNeighborsCount(int[][] map, int x, int y, int val, int m, int n) {
		int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1,1}};
		int cnt = 0;
		for (int i = 0; i < dir.length; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];

			if (dx >= 0 && dy >= 0 && dx < m && dy < n && map[dx][dy] / 10 == val) {
				cnt++;
			}
		}

		return cnt;
	}
}
