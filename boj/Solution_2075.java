import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_2075 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cur = sc.nextInt();

                queue.add(cur);
                if (queue.size() > N) {
                    queue.poll();
                }
            }
        }

        System.out.println(queue.poll());
    }
}
