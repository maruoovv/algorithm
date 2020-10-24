import java.util.*;

public class GenerateParenthesis {

    // n 만큼의 괄호짝이 주어지면 해당 길이의 유효한 괄호 문자열을 반환하는문제.
    // 단순히 재귀로 문자열들을 만들어주면서, 유효 후보로 올라갈수 없는 문자를 제외 시켜준다.
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        generate(n * 2, "", res);
        return res;
    }

    public void generate(int n, String temp, List<String> res) {
        if (!isValid(temp, false)) return;

        if (n == 0) {
            if (isValid(temp, true))
                res.add(temp);
            return;
        }

        generate(n - 1, temp + ")", res);
        generate(n - 1, temp + "(", res);
    }

    public boolean isValid(String current, boolean isEnd) {
        int cnt = 0;

        for (Character ch : current.toCharArray()) {
            if (cnt < 0) return false;

            if (ch == '(') cnt++;
            else if (ch == ')') cnt--;
        }

        if (cnt < 0) return false;
        if (isEnd) return cnt == 0;

        return true;
    }
}
