public class MoveZeros {

	// 배열이 주어 질 때, 원래 순서는 유지하고 0을 맨 뒤로 보내야 하는 문제.
	// 간단하게 0이 아닌 수들을 별도의 인덱스로 처음부터 채워주면, 남은 뒤의 수는 다 0
	public void moveZeroes(int[] nums) {
		int pos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) nums[pos++] = nums[i];
		}

		for (int i = pos; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}
