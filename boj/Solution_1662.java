import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_1662 {

    // 괄호를 포함한 숫자 문자열이 주어지면 주어진 조건에 따라 결과 문자열의 길이를 구하는 문제
    // 처음엔 조건에 따라 문자열을 계산하고 계속 큐에 넣어주는 방식으로 했었는데, 그 방법은 메모리 초과가 발생한다.
    // 생각을 좀 바꿔서, 큐에 문자열 + 현재 계산한 문자의 길이를 같이 넣어줬다.
    // 원래 문자와 길이를 계산한 문자를 구분하기 위해 특정값을 더해주고(여기선 100), 문자열의 길이가 50이라 100을 안넘을거 같아서
    // 문자열 길이를 계산해 나갈때 100보다 크면 100을 뺀 값을 더해주고, 아니면 숫자 하나이므로 1씩 증가시켜 준다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String input = sc.next();
        final Deque<Integer> deque = new LinkedList<>();
        for (Character ch : input.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                deque.add(Integer.valueOf(ch - '0'));
            } else if (ch == '(') {
                deque.add(-1);
            } else {
                if (deque.isEmpty()) continue;

                int len = 0;
                while(!deque.isEmpty()) {
                    int cur = deque.pollLast();

                    if (cur == -1) break;

                    if (cur >= 100) len += cur - 100;
                    else len += 1;
                }

                int K = 1;
                if (!deque.isEmpty()) K = deque.pollLast();

                len = (len * K) + 100;
                deque.add(len);
            }
        }

        int ans = 0;
        while(!deque.isEmpty()) {
            int cur = deque.pollLast();

            if (cur >= 100) {
                ans += cur - 100;
            } else ans++;
        }

        System.out.println(ans);
    }
}