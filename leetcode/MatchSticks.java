import java.util.Arrays;

public class MatchSticks {

    // stick 들이 주어질 때, 사각형을 만들 수 있는지 여부를 판단하는 문제.
    // 사각형을 만들어야 하므로, 각 막대기들은 사각형의 한 변에 속할 수 있고,
    // 한 변의 길이는 막대들의 총 합의 / 4 가 된다.
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;

        Arrays.sort(nums);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 4 != 0) return false;

        int[] temp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[nums.length - i - 1];
        }

        int[] columns = new int[4];
        return makeSquares(temp, columns, 0, nums.length, sum / 4);
    }

    public boolean makeSquares(int[] nums, int[] column, int index, int cnt, long target) {
        if (cnt == 0) {
            for (int i = 0; i < 4; i++) {
                if (column[i] != target) return false;
            }

            return true;
        }

        for (int i = 0; i < 4; i++) {
            boolean plus = column[i] + nums[index] > target ? false : true;

            if (plus) {
                column[i] = column[i] + nums[index];
                if (makeSquares(nums, column, index + 1, cnt - 1, target)) {
                    return true;
                }
                column[i] = column[i] - nums[index];
            }
        }


        return false;
    }

}
