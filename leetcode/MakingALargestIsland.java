import java.util.*;

public class MakingALargestIsland {

    // 0, 1 로 이루어진 맵이 주어지고, 1로 이루어지는 가장 큰 넓이를 찾는 문제
    // 딱 한 셀만 1로 바꿀 수 있다.
    // 단순하게 BFS 로 풀면서, 한번에 한 셀만 1로 바꾸어서 품.
    // 더 빠른 방법이 있을까..
    public int largestIsland(int[][] grid) {
        int ans = 0;
        int len = grid.length;
        int[] dx = {0,1,-1,0};
        int[] dy = {1,0,0,-1};

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int pre = grid[i][j];
                grid[i][j] = 1;
                boolean[][] visit = new boolean[len][len];


                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                visit[i][j] = true;
                int area = 1;

                while(!queue.isEmpty()) {
                    int[] point = queue.poll();

                    for (int d = 0; d < 4; d++) {
                        int tx = point[0] + dx[d];
                        int ty = point[1] + dy[d];

                        if (tx < 0 || ty < 0 || tx >= len || ty >= len || grid[tx][ty] == 0 || visit[tx][ty]) continue;

                        visit[tx][ty] = true;
                        area++;
                        queue.add(new int[]{tx, ty});
                    }
                }

                ans = Math.max(ans, area);
                grid[i][j] = pre;
            }
        }

        return ans;
    }
}
