import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class G_CombinationLock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int cn = 1;
        while(T > 0) {
            long ans = Long.MAX_VALUE;
            int W = sc.nextInt();
            int N = sc.nextInt();

            int[] wheel = new int[W];

            for (int i = 0; i < W; i++) {
                wheel[i] = sc.nextInt();
            }

            for (int i = 0; i < W; i++) {
                ans = Math.min(ans, costSum(wheel, wheel[i], N, W, ans));
            }

            System.out.printf("Case #%d: %d\n",cn, ans);

            cn++;
            T--;
        }
    }

    public static long costSum(int[] wheel, int target, int N, int W, long ans) {
        long sum = 0;
        for (int j = 0; j < W; j++) {
            int t = 0;
            if (wheel[j] > target) {
                t = Math.abs(N - wheel[j] + target);
            } else {
                t = Math.abs(N - target + wheel[j]);
            }
            int temp = Math.min(Math.abs(target - wheel[j]), t);
            sum += temp;

            if (sum > ans) return ans;
        }

        return sum;
    }
}
