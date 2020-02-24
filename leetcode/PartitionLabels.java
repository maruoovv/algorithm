import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    // 주어진 스트링을 서로 중복되는 요소가 없게 파티션으로 나누어야 하는 문제.
    // discuss 보고 해결..
    // 각 알파벳별 마지막 인덱스를 계산해놓고,
    // 주어진 문자열 처음부터 현재의 최대값과 각 알파벳의 최대값을 비교해 나간다.
    // 현재 최대값이 문자열의 인덱스와 같아질 때가 문자열을 왼쪽과 오른쪽 파티션으로 나눌 수 있을 때이다.
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];

        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < S.length(); i++) {
            right = Math.max(right, map[S.charAt(i) - 'a']);

            if (i == right) {
                res.add(right - left + 1);
                left = right + 1;
            }
        }

        return res;
    }

}
