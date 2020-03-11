public class SpiralMatrix {

	// 소용돌이 사각형 만드는 문제.
	// left -> right, top -> bottom, right -> left, bottom -> top 순으로 채워나간다.
	public int[][] generateMatrix(int n) {
		int[][] ans = new int[n][n];

		int target = (n*n) + 1;
		int num = 1;
		int i = 0,j = 0;
		while(num < target) {
			int x = i;
			int y = j;

			for (; y < n - j; y++) {
				ans[x][y] = num++;
			}

			y--;

			for (x = i + 1; x < n - i; x++) {
				ans[x][y] = num++;
			}

			x--;

			for (y = y - 1; y >= 0 + j; y--) {
				ans[x][y] = num++;
			}

			y++;
			for (x = x - 1; x > 0 + i; x--) {
				ans[x][y] = num++;
			}

			i++;
			j++;

		}

		return ans;
	}

}
