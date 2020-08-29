import java.util.LinkedList;
import java.util.Queue;

public class LongestIncreasingPathInMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;

        if (n == 0) return 0;

        int m = matrix[0].length;

        int[][] map = new int[n][m];

        int ans = 1;
        int dx[] = {0,0,1,-1};
        int dy[] = {-1,1,0,0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});

                map[i][j] = 1;
                while(!queue.isEmpty()) {
                    int[] node = queue.poll();
                    for (int d = 0; d < 4; d++) {
                        int n0 = node[0];
                        int n1 = node[1];
                        int tx = n0 + dx[d];
                        int ty = n1 + dy[d];

                        if (tx < 0 || ty < 0 || tx >= n || ty >= m || (map[tx][ty] != 0 && map[tx][ty] >= map[n0][n1] + 1) || matrix[tx][ty] <= matrix[n0][n1]) continue;

                        map[tx][ty] = map[n0][n1] + 1;
                        ans = Math.max(ans, map[tx][ty]);
                        queue.add(new int[]{tx, ty});
                    }
                }
            }
        }

        return ans;
    }
}
