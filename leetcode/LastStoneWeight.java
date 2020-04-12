import java.util.Arrays;

public class LastStoneWeight {

	// 시뮬레이션 문제. O(NlogN * N) ? 좋은 방법은 아닌듯 하다.
	public int lastStoneWeight(int[] stones) {
		if (stones == null) return 0;
		if (stones.length == 1) return stones[0];

		int len = stones.length;
		int totLen = len;

		while(len > 1) {
			Arrays.sort(stones);

			for (int i = 0; i < totLen / 2; i++) {
				int t = stones[totLen - i -1];
				stones[totLen - i -1] = stones[i];
				stones[i] = t;
			}


			if (stones[0] != 0 && stones[0] == stones[1]) {
				len -= 2;
				stones[0] = stones[1] = 0;
			} else if (stones[0] > stones[1]) {
				len -= 1;
				stones[0] = stones[0] - stones[1];
				stones[1] = 0;
			}
		}


		Arrays.sort(stones);
		return stones[totLen - 1];
	}

}
