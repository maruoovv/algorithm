import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraverseII {
    // List<List<Integer>> input 이 주어지면,
    // 왼쪽 아래 대각선 으로부터 오른쪽 위 대각선 방향으로의 순회 결과를 반환 하는 문제.
    // 각 줄의 길이는 다를 수 있다.
    // 먼저, 해당 방향으로의 순회는
    // 각 인덱스의 합이 0, 1... N*N 이 되는 순서임을 알 수 있다.
    // 0,0 0,1 0,2
    // 1,0 1,1 1,2
    // 2,0 2,1 2,2
    // 순서는 0,0 -> 1,0 -> 0,1 -> 2,0 -> 1,1 -> 0,2 -> 2,1 -> 1,2 -> 2,2
    // 이 순서로 순회를 하기 위해 key = index 의합, value = index의 순회 결과 맵을 만들고 결과 를 저장한다.
    // 순서는 왼쪽 대각선 아래 -> 오른쪽 대각선 위 이므로, 2차원 배열의 맨 아래 행부터 맨 위 행까지 반복하면 된다.
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxKey = 0;

        for (int i = nums.size() - 1; i >= 0; i--) {
            List<Integer> it = nums.get(i);

            for (int j = 0; j < it.size(); j++) {
                int idx = i + j;
                List<Integer> tmp = map.getOrDefault(idx, new ArrayList<>());
                tmp.add(it.get(j));
                map.put(idx, tmp);
                maxKey = maxKey < idx ? idx : maxKey;
            }
        }

        for (int i = 0; i <= maxKey; i++) {
            List<Integer> it = map.get(i);
            result.addAll(it);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
