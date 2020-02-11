import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PerfectSquare {
    /*
        합이 n 이 되는 perfect square 의 최소 갯수를 구하는 문제.
        처음엔 dp로 접근했다가, 규칙을 찾는게 어려워서 BFS 로 품. BFS가 훨씬 심플한듯.
        결국 n 까지 가는 최소 횟수를 구하는 거니, BFS 를 이용해 각 perfect square 의 합이 도달하는 지점의 최솟값을 구함
     */
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i*i <= n; i++) {
            list.add(i*i);
        }

        int len = list.size();

        int[] cnt = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int point = queue.poll();

            for (int i = 0; i < len; i++) {
                int num = list.get(i);

                if (point + num > n) {
                    break;
                }

                if (cnt[point + num] != 0 && cnt[point + num] <= cnt[point] + 1) {
                    continue;
                }

                queue.add(point + num);
                cnt[point + num] = cnt[point] + 1;

            }
        }

        return cnt[n];
    }
}
