import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PerfectSquare {
    public  int numSquares(int n) {
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
