import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	// 배열에서 두 수의 합의 target 이 되는 index 를 찾는 문제.
	// n^2 밖에 생각 못했는데.. map 을 써서 n 으로 해결 가능하다.
	public int[] twoSum(int[] nums, int target) {
		int n = nums.length;

		int[] res = new int[2];
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = map.get(target - nums[i]);
				res[1] = i;

				return res;
			}

			map.put(nums[i], i);
		}

		return res;
	}
}
