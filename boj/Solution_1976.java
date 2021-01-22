import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_1976 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int[] path = new int[M];
        for (int i = 0; i < M; i++) {
            path[i] = sc.nextInt();
        }

        int[] dist = new int[N];

        for (int i = 0; i < N; i++) dist[i] = i + 1;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a , b) -> b - a);

        boolean[] visit = new boolean[N];



        for (int i = 0; i < N; i++) priorityQueue.add(i);
        // pq = [2,1]
        // dist = [3,3,3]

        //        0 1 0
        //        1 0 1
        //        0 1 0

        while(!priorityQueue.isEmpty()) {
            int cur = priorityQueue.poll();
            visit[cur] = true;
            for (int i = 0; i < N; i++) {
                if (map[cur][i] == 1 && (dist[cur] != cur || !visit[i])) {
                    priorityQueue.add(i);
                    dist[i] = dist[cur];
                    visit[i] = true;
                }
            }
        }


        //        4
        //        3
        //        0 1 0 0
        //        1 0 1 1
        //        0 1 0 0
        //        0 0 1 0
        //        1 3
        // dist = [1,2,3,4]
        for (int i = 0; i < M - 1; i++) {
            if (dist[path[i] - 1] != dist[path[i + 1] - 1]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
