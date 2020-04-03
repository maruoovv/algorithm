public class MaximumSubarray {

	// 연속된 부분 배열의 합중 가장 큰 수를 찾는 문제.
	// i 번째 수를 가장 끝으로 하는 가장 큰합을 구한다.
	// i-1 번째가 양수일 경우 그냥 더해주고, 음수일 경우 i 번째 수만 있는것이 최대값이다.
	public int maxSubArray(int[] nums) {
		int len = nums.length;
		int[] sums = new int[len];
		int max = Integer.MIN_VALUE;
		sums[0] = nums[0];

		for (int i = 1; i < len; i++)  {
			if (sums[i - 1] > 0) {
				sums[i] = sums[i-1] + nums[i];
			} else {
				sums[i] = nums[i];
			}
		}

		for (int i = 0; i < len; i++) {
			if (max < sums[i]) max = sums[i];
		}

		return max;
	}
}
