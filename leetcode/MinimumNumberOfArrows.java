import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrows {

	// 풍선들의 좌표가 주어지고, 다 터트리기 위한 최소의 화살 개수를 구하는 문제.
	// interval 을 구하고, 가장 많이 터트릴수 있는 장소를 고름.
	// 2 5
	// 1 3
	// 4 10
	// 이런식으로 주어졌을때, y1 으로 정렬을 하면
	// 1 3
	// 2 5
	// 4 10
	// 으로 정렬이 되고
	// 처음거부터 y1 값을 선택하여 터트린다.
	// 겹치는 구간은 y1 이 x1 보다 작아질 때 까지 한번에 터트릴 수 있다.
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0) return 0;
		Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

		int point = points[0][1];
		int cnt = 1;

		for (int i = 1; i < points.length; i++) {
			if (point >= points[i][0]) continue;

			cnt++;
			point = points[i][1];
		}

		return cnt;
	}
}
