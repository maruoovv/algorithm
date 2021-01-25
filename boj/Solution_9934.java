import java.util.Scanner;

public class Solution_9934 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = Integer.parseInt(sc.nextLine());

        String[] input = sc.nextLine().split(" ");
        int[] nums = new int[input.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int[][] levels = new int[K][(int)Math.pow(2, K - 1)];
        splitTree(nums, levels, 0, 0, nums.length, K);

        int len = levels.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < levels[i].length; j++) {
                if (levels[i][j] == 0) break;

                System.out.printf("%d ", levels[i][j]);
            }

            System.out.println();
        }
    }

    public static void splitTree(int[] nums, int[][] levels, int level, int start, int end, int K) {
        int mid = (start + end) / 2;

        if (mid >= nums.length || mid < 0 || level >= K) return;

        int index = 0;
        for (int i = 0; i < levels[level].length; i++) {
            if (levels[level][i] == 0) break;

            index = i + 1;
        }

        levels[level][index] = nums[mid];

        splitTree(nums, levels, level + 1, start, mid - 1, K);
        splitTree(nums, levels, level + 1, mid + 1, end, K);
    }
}
