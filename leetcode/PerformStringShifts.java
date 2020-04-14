public class PerformStringShifts {
	// 문자열과 shift 정보가  주어지면 결과 문자열을 반환하는  문제.
	// 모든 shift 를 다 할필요 없이 왼쪽 오른쪽 쉬프트들의 합을 구해놓고 후처리 함
	public String stringShift(String s, int[][] shift) {
		int left = 0;
		int right = 0;

		for (int i = 0; i < shift.length; i++) {
			if (shift[i][0] == 0) left += shift[i][1];
			else right += shift[i][1];
		}

		left = left % s.length();
		right = right % s.length();
		int idx = 0;
		if (left == right) return s;
		else if (left > right) {
			idx = left - right;
		} else {
			idx = s.length() - (right - left);
		}

		String res = "";
		for (int i = idx; i < s.length() + idx; i++) {
			res += s.charAt(i % s.length());
		}

		return res;
	}
}
