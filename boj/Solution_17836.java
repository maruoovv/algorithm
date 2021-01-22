import java.util.*;

public class Solution_17836 {

    public static void main(String[] args) {


        solution(new int[][]{{2, 5}, {2, 0}, {3, 2}, {4, 2}, {2, 1}});
    }
    public static int solution(int[][] t) {
        int answer = 0;
        // 각 지점이 연결된게 최대 3개
        // 3개 이상일 경우 인접한 노드중 차수가 제일 적은걸 없앰

        int len = t.length;
        int[] nodeLinks = new int[len + 1];

        for (int i = 0; i < len; i++) {
            nodeLinks[t[i][0]]++;
            nodeLinks[t[i][1]]++;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            List<Integer> list = map.getOrDefault(t[i][0], new ArrayList<>());
            list.add(t[i][1]);
            map.put(t[i][0], list);

            List<Integer> list2 = map.getOrDefault(t[i][1], new ArrayList<>());

            list2.add(t[i][0]);
            map.put(t[i][1], list2);
        }

        for (int i = 0; i < len + 1; i++) {
            if (nodeLinks[i] <= 0) continue;

            if (nodeLinks[i] > 3) {
                List<Integer> list = map.get(i);
                // 0 1 3 4 5
                list.sort((a, b) -> nodeLinks[b] - nodeLinks[a]);

                int cnt = nodeLinks[i];
                int idx = 0;
                while(cnt > 3) {
                    int target = list.get(idx);
                    nodeLinks[i]--;
                    nodeLinks[target]--;
                    cnt--;
                    idx++;
                }

                // unlink
            }
        }

        for (int i = 0; i < len + 1; i++) {
            if (nodeLinks[i] > 0) answer++;
        }

        return answer;
    }
}
