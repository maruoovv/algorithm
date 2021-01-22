import java.util.*;

public class Solution_1167 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        sc.nextLine();
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < V; i++) {
            String line = sc.nextLine();
            String[] lines = line.split(" ");

            int node = Integer.valueOf(lines[0]);
            for (int j = 1; j < lines.length - 1; j += 2) {
                int nextNode = Integer.valueOf(lines[j]);
                int cost = Integer.valueOf(lines[j + 1]);

                List<int[]> list = map.getOrDefault(node, new ArrayList<>());
                list.add(new int[]{nextNode, cost});
                map.put(node, list);
            }
        }

        // find most far node from node 1

        int farFromOne = bfs(1, map, V)[0];

        int farCost = bfs(farFromOne, map, V)[1];


        System.out.println(farCost);
        // find most far node from finded value
    }

    public static int[] bfs(int startNode, Map<Integer, List<int[]>> map, int V) {
        Queue<int[]> queue = new LinkedList<>();

        // node번호, 비용
        queue.add(new int[]{startNode, 0});

        boolean[] visit = new boolean[V + 1];
        visit[startNode] = true;
        int farNode = -1;
        int maxCost = -1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            List<int[]> list = map.getOrDefault(current[0], new ArrayList<>());

            for (int i = 0; i < list.size(); i++) {
                int[] next = list.get(i);

                if (!visit[next[0]]) {
                    if (maxCost < current[1] + next[1]) {
                        maxCost = current[1] + next[1];
                        farNode = next[0];
                    }

                    queue.add(new int[]{next[0], current[1] + next[1]});
                }

                visit[next[0]] = true;
            }
        }

        return new int[]{farNode, maxCost};
    }

}
