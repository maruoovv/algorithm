import java.util.Scanner;

public class Solution_5557 {

    // 중간에 나올수 있는 수의 범위가 0~20 이므로
    // 각 i 번째 나올수 있는 숫자의 개수를 계산
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        long[][] sum = new long[N - 1][21];

        sum[0][nums[0]] = 1;

        for (int i = 1; i < N - 1; i++) {
            int current = nums[i];

            for (int j = 0; j <= 20; j++) {
                long prev = sum[i-1][j];
                if (prev != 0) {
                    if (j + current <= 20) {
                        sum[i][j + current] = sum[i][j+current] + prev;
                    }

                    if (j - current >= 0) {
                        sum[i][j - current] = sum[i][j-current] + prev;
                    }
                }
            }
        }

        System.out.println(sum[N - 2][nums[N - 1]]);

    }
}
