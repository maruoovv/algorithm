import java.util.*;

public class G_MaximumCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int cn = 1;
        while(T > 0) {
            int ans = 0;

            int N = sc.nextInt();
            int[][] C = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    C[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int sum = 0;

                    for (int k = 0; i + k < N && j + k < N && k < N; k++) {
                        sum += C[i + k][j + k];
                    }

                    ans = Math.max(sum, ans);
                }
            }

//            1000

            System.out.printf("Case #%d: %d\n",cn, ans);

            cn++;
            T--;
        }
    }
}
