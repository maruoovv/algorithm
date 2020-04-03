import java.util.HashMap;
import java.util.Map;

public class HappyNumber {

	public boolean isHappy(int n) {
		int cur = n;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(n, n);
		while(true) {

			int tmp = cur;
			int sum = 0;
			int rem = 0;
			while(tmp > 0) {
				rem = tmp % 10;
				sum += rem * rem;
				tmp = tmp / 10;
			}

			cur = sum;

			if (cur == 1) return true;
			if (map.get(cur) != null) return false;
			map.put(cur, cur);
		}
	}

}
