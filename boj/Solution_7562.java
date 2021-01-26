import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_7562 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int[][] dir = {{-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};


        while(T > 0) {
            T--;
            int L = sc.nextInt();

            int[][] map = new int[L][L];
            int[] start = new int[2];
            int[] end = new int[2];

            for (int i = 0; i < 2; i++) {
                start[i] = sc.nextInt();
            }

            for (int i = 0; i < 2; i++) {
                end[i] = sc.nextInt();
            }

            if (start[0] == end[0] && start[1] == end[1]) {
                System.out.println(0);
                continue;
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(start);

            while(!queue.isEmpty() && map[end[0]][end[1]] == 0) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                for (int i = 0; i < 8; i++) {
                    int dx = x + dir[i][0];
                    int dy = y + dir[i][1];

                    if (dx < 0 || dy < 0 || dx >= L || dy >= L) continue;

                    if (map[dx][dy] == 0 || map[dx][dy] > map[x][y] + 1) {
                        map[dx][dy] = map[x][y] + 1;
                        queue.add(new int[]{dx, dy});
                    }
                }

            }

            System.out.println(map[end[0]][end[1]]);
        }
    }
}
