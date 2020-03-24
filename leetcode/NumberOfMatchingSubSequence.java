import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfMatchingSubSequence {

	// S, words 가 주어졌을때, S의 subsequence 인 word 의 개수를 구하는 문제.
	// 먼저 S 를 순회하면서 각 알파벳 별 인덱스를 리스트로 저장.
	// words 를 순회하면서 각 word에 대해
	// word[0...len] 까지의 각 알파벳별 인덱스 리스트를 가져오고,
	// 이전 인덱스보다 크면서 최소인 값을 찾음.
	// 이 값이 len(word) 와 같다면 subsequence
	public int numMatchingSubseq(String S, String[] words) {
		int ans = 0;
		int len = S.length();

		Map<String, List<Integer>> indexes = new HashMap<>();

		for (int i = 0; i < len; i++) {
			List<Integer> temp = indexes.getOrDefault(S.charAt(i) + "", new ArrayList<>());
			temp.add(i);
			indexes.put(S.charAt(i) + "", temp);
		}

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			int before = -1;
			int cnt = 0;

			for (int j = 0; j < word.length(); j++) {
				List<Integer> candidates = indexes.get(word.charAt(j) + "");

				if (candidates == null) break;

				for (int k = 0; k < candidates.size(); k++) {
					if (before < candidates.get(k)) {
						before = candidates.get(k);
						cnt++;
						break;
					}
				}
			}

			if (cnt == word.length()) ans++;
		}

		return ans;
	}
}
