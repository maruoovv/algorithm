public class DeleteOperationforTwoStrings {

	// 한번에 각 문자열에서 하나의 문자만 삭제할 때,
	// 두 문자열을 같게 해주는 최소 연산 횟수를 구하는 문제
	// LCS 알고리즘을 이용해서, 두 문자열의 최장일치증가수열의 길이를 구한다.
	public int minDistance(String word1, String word2) {
		if (word1.isEmpty()) return word2.length();
		if (word2.isEmpty()) return word1.length();

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		int max = 0;
		for (int i = 1; i < word1.length() + 1; i++) {
			for (int j = 1; j < word2.length() + 1; j++) {
				if (word2.charAt(j - 1) != word1.charAt(i - 1)) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				} else {
					dp[i][j] = 1 + dp[i-1][j-1];
				}

				max = max < dp[i][j] ? dp[i][j] : max;
			}
		}

		return (word1.length() - max) + (word2.length() - max);
	}
}
