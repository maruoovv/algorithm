public class MinimizeSizeSubarraySum {

    // subarrray 의 길이가 최소가 되고, 합이 s 를 넘는 길이를 구해라.
    // 배열을 순회하며 합과 길이를 구하는데, 두개의 포인터를 이용한다.
    // 하나의 포인터는 왼쪽부터 오른쪽으로 순회하는 것,
    // 하나는 현재 합의 가장 왼쪽의 인덱스이다.
    // 합을 구해 나가는데, 합이 s 가 넘는다면
    // 그 때의 길이를 구한다. 그리고, 합이 s 보다 작아질 때 까지 왼쪽의 포인터를 이동 시키면서 빼준다.
    // 시간복잡도는 O(N)
    public int minSubArrayLen(int s, int[] nums) {

        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while(sum >= s) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
