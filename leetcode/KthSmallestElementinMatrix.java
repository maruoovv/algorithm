import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthSmallestElementinMatrix {

	public int kthSmallest(int[][] matrix, int k) {
		// N^2 이긴한데.. 다른 방법은 이해가 잘 안된다.
		List<Integer> numbers = new ArrayList<>();

		int len = matrix.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++)
				numbers.add(matrix[i][j]);
		}

		Collections.sort(numbers);

		return numbers.get(k - 1);

	}
}
