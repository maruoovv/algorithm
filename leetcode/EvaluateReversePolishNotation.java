import java.util.*;

public class EvaluateReversePolishNotation {

    // reverse polish notation 식이 주어졌을때, 결과를 계산하는 문제
    // 문제에 수식이 valid 하다는 조건이 있으므로, 단순히 스택 사용해서 품.
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String str : tokens) {
            if (str.equals("*") || str.equals("+") || str.equals("-") || str.equals("/")) {
                Integer n1 = stack.pop();
                Integer n2 = stack.pop();

                if (str.equals("*")) {
                    stack.push(n1 * n2);
                } else if (str.equals("+")) {
                    stack.push(n1 + n2);
                } else if (str.equals("-")) {
                    stack.push(n2 - n1);
                } else {
                    stack.push(n2 / n1);
                }

            } else {
                stack.push(Integer.valueOf(str));
            }
        }

        return stack.pop();
    }
}
