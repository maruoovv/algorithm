import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {

    // J 문자열의 각 문자가 S 문자열에 등장하는 개수를 구하는 문제
    // S 문자열을 순회하며 맵에 각 문자가 나온 개수를 구해놓고
    // J 문자열을 순회하며 각 문자열의 나온 수를 더한다.
    public int numJewelsInStones(String J, String S) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            String cur = S.charAt(i) + "";
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        int ans = 0;

        for (int i = 0; i < J.length(); i++) {
            String cur = J.charAt(i) + "";
            ans += map.getOrDefault(cur, 0);
        }

        return ans;
    }
}
