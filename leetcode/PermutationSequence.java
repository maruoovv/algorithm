import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    // 순열에서 k번째 수를 찾는 문제
    // dfs 를 이용하여 전체 순열을 만들었다.
    // visit 배열을 두어 방문했던 숫자는 넣지 않게하고 문자열을 만들었다.
    public String getPermutation(int n, int k) {
        char[] origin = new char[n];

        for (int i =0 ;i < n; i++) {
            origin[i] = (char)(i + '1');
        }

        char[] target = new char[n];
        boolean[] visit = new boolean[n];
        List<String> results = new ArrayList<>();

        find(origin, target, visit, 0, n, results);

        return results.get(k - 1);
    }

    public void find(char[] origin, char[] target, boolean[] visit, int depth, int n, List<String> results) {
        if (depth == n) {
            results.add(new String(target));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                target[depth] = origin[i];
                visit[i] = true;
                find(origin, target, visit, depth + 1, n, results);
                visit[i] = false;
            }
        }
    }
}
