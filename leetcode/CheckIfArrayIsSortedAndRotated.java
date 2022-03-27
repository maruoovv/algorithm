public class CheckIfArrayIsSortedAndRotated {

    // 1752   https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
    // 배열이 주어지면 n번 로테이트가 가능할때 감소하지 않는 수열인지 판단하는 문제
    // 처음에는 최대값을 가지는 최소 인덱스를 찾고, 그 인덱스부터 modulo 순회를 하면서 감소하지 않는 수열인지 판단했다.
    // 하지만 굳이 그럴필요 없이, 배열을 순회하면서 이전값보다 이후값이 작은게 있는지 검사하고, 이 개수가 2개 이상이라면
    // 해당 수열은 감소하는 부분이 두번 나오므로, 감소하지 않는 수열이라고 볼수 있다.

    public boolean check(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] > nums[(i + 1) % len]) {
                count++;
            }

            if (count > 1) return false;
        }

        return true;
    }
}
