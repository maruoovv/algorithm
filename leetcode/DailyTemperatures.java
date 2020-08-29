import java.util.*;

public class DailyTemperatures {

    // 일일 기온의 배열이 주어지고, 각 날짜보다 높은 온도가 몇일 뒤에 있는지를 계산하는 문제.
    // 처음엔 온도, indexes 해쉬 맵을 만들어, 각 날짜별 온도가 높은곳에 index 를 넣어주고,
    // 각 날짜별 온도시에 맵을 조사해서 index 들의 날짜를 갱신 시켜줬다. 하지만 이건 효율적이지 못했다.
    // 그래서 스택을 사용해서, 스택에는 각 날짜의 index 를 저장했다.

    // 스택의 인덱스를 저장했으니, 날짜별로 순회하며 현재 온도가 스택의 탑의 온도보다 높다면,
    // 현재날짜 index - 이전날짜 index 를 이전 결과 배열에 저장해준다.
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] ans = new int[len];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {

            while(!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int beforeIndex = stack.pop();
                ans[beforeIndex] = i - beforeIndex;
            }

            stack.push(i);
        }

        return ans;
    }
}
