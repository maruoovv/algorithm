import java.util.*;
public class MajorityElementII {

    // 수의 개수가 len / 3 을 넘는 수를 찾는 문제. 시간복잡도 O(N), 공간복잡도 O(1) 로 풀어야 한다.
    // len 길이의 배열에서 len / 3 을 넘을수 있는 수의 개수는, 최소 0개, 최대 2개 이다.
    // 최대 2개까지 가능 하므로 먼저 배열을 한번 순회 하며 가장 빈도수가 큰 수 두개를 뽑는다.
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        int n = len / 3;

        if (len == 0) return list;

        int n1 = nums[0], n2 = nums[0], c1 = 0, c2 = 0;

        // 1 1 1 3 4 5 6 7
        // n1 c1 n2 c2
        // 1  0   1  0
        // 1  1   1  0  // i = 0
        // 1  2   1  0  // i = 1
        // 1  3   1  0  // i = 2
        // 1  3   3  1  // i = 3
        // 1  2   3  0  // i = 4
        // 1  2   5  1  // i = 5
        // 1  1   5  0  // i = 6
        // 1  1   7  1  // i = 7
        // O(N) 생각하기가 힘든거같음
        for (int i = 0; i < len; i++) {
            if (n1 == nums[i]) {
                c1++;
            } else if (n2 == nums[i]) {
                c2++;
            } else if (c1 == 0) {
                n1 = nums[i];
                c1 = 1;
            } else if (c2 == 0) {
                n2 = nums[i];
                c2 = 1;
            } else {
                c1--; c2--;
            }
        }

        c1 = 0;
        c2 = 0;

        for (int i = 0; i < len; i++) {
            if (n1 == nums[i]) c1++;
            else if (n2 == nums[i]) c2++;
        }

        if (c1 > n) list.add(n1);
        if (c2 > n) list.add(n2);
        return list;

    }
}
