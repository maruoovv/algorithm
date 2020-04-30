import java.util.*;

public class FirstUniqueNumber {

    Queue<Integer> queue;
    Map<Integer, Integer> map;

    // 정수 배열이 주어지고, add, showFirstUnique 함수가 주어진다.
    // 첫번째 unique 한 정수를 반환 하는 문제
    // 큐와 맵을 선언해서, 맵에 해당 숫자가 나온 횟수를 저장한다.
    // 해당 숫자가 나온 횟수가 1일 때만, 큐에 넣어준다.
    // 첫번째 unique number 를 찾을 때엔, 큐를 순회 하면서 각 숫자가 나온 횟수가 1인 수를 찾는다.
    public FirstUniqueNumber(int[] nums) {
        queue = new LinkedList<>();
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                queue.add(nums[i]);
            }
        }
    }

    public int showFirstUnique() {
        if (queue.isEmpty()) return -1;
        Iterator iter = queue.iterator();

        while(iter.hasNext()) {
            Integer num = (Integer) iter.next();

            if (map.get(num) == 1) {

                return num;
            }
        }

        return -1;
    }

    public void add(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);

        if (map.get(value) == 1)
            queue.add(value);
    }
}
