import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomFlipMatrix {

	private int n_rows;
	private int n_cols;
	private int maxIndex;
	private Random rand;
	private Map<Integer, Integer> map;

	// n*m 행렬에서, flip 시에 0인 셀을 증가시키고, reset 시 모든 배열을 0으로 만든다.
	// Random() 호출을 최소화 할것.
	// java의 Random.nextInt 를 사용한다.
	// 중요한 점은 한번 나왔던 랜덤 값이 나올 경우인데,
	// 이를 대비하여 현재 나온 랜덤 값을 키, value 를 n*m 의 값을 저장해놓고 감소시킨다.
	// maxIndex 를 계속 감소 시키기 때문에, 다음번에 중복된 랜덤 값이 나온다고 한다면 맵에 저장해놓은 절대 중복되지 않을 인덱스를 이용한다.
	// (Random.nextInt(n) 은 0 <= i < n 의 값을 반환해주므로, 중복된 값이 호출 될시 이번 차례에는 나오지 않을 index 를 반환해주게됨.)
	public RandomFlipMatrix(int n_rows, int n_cols) {
		this.n_rows = n_rows;
		this.n_cols = n_cols;
		this.maxIndex = n_rows * n_cols;
		this.rand = new Random();
		this.map = new HashMap<>();

	}

	public int[] flip() {
		int index = rand.nextInt(maxIndex--);
		int cur = map.getOrDefault(index, index);
		map.put(index, map.getOrDefault(maxIndex, maxIndex));

		int col = cur % (n_cols);
		int row = n_rows == 1 ? 0 : cur / n_cols;

		int[] ans = new int[2];
		ans[0] = row;
		ans[1] = col;

		return ans;
	}

	public void reset() {
		map.clear();
		maxIndex = n_rows * n_cols;
	}
}
