public class LongestContinuousIncreasingSubsequence {

	// 연속된 증가하는 subsequence 중 가장 큰 길이를 찾는 문제.
	// 배열을 순회하며 max_value 값을 갱신하고, max_value 보다 nums[i] 가 작을 때가
	// 증가하는 subsequence의 종료 지점이므로, 해당 지점에서 최대 길이 값을 초기화한다.
	public int findLengthOfLCIS(int[] nums) {
		int len = nums.length;
		if (len == 0) return 0;

		int max = Integer.MIN_VALUE;
		int cnt = 0;
		int ans = 0;

		for (int i = 0; i < len; i++) {
			if (max < nums[i]) {
				max = nums[i];
				cnt++;
			} else {
				ans = ans < cnt ? cnt : ans;
				max = nums[i];
				cnt = 1;
			}
		}

		ans = ans < cnt ? cnt : ans;
		return ans;
	}
}
