public class BestTimeToBuyAndSellStock {

	// 주식을 언제 사고 언제 팔아야 이익이 최대인지 찾아내는 문제.
	// 최저점에서 사고, 수열이 상승->하락으로 바뀔 때 팔면 된다.
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (prices == null || len == 0) return 0;

		int max = prices[0];
		int maxIdx = 0;
		int minIdx = 0;
		int sum = 0;
		for (int i = 1; i < len; i++) {
			if (max <= prices[i]) {
				max = prices[i];
				maxIdx = i;
			} else {
				sum += (prices[maxIdx] - prices[minIdx]);
				max = prices[i];
				maxIdx = i;
				minIdx = i;
			}
		}

		sum += (prices[maxIdx] - prices[minIdx]);

		return sum;
	}
}
