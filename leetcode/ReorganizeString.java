public class ReorganizeString {

	// 스트링을 재조합 하여 인접한 문자가 같지 않은 문자열을 만들 수 있는지 판단하는 문제.
	// 처음엔 모든 조합을 만들고 검사했는데.. time limit exceeded 가 나왔다.
	// 문제를 풀기 전에 시간복잡도를 먼저 생각해보고 하는 습관을 들여야 할듯.
	// discuss 보고 해결
	// 각 문자의 개수를 카운팅하고, 수가 제일 많은 문자부터 문자열을 만들어 가는데
	// a _ a _ a _ a .. 이런식으로 먼저 짝수번째에 문자를 넣고, 그다음엔 홀수번째에 넣는다.
	// 제일 수가 많은 문자가 만약 짝수번째로도 안채워지는거면, 무조건 인접한 문자열이 같은게 존재하게 된다.
	// 아니라면, 목표 문자열을 만들 수 있다.
	public String reorganizeString(String S) {
		int[] wordCount = new int[26];

		for (int i = 0; i < S.length(); i++) {
			wordCount[S.charAt(i) - 'a']++;
		}

		char[] res = new char[S.length()];

		int max = 0;
		int maxIdx = 0;

		for (int i = 0; i < 26; i++) {
			if (wordCount[i] > max) {
				max = wordCount[i];
				maxIdx = i;
			}
		}

		int evenIdx = 0;
		int oddIdx = 1;
		while(wordCount[maxIdx] > 0) {
			if (evenIdx >= S.length()) return "";

			res[evenIdx] = (char)(maxIdx + 'a');
			evenIdx += 2;
			wordCount[maxIdx]--;
		}

		for (int i = 0; i < 26; i++) {
			if (i == maxIdx) continue;

			while(wordCount[i] > 0) {

				if (evenIdx < S.length()) {
					res[evenIdx] = (char)(i + 'a');
					evenIdx += 2;
				} else {
					res[oddIdx] = (char)(i + 'a');
					oddIdx += 2;
				}
				wordCount[i]--;
			}
		}

		return new String(res);
	}
}
