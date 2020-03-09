import java.util.HashMap;
import java.util.Map;
class MapSum {

	// key-value 가 주어진다.
	// key가 이미 있으면 value 는 덮어씌워지고, 없으면 더해진다.
	// Trie 를 구성하여 품.
	class Tree {
		int score;
		Tree[] trees;

		public Tree() {
			this.score = 0;
			this.trees = new Tree[26];
		}
	}

	Tree root;
	Map<String, Integer> map;

	/** Initialize your data structure here. */
	public MapSum() {
		root = new Tree();
		map = new HashMap<>();
	}

	public void insert(String key, int val) {
		Tree cur = root;
		boolean exist = map.get(key) == null ? false : true;
		int len = key.length();
		for (int i = 0; i < len; i++) {
			char temp = key.charAt(i);
			if (cur.trees[temp - 'a'] == null) {
				cur.trees[temp - 'a'] = new Tree();
			}

			cur = cur.trees[temp - 'a'];
			if (exist)
				cur.score = val;
			else
				cur.score += val;
		}

		map.put(key, 0);
	}

	public int sum(String prefix) {
		Tree cur = root;
		int sum = 0;
		int len = prefix.length();
		for (int i = 0; i < len; i++) {
			char temp = prefix.charAt(i);

			if (cur.trees[temp - 'a'] == null) {
				return 0;
			}
			cur = cur.trees[temp - 'a'];
			sum = cur.score;
		}

		return sum;
	}
}
