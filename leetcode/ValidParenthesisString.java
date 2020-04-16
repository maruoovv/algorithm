import java.util.Stack;

public class ValidParenthesisString {
	// ( ) * 로 구성된 문자열이 주어지고, * 은 "", "(", ")" 중 하나가 될 수 있을 때
	// valid한 괄호 문자열인지 판단하는 문제.
	// 스택을 두개 사용하여, 하나의 스택엔 (, 하나의 스택엔 * 의 index 를 넣는다.
	// 일반적인 괄호 문자열 검사에 더해, *을 저장한 스택 검사를 넣고,
	// 마지막엔 (을 저장한 스택을 비우는 작업을 하는데, (의 index 보다 뒤에 나온 * 가 있으면 지워준다.
	public boolean checkValidString(String s) {
		Stack<Integer> paren = new Stack<>();
		Stack<Integer> aster = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*') aster.push(i);
			else if (s.charAt(i) == '(') {
				paren.push(i);
			} else if (s.charAt(i) == ')') {
				if (paren.isEmpty() && aster.isEmpty()) return false;
				else if (!paren.isEmpty()) paren.pop();
				else if (!aster.isEmpty()) aster.pop();
			}
		}

		while(!aster.isEmpty() && !paren.isEmpty()) {
			if (aster.peek() > paren.peek()) {
				aster.pop();
				paren.pop();
			} else break;
		}

		return paren.isEmpty();
	}
}
