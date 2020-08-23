import java.util.*;

public class RemoveCoveredIntervals {

    // interval 이 주어지면, 다른 인터벌에 의해 커버되는 인터벌을 합친 후의 개수를 반환하는 문제.
    // 1 <= intervals.length <= 1000
    // 0 <= intervals[i][0] < intervals[i][1] <= 10^5
    // 인터벌이 존재하는 최대 구간이 10^5 까지이므로, 단순 O(N) 으로도 풀수 있을거라 생각 했다.
    // 그전에 정렬이 들어가서 O(NlogN) 됐다.
    // 인터벌이 주어졌을떄, 시작구간이 작은거부터 - 시작구간이 같으면 끝구간이 큰 순으로 정렬을 한다.
    // 그리고 현재 합쳐지고 있는 인터벌을 저장하기 위해 deque 를 사용한다.
    // 이후 0~interval max (10^5) 만큼 순회를 하면서
    // 각 지점에서 시작하는 인터벌을 조사한다.
    // 현재의 인터벌의 끝 점이 현재 큐의 맨 앞의 인터벌의 끝 점보다 크다면, 더는 합쳐질수 없다. (시작점asc, 끝점desc 로 정렬을 했으므로)
    // 이 경우에만 큐의 맨 앞에 넣어준다. (이후 나오는건 시작점이 현재보다 크거나 같은 거 밖에 없으므로, 큐의 뒷부분에 있는 것들은 더이상 합쳐질수 없다.)
    /*
        더 깔끔한 풀이

        int len = intervals.length;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] > b[0]) return 1;
            else if (a[0] < b[0]) return -1;
            else return b[1] - a[1];
        });

        int right = 0;
        int count = 0;

        for (int i = 0; i < len; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];

            if (y > right) count++;
            right = Math.max(right, y);
        }

        return count;

        이전 설명과 마찬가지로, 시작점은 볼 필요 없고, 끝 지점만 보면 된다.
        시작점asc 끝점desc 로 정렬을 했으므로, 현재 인터벌이 현재 가장 오른쪽 지점보다 클 경우가 커버가 안되는 경우이므로
        count 를 늘려주고, 가장 오른쪽 지점을 최신화 시켜준다.
     */
    public int removeCoveredIntervals(int[][] intervals) {
        Deque<int[]> queue = new LinkedList<>();

        int len = intervals.length;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] > b[0]) return 1;
            else if (a[0] < b[0]) return -1;
            else return b[1] - a[1];
        });


        int idx = 0;
        for (int i = 0; i <= 100000 && idx < len;) {
            if (intervals[idx][0] <= i) {
                if (queue.isEmpty())
                    queue.add(intervals[idx]);
                else {
                    int[] top = queue.peek();
                    if (top[1] < intervals[idx][1]) {
                        queue.addFirst(intervals[idx]);
                    }
                }
                idx++;
            } else {
                i++;
            }
        }

        return queue.size();
    }
}
