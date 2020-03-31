import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadderII {

	// 한번에 한 문자씩 바꿔가며 begin->end 로 바꾸는 최소값의 경로를 찾는 문제.
	// 단순 BFS로 풀었는데 객체로 생성하면 timeout 이 발생하여 인덱스와 이웃 노드(문자 하나만 차이나는 문자열들) 을 저장하고
	// BFS를 사용
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Queue<List<String>> queue = new LinkedList<>();
		List<List<String>> res = new ArrayList<>();
		List<String> start = new ArrayList<>();

		wordList.add(beginWord);
		int len = wordList.size();

		Map<String, Integer> indexes = new HashMap<>();
		for (int i = 0; i < len; i++) {
			indexes.put(wordList.get(i), i);
		}

		Map<String, List<String>> neighbors = new HashMap<>();
		for (int i = 0; i < len; i++) {
			String cur = wordList.get(i);
			List<String> neighbor = new ArrayList<>();
			for (int j = 0; j < len; j++) {
				String comp = wordList.get(j);

				if (diffcount(cur, comp) == 1) {
					neighbor.add(comp);
				}
			}

			neighbors.put(cur, neighbor);
		}

		start.add(beginWord);
		queue.add(start);

		int[] step = new int[len];
		step[len - 1] = 1;

		while(!queue.isEmpty()) {
			List<String> cur = queue.poll();
			int size = cur.size();
			String last = cur.get(size - 1);

			if (last.equals(endWord)) {
				res.add(cur);
				continue;
			}

			List<String> curNeighbor = neighbors.getOrDefault(last, Collections.emptyList());

			for (int i = 0; i < curNeighbor.size(); i++) {
				int idx = indexes.get(curNeighbor.get(i));
				if ((step[idx] == 0 || step[idx] > size)) {
					step[idx] = size + 1;

					List<String> newWords = new ArrayList<>();
					newWords.addAll(cur);
					newWords.add(curNeighbor.get(i));
					queue.add(newWords);
				}
			}
		}

		return res;
	}

	public int diffcount(String a, String b) {
		int cnt = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) { cnt++; }
		}
		return cnt;
	}
}
