import java.util.List;

public class MinimumTotal {
	// 삼각형에서 top 부터 bottom 까지 합중 최소값을 찾는 문제.
	// 현재까지의 합의 배열을 만들어 놓고,
	// 이전 결과의 왼쪽위 & 위 중 최소값을 더해 나간다.
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.get(triangle.size() - 1).size();

		int[][] sum = new int[2][n];
		List<Integer> first = triangle.get(0);
		sum[0][0] = first.get(0);

		int index = 0;
		for (int i = 1; i < triangle.size(); i++) {
			List<Integer> cur = triangle.get(i);

			for (int j = 0; j < cur.size(); j++) {
				if (j == 0) {
					sum[i % 2][j] = sum[(i-1) % 2][0] + cur.get(j);
				} else if(j == cur.size() - 1) {
					sum[i % 2][j] = sum[(i-1) % 2][j - 1] + cur.get(j);
				} else {
					int a = sum[(i-1) % 2][j-1];
					int b = sum[(i-1) % 2][j];
					sum[i % 2][j] = (a >= b ? b : a) + cur.get(j);
				}
			}

			index = (index + 1) % 2;
		}

		int min = Integer.MAX_VALUE;

		int i = index;
		for (int j = 0; j < n; j++) {
			if (min > sum[i][j] && sum[i][j] != 0) {
				min = sum[i][j];
			}
		}

		return min;
	}
}
