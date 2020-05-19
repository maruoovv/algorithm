public class MaximumProductSubarray {

    // 배열의 subarray 의 각요소의 곱중 가장 큰 값을 구하는 문제.
    // 수를 곱해 나가는건, 음수이든 양수이든 최대값이 될 수 있다.
    // 따라서 최대값, 최소값을 갱신하며 배열을 순회하고, 각 지점에서의 최대/최소값을 구하면 답을 찾을 수 있다.
    public int maxProduct(int[] nums) {
        int len = nums.length;

        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            int t = nums[i];
            int tMax = Math.max(t, Math.max(t * max, t *min));
            int tMin = Math.min(t, Math.min(t * max, t *min));
            ans = Math.max(tMax, ans);
            max = tMax;
            min = tMin;
        }

        return ans;
    }
}
