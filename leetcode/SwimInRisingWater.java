import java.util.*;

public class SwimInRisingWater {

    // 수영을 하는데 t 보다 높은덴 갈수 없다.
    // 한번에 무제한으로 이동 가능하다.
    // bfs 문제인데, 한번에 많은 곳을 이동 가능하므로, 다음 이동 가능한 곳이 있는지도 여러개 체크를 해야한다.
    // 그래서 saved 란 큐를 하나 더 선언하고, 다음에 갈수 있는 곳이 있는지 검사를 하며 saved 에 검사한 배열들을 저장해놓는다.
    // 만약 다음에 이동 가능한 곳이 없다면, 큐에 다시 saved 를 넣어주고, 시간을 증가시킨다.
    public int swimInWater(int[][] grid) {
        int N = grid.length;

        int[][] time = new int[N][N];
        boolean[][] visit = new boolean[N][N];

        int t = 0;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> saved = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visit[0][0] = true;

        while(t < N * N && !queue.isEmpty()) {
            int[] current = queue.poll();
            saved.add(current);
            int x = current[0];
            int y = current[1];

            if (grid[x][y] > t) {
                t++;
                while(!saved.isEmpty()) {
                    queue.add(saved.poll());
                }
                continue;
            }

            boolean hasNext = false;

            for (int d = 0; d < 4; d++) {
                int dx = x + dir[d][0];
                int dy = y + dir[d][1];

                if (dx < 0 || dy < 0 || dx >= N || dy >= N) continue;

                if (grid[dx][dy] > t || visit[dx][dy] || (time[dx][dy] != 0 && time[dx][dy] < t)) continue;

                hasNext = true;
                time[dx][dy] = t;
                visit[dx][dy] = true;
                queue.add(new int[]{dx, dy});
            }

            if (!hasNext && queue.isEmpty()) {
                while(!saved.isEmpty()) {
                    queue.add(saved.poll());
                }
                t++;
            }

        }

        return time[N-1][N-1];
    }
}
