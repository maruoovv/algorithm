import java.util.*;

public class SPinGrid {

    // 0, 1 로 주어지는 2차원 배열이 있다.
    // 0은 지나갈수 있는 곳, 1은 지나갈수 없는 곳일때, 최대 k 개 만큼 1을 제거할 수 있다.
    // 배열의 크기가 m * n 이라고 할때, 0,0 에서 시작하여 m-1,n-1 까지 가는 길 중 최소 경로를 구하라.
    // BFS를 이용해서 푸는데, 최대 k개 만큼의 1을 없앨 수 있다는 걸 고려 해야 한다.
    // 3차원 배열을 m*n*k+1 크기로 선언한다.
    // [x][y][k] 는 k 개 만큼의 1을 없애고 방문한 노드 라는 의미이다.
    // 다음 방문할 노드가 1이고, 현재 없앤 1의 갯수가 k 보다 작고 다음 노드의 curK + 1 을 방문하지 않았다면 방문할 수 있다.
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][][] visit = new boolean[m][n][k + 1];

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        Queue<int[]> queue = new LinkedList<>();
        int[] start = {0,0,0,0};
        queue.add(start);
        int ans = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];
            int curK = cur[2];
            int cnt = cur[3];

            if (x == m -1 && y == n - 1) {
                ans = ans > cnt ? cnt : ans;
            }

            for (int i = 0; i < 4; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];

                if (tx < 0 || ty < 0 || tx >= m || ty >= n) continue;

                if (grid[tx][ty] == 1 && curK < k && !visit[tx][ty][curK + 1]) {
                    queue.add(new int[]{tx, ty, curK + 1, cnt + 1});
                    visit[tx][ty][curK + 1] = true;
                } else if (grid[tx][ty] == 0 && !visit[tx][ty][curK]) {
                    queue.add(new int[]{tx, ty, curK, cnt + 1});
                    visit[tx][ty][curK] = true;
                }
            }

        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
