import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			String cur = s.charAt(i) + "";

			if (cur.equals("(") || cur.equals("{") || cur.equals("[")) {
				stack.push(cur);
			} else {
				if (stack.isEmpty()) return false;
				if (cur.equals(")")) {
					if (!stack.peek().equals("(")) return false;

					stack.pop();
				} else if (cur.equals("}")) {
					if (!stack.peek().equals("{")) return false;

					stack.pop();
				} else {
					if (!stack.peek().equals("[")) return false;
					stack.pop();
				}
			}
		}

		return stack.isEmpty();
	}
}
