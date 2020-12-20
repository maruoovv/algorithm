public class SumOfAbsoluteDifferencesSortedArray {

    // https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
    // 정렬된 배열이 주어지고 배열내 자신과 다 수와 차이의 절대값의 합들을 구하는 문제.
    // 1. 단순히 n^2 으로 푸는 방법
    // 2. 결과 배열을 res[] 라 했을때
    // res[i] = |nums[i] - nums[0]| + |nums[i] - nums[1]| .... + |nums[i] - nums[length - 1]|
    // 다음과 같은 식이 된다.
    // 절대값이 아니라면
    // nums[i] * i - (nums[0] + nums[1] + ... + nums[length - 1]) 이런 단순한 식이 될수 있지만 절대값이라 그건 안된다.
    // 정렬된 배열이므로, n < i 인 것들은 nums[i] 보다 작고, n > i 인 것들은 nums[i] 보다 크다.
    // 따라서 n < i => nums[i] * i - (nums[0] + .. + nums[i - 1]),
    // n > i => (nums[i+1] + ... + nums[length - 1]) - nums[i] * (length - i - 1) 이 식이 도출될수 있다.
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int length = nums.length;
        int[] prefixSum = new int[length];
        int temp = 0;
        for (int i = 0; i < length; i++) {
            temp += nums[i];
            prefixSum[i] = temp;
        }

        int[] res = new int[length];

        for (int i = 0; i < length; i++) {
            int right = prefixSum[length - 1] - prefixSum[i] - (nums[i] * (length - i - 1));

            if (i == 0) {
                res[i] = right;
            } else {
                res[i] = (nums[i] * i - prefixSum[i - 1]) + right;
            }

        }
        return res;
    }
}
