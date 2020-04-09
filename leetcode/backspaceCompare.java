import java.util.Stack;

public class backspaceCompare {
	public boolean backspaceCompare(String S, String T) {
		Stack<Character> s = new Stack<>();
		Stack<Character> t = new Stack<>();

		for (Character c : S.toCharArray()) {
			if (c == '#' && !s.isEmpty()) s.pop();
			else s.push(c);
		}

		for (Character c : T.toCharArray()) {
			if (c == '#' && !t.isEmpty()) t.pop();
			else t.push(c);
		}

		while(!s.isEmpty() && !t.isEmpty()) {
			if (s.pop() != t.pop()) return false;
		}

		if (s.isEmpty() && t.isEmpty()) return true;

		return false;

	}
}
