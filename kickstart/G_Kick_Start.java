import java.util.*;

public class G_Kick_Start {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int cn = 1;
        while(T > 0) {
            int ans = 0;

            String S = sc.next();

            List<Integer> kick = new ArrayList<>();
            List<Integer> start = new ArrayList<>();

            int len = S.length();
            for (int i = 0; i < len; i++) {
                if (i + 4 > len) break;

                if (S.substring(i, i + 4).equals("KICK")) {
                    kick.add(i);
                }

                if (i + 5 > len) break;

                if (S.substring(i, i + 5).equals("START")) {
                    start.add(i);
                }
            }

            for (int i = 0; i < kick.size(); i++) {
                int k = kick.get(i);
                for (int j = 0; j < start.size(); j++) {
                    if (k < start.get(j)) ans++;
                }
            }

            System.out.printf("Case #%d: %d\n",cn, ans);

            cn++;
            T--;
        }
    }
}
