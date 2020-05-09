import java.util.*;
public class TopKFrequentElements {

    // 정수 배열이 주어지면 빈도수가 높은 순서대로 k 개를 반환 하는 문제
    // O(NlogN) 보다 빨라야 한다.
    // 먼저 배열을 순회하여 각 수의 빈도수를 맵에 저장한다.
    // 그후 maxheap 을 만든다. JAVA 의 priorityQueue 를 이용.
    // maxheap 이므로, K개 만큼 큐에서 꺼내 주면 된다.
    // 시간 복잡도는 맵을 만들 때 O(N), 힙을 만들 때 O(N log K) 이다.
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> pQueue = new PriorityQueue<>((x, y) -> map.get(y) - map.get(x));

        for (int n : map.keySet()) {
            pQueue.add(n);
        }

        int cnt = 0;
        while(cnt < k) {
            ans[cnt++] = pQueue.poll();
        }

        return ans;

    }
}
