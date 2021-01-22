import java.util.Scanner;

public class Solution_1138 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 4
        // 2 1 1 0
        // 0 2 1 0
        int N = sc.nextInt();
        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {
            int cnt = sc.nextInt();
            for (int j = 0; j < N; j++) {
                if (cnt == 0 && ans[j] == 0) {
                    ans[j] = i + 1;
                    break;
                }
                else if (ans[j] == 0) cnt--;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.printf("%d ", ans[i]);
        }
    }
}
