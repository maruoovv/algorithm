import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_19238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int F = sc.nextInt();

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int x = sc.nextInt();
        int y = sc.nextInt();

        map[x][y] = 9;
        boolean[] finish = new boolean[M];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, F});


    }
}
