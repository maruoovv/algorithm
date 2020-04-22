public class SubarraySum {

    // 배열과 k 값이 주어진다.
    // 배열의 Subarray 의 합이 K 와 같은 subarray 의 개수를 구하여라.
    // 먼저, 전체 배열에 대해 순차적인 합을 구한다.
    // sum[i] = nums[0] + nums[1] + ... + nums[i]
    // 그 후, subarray 의 합을 구하는데, 이는 sum 배열을 이용할 수 있다.
    // 만약, nums[] = 1 2 3 4 5 배열에서 3 4 5 의 합을 구한다고 하면,
    // sum[4] - sum[1] 가 된다.
    // 이를 위해, 이중포문을 사용하여
    // startIdx = i, endIdx = j 의 subarray 들의 합을 구한다.
    public  int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] subSum = new int[n];

        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                subSum[j] = sum[j] - ((i - 1 >= 0) ? sum[i - 1] : 0);
                if (subSum[j] == k) ans++;
            }
        }

        return ans;
    }
}
