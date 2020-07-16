public class SubarrayProductLessThanK {

    // subarray 의 곱이 k 보다 작은 개수를 구하는 문제.
    // 두개의 포인터를 사용해서 곱을 구해 나가고, 곱이 k 보다 작을 때 결과값을 더해 간다.
    // 곱이 k 보다 커지면, left pointer 부터 곱이 k 가 작아질때 까지 나눠준다.
    // 5 2 6 이 순서대로 들어 온다고 하면,
    // subarray   |   cnt
    // 5          |   1
    // ((5)2)     |   2
    // (((5)2)6)  |   3
    // 원소가 하나가 추가될 때마다, subarray 의 개수는 r - l + 1 개가 추가된다.
    // nums       | subarray
    // 5          |  [5]
    // 5 2        |  [5], [2], [5,2]
    // 5 2 6      |  [5], [2], [5,2], [6], [2,6], [5,2,6]
    public  int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int prod = 1, ans = 0, left = 0;

        for (int right = 0; right < nums.length; right++) {
            prod = prod * nums[right];

            while(prod >= k) prod = prod / nums[left++];

            ans += (right - left)  + 1;

        }

        return ans;
    }

}
