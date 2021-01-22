import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_1477 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int len = N + 2;
        int[] input = new int[len];
        input[0] = 0;
        input[len - 1] = L;
        for (int i = 1; i < len - 1; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < len - 1; i++) {
            int dist = input[i + 1] - input[i];
            priorityQueue.add(new int[]{dist, input[i] , input[i  + 1]});
        }

        while(M > 0 && !priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();

            int mid = (current[1] + current[2]) / 2;

            // 300 500
            // 400 - 300, 300, 400
            // 500 - 400, 400, 500
            int leftDist = mid - current[1];
            int rightDist = current[2] - mid;
            priorityQueue.add(new int[]{leftDist, current[1], mid});
            priorityQueue.add(new int[]{rightDist, mid, current[2]});

            M--;
        }

//        3 3 500
//        0 300 500
        // 0 150 300 500
        // 0 150 300 400 500
        // 150

        // 0 100 200 300 400 500
        // 100

        System.out.println(priorityQueue.poll()[0]);
    }
}
