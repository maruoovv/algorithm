import java.util.HashSet;
import java.util.Set;

public class CountElements {
	// 배열내에 arr[i] + 1 이 존재하는 원소의 갯수를 구하는 문제.
	// 배열을 순회하여 set 에 저장을 해놓고 구한다.
	public int countElements(int[] arr) {
		Set<Integer> set = new HashSet<>();
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			set.add(arr[i]);
		}

		int cnt = 0;
		for (int i = 0; i < len; i++) {
			if (set.contains(arr[i] + 1)) {
				cnt++;
			}
		}

		return cnt;
	}
}
