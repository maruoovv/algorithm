public class LongestCommonSubSequence {
	public int longestCommonSubsequence(String text1, String text2) {
		int row = text1.length() + 1;
		int col = text2.length() + 1;
		int[][] lcs = new int[row][col];
		int max = 0;

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (text1.charAt(i - 1) != text2.charAt(j - 1)) {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				} else {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				}

				max = max < lcs[i][j] ? lcs[i][j] : max;
			}
		}

		return max;
	}
}
