import java.util.*;

public class CheapestFlightsWithinKStop {

    // node 간의 edge 가 주어지고 각 edge 이동에는 비용이 있다. 최대 k 개의 노드를 경유 할 수 있을 때
    // src -> dst 의 최소 비용을 찾는 문제.
    // src -> dst 로 node, costs, k 를 저장하고 bfs 를 이용하여 탐색한다.
    // 각 노드에선 다음 노드로 가는 조건은 경유할수 있는 지점이 남아있고, 이전에 방문했던 Cost 보다 작을때 이다.
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            int[] cur = flights[i];

            List<int[]> curPaths = map.getOrDefault(cur[0], new ArrayList<>());
            curPaths.add(new int[]{cur[1], cur[2]});
            map.put(cur[0], curPaths);
            // dst, cost
        }

        Queue<int[]> queue = new LinkedList<>();
        // current position, costs, k
        queue.add(new int[]{src, 0, K});

        int[] visitSum = new int[n];
        for (int i = 0; i < n; i++) visitSum[i] = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int costSum = current[1];
            int k = current[2];

            if (k < 0) continue;

            List<int[]> paths = map.getOrDefault(current[0], new ArrayList<>());

            for (int i = 0; i < paths.size(); i++) {
                int next = paths.get(i)[0];
                int nextCost = paths.get(i)[1];

                if (visitSum[next] > nextCost + costSum) {
                    queue.add(new int[]{next, nextCost + costSum, k - 1});
                    visitSum[next] = nextCost + costSum;
                }
            }
        }

        if (visitSum[dst] == Integer.MAX_VALUE) return -1;
        else return visitSum[dst];
    }
}
