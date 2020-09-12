import java.util.*;
import java.util.stream.Collectors;

public class FindAllDuplicatedInAnArray {

    // 1 ~ n 까지의 수로 이루어진 배열이 주어진다.
    // 몇개의  수는 2번 나오고 나머지는 한번만 나온다고 했을때,
    // no extra space, time complexity O(N) 으로 두번 나오는 수들을 반환하는 문제
    // extra space 제한이 있어, set 을 사용하지 못한다.
    // 보통은 결과를 위한 변수는 extra spaces 로 count 하지 않으므로, 결과 배열을 이용한다.
    // 결과 리스트를 선언해놓고, 원본 배열을 순회하며 나온 수들을 -1 로 해주고, -1 로 set 된 배열이 있다면 해당 수를 채워준다.
    // 이후 결과 배열을 순회하면서 0 이상인 수들이 2번 나온 수들 이다.
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            ans.add(0);
        }

        for (int i = 0; i < nums.length; i++) {
            if (ans.get(nums[i] - 1) == 0) {
                ans.set(nums[i] - 1, -1);
            } else {
                ans.set(nums[i] - 1, nums[i]);
            }
        }


        return ans.stream()
                .filter(o -> o > 0)
                .collect(Collectors.toList());
    }

}
