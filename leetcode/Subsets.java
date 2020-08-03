import java.util.*;
public class Subsets {

    // 주어진 배열의 모든 조합을 찾는 문제.
    // 비트 조작을 이용해 모든 조합을 찾는다.
    // nums 의 길이가 3이라고 했을 때,
    // 1 << 3 까지의 숫자를 비트로 생각하면
    // 000
    // 001
    // 010
    // 011
    // 100
    // 101
    // 110
    // 111
    // 각 비트가 1인 경우만 조합에 넣어주면, 모든 조합을 구할 수 있다.
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        for (int i = 0; i < (1 << len); i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) == 0) {
                    cur.add(nums[j]);
                }
            }

            res.add(cur);
        }

        return res;
    }

}
