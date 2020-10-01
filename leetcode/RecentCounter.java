import java.util.*;
public class RecentCounter {
    Queue<Integer> queue;
    static int prev = 3000;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while(!queue.isEmpty()) {
            int top = queue.peek();

            if (top < t - prev) queue.poll();
            else break;
        }

        queue.add(t);

        return queue.size();
    }
}
