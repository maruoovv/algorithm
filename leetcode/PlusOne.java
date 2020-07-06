import java.util.*;

public class PlusOne {

    // int 배열이 주어지면 +1 한 결과를 반환하는 문제.
    // 스택을 이용해서 Integer value 를 넣고,
    // 맨 뒤에 수부터 +1 한 결과를 계산한다.
    // 10이 넘으면 한자리 위의 수가 +1 되어야 함을 주의하며 수를 계산
    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();

        int len = digits.length;

        for (int i = 0; i < len; i++) {
            stack.push(digits[i]);
        }

        List<Integer> list = new ArrayList<>();

        int rem = 1;
        while(!stack.isEmpty()) {
            int top = stack.pop();
            int sum = top + rem;

            if (sum >= 10) {
                list.add(0);
                rem = 1;
            } else {
                list.add(sum);
                rem = 0;
            }
        }

        if (rem == 1) list.add(1);

        len = list.size();
        int[] ans = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            ans[len - i - 1] = list.get(i);
        }

        return ans;
    }
}
