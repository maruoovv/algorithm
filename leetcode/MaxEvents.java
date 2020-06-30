import java.util.*;
public class MaxEvents {

    // start, end date 로 이루어진 이벤트들이 주어지고,
    // 한 이벤트는 하루에 하나만 참석 가능하다.
    // 가장 많이 참석 가능한 이벤트의 수를 반환.
    // 먼저 배열을 시작 날짜 순으로 정렬을 하고,
    // 각 이벤트의 종료일자를 키로 하는 minheap 을 만든다.
    // 각 일자별로 순회를 하면서, 이벤트의 시작일자가 현재 일자인 이벤트들을 minheap 에 넣고
    // 현재 날짜에 가능한 이벤트가 있다면 제거를 해준다.
    // 그 후 종료일자가 현재일자와 같거나 작은 이벤트들을 힙에서 제거 해준다.
    public int maxEvents(int[][] events) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Arrays.sort(events, (o1, o2) -> {
            if (o1[0] < o2[0]) return -1;
            else if(o1[0] > o2[0]) return 1;
            else return o1[1] - o2[1];
        });

        int len = events.length;
        int i = 0;
        int ans = 0;

        for(int day = 1; day <= 100000; day++) {
            while(i < len && events[i][0] == day) {
                pq.add(events[i++]);
            }

            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }

            while(!pq.isEmpty() && pq.peek()[1] <= day) {
                pq.poll();
            }

        }

        return ans;
    }
}
