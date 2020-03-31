import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
	// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
	// 위 문제와 비슷한 문제.
	// 겹치는 인터벌을 겹치지 않게 하려면 최소 몇개를 지워야 하는지에 대한 문제.
	// y 값 기준으로 정렬하면,
	// y 가 x보다 큰거를 지워줘야함.
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0) return 0;

		Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

		int cnt = 0;
		int y = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (y > intervals[i][0]) {
				cnt++;
				continue;
			}

			y = intervals[i][1];
		}

		return cnt;
	}
}
