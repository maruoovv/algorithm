import java.util.*;

public class FloodFill {

    // 배열과 sr, sc, newColor 가 주어진다.
    // (sr,sc) 에서 시작하고 인접한 같은 숫자의 노드를 newColor 로 채우는것.
    // 전형적인 BFS 로 풀수 있는 문제
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int[] start = new int[]{sr, sc};
        queue.add(start);

        int target = image[sr][sc];
        boolean[][] visit = new boolean[m][n];
        image[sr][sc] = newColor;
        visit[sr][sc] = true;

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int tx = cur[0] + dx[i];
                int ty = cur[1] + dy[i];

                if (tx < 0 || ty < 0 || tx >= m || ty >= n || image[tx][ty] != target || visit[tx][ty]) continue;

                image[tx][ty] = newColor;
                visit[tx][ty] = true;
                queue.add(new int[]{tx, ty});
            }
        }

        return image;
    }
}
}
