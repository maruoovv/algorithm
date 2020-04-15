public class ProductOfArrayExceptSelf {

	// i 번째 원소를 제외한 모든 원소의 곱을 구하는 문제.
	// 나누기를 사용하지 않고, O(n) 에 해결해야한다.
	// a[0] a[1] a[2] a[3] 이런 배열이 있다면, 구해야 하는건
	// a[1]*a[2]*a[3] | a[0]*a[2]*a[3] | a[0]*a[1]*a[3] | a[0]*a[1]*a[2] 이다.
	// 배열을
	// 1 			  | a[0] 		| a[0]*a[1] | a[0]*a[1]*a[2]
	// a[1]*a[2]*a[3] | a[2]*a[3]	| a[3]		| 1
	// 이런식으로 채우고 곱하면, 원하는 값을 얻을 수 있다.
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] ans = new int[len];

		if (len == 0) return ans;

		ans[0] = 1;
		for (int i = 1; i < len; i++) {
			ans[i] = ans[i-1] * nums[i-1];
		}

		int temp = 1;
		for (int i = len - 2; i >= 0; i--) {
			temp = temp * nums[i + 1];
			ans[i] = ans[i] * temp;
		}

		return ans;

	}
}
