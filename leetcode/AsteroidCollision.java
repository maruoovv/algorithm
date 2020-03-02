import java.util.Stack;

public class AsteroidCollision {

    // 처음엔 행성의 충돌에 순서가 있다고 생각하여 복잡하게 풀음.. (행성 크기와 연관이 있다고 생각)
    // 충돌하는 경우는 + 에서 - 로 갈때 밖에 없으니, 이 후보들의 절대값들을 구해놓고 최솟값을 찾는 식으로..
    // 하지만 그게 필요가 없단걸 깨닫게 되어 스택을 사용하는 것으로 바꿈
    // 양수면 스택에 넣고, 음수일때만 검사
    // 스택의 맨 위가 양수라면, 절대값 비교.
    // 같으면 둘다 스택에서 없애고, 하나가 크면 큰걸 스택에 넣음. 이때 넣는게 음수라면 다시 스택 내부와 비교하기 위해 index--
    // 스택의 맨 위가 음수라면, 두개 다 스택에 푸쉬.
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        int len = asteroids.length;
        for (int i = 0; i < len; i++) {
            if (asteroids[i] > 0 || stack.isEmpty()) {
                stack.push(asteroids[i]);
            } else if (asteroids[i] < 0) {
                Integer before = stack.pop();
                if (before < 0) {
                    stack.push(before);
                    stack.push(asteroids[i]);
                } else {
                    if (before == Math.abs(asteroids[i])) continue;
                    else if (before > Math.abs(asteroids[i])) {
                        stack.push(before);
                    } else {
                        i--;
                    }
                }
            }
        }

        len = stack.size();
        int[] ans = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }


        return ans;
    }
}
