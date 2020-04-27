import java.util.ArrayList;
import java.util.List;

public class UniquePathsIII {

    // 시작점이 1, 끝점이 2, 갈수 있는곳은 0, 갈수 없는 곳은 -1 로 주어졌을때,
    // 방문 가능한 모든 곳을 들르면서 시작에서 끝으로 가는 개수를 세는 문제.
    // 방문했던 곳을 기억 해놓고, dfs를 사용하면 풀수 있다.
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int startX = 0;
        int startY = 0;
        int tot = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) tot++;
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        boolean[][] visit = new boolean[n][m];
        List<Integer> ans = new ArrayList<>();
        visit[startX][startY] = true;

        dfs(visit, grid, ans, startX, startY, n, m, tot + 1);
        return ans.size();
    }

    public void dfs(boolean[][] visit, int[][] grid, List<Integer> ans, int x, int y, int n, int m, int tot) {
        if (grid[x][y] == 2) {
            if (tot == 0) {
                ans.add(0);
            }
            return;
        }

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};


        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if (tx < 0 || ty < 0 || tx >= n || ty >= m || grid[tx][ty] == -1 || visit[tx][ty]) continue;

            visit[tx][ty] = true;
            dfs(visit, grid, ans, tx, ty, n, m, tot - 1);
            visit[tx][ty] = false;
        }

    }
}
