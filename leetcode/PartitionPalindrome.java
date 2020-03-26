import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PartitionPalindrome {
	// discuss 보고 품.
	// 문자열을 재귀적으로 쪼개고, 팰린드럼인지 검사
	// 재귀적으로 쪼개는 거에 대한 감이 안와서 풀지 못했음. 더 연습이 필요
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		find(s, 0, res, temp);

		Stack<Integer> stack = new Stack<>();
		return res;
	}

	public void find(String s, int index, List<List<String>> res, List<String> temp) {
		if (index == s.length()) {
			res.add(new ArrayList(temp));
		}
		else {
			for (int i = index; i < s.length(); i++) {
				if (isPalindrome(s, index, i)) {
					temp.add(s.substring(index, i + 1));
					find(s, index + 1, res, temp);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}

	public boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++; end--;
		}

		return true;
	}
}
