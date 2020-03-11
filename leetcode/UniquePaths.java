public class UniquePaths {
	// 로봇은 오른쪽, 아래쪽으로만 이동 가능하고, 가능한 모든 경로의 수를 구하는 문제
	// i, j 번째 칸으로 갈 수 있는 경우의 수는 왼쪽에서 오는거, 위에서 오는것 뿐이다.
	// i-1,j + i,j-1 이 i,j 칸에 도달 할 수 있는 경우의 수의 합이다.
	public int uniquePaths(int m, int n) {
		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++){
			map[i][0] = 1;
		}

		for (int i = 0; i < m; i++) {
			map[0][i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				map[i][j] = map[i-1][j] + map[i][j-1];
			}
		}

		return map[n-1][m-1];
	}
}
