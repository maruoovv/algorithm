import java.util.Arrays;
import java.util.Scanner;

public class F_MetalHarvest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int cn = 1;
        while(T > 0) {
            int ans = 0;

            int N = sc.nextInt();
            int K = sc.nextInt();

            int[][] times = new int[N][2];
            int[] intervals = new int[N];

            for (int i = 0; i < N; i++) {
                times[i][0] = sc.nextInt();
                times[i][1] = sc.nextInt();

            }

            Arrays.sort(times, (a, b) -> a[0] - b[0]);

            for (int i = 0; i < N; i++) {
                intervals[i] = times[i][1] - times[i][0];
            }

            int time = times[0][0];
            for (int i = 0; i < N; i++) {
                time = Math.max(time, times[i][0]);
                if (time >= times[i][1]) continue;

                if (intervals[i] <= K) {
                    ans++;
                    time = time + K;
                } else {
                    int comp = times[i][1] - time;
                    int next = 0;

                    if ((comp % K) == 0) {
                        next = comp / K;
                    } else {
                        next = (comp / K) + 1;
                    }

                    time = time + next * K;
                    ans += next;

                }
            }


            System.out.printf("Case #%d: %d%n",cn, ans);

            cn++;
            T--;
        }
    }

}
