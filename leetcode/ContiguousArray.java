import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	// 배열에서 0, 1 의 갯수가 같은 subarray 중 가장 긴 것을 찾는 문제.
	// 배열을 순회 하며, 1을 만나면 +1, 0을 만나면 -1 을 해준다.
	// 맵에 이 값을 key로, idx 를 밸류로 저장을 해놓는다.
	// 만약 sum 이 맵에 이미 존재한다면, 지금까지 나온 1, 0 의 갯수가 같은 것이다.
	// 그러므로 이전에 저장한 idx 를 현재 idx 에서 빼준 것이 현재 연속된 subarray 길이 이다.
	public int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		int max = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += (nums[i] == 0 ? -1 : 1);

			if (map.containsKey(sum)) {
				max = Math.max(i - map.get(sum), max);
			} else {
				map.put(sum, i);
			}
		}

		return max;
	}
}
