public class RemoveAdjacentDuplicated {

	// 연속으로 k 개 만큼 인접한 문자열을 없애는 문제.
	// LinkedList 에 문자와 연속한 개수를 저장하고, 순회하며 없애고, 합치는 식으로 했다.
	// 근데 불필요하게 어렵게 짠듯 하다.. 그냥 재귀로 푸는게 나았을걸.
	// 코드도 너무 지저분해서 리팩토링 필요
	// 맑은 정신으로 다시 한번 보자
	public String removeDuplicates(String s, int k) {
		int len = s.length();
		Node root = new Node('A', 0);
		Node head = root;
		for (int i = 0; i < len; i++) {
			char cur = s.charAt(i);
			int cnt = 1;

			int j = i + 1;
			for (; j < len; j++) {
				if (j == len - 1 || cur != s.charAt(j)) {

					if (j == len - 1 && cur == s.charAt(j)) {
						cnt++;
						j++;
					}
					Node node = new Node(cur, cnt);
					head.next = node;
					head = head.next;
					i += j - i - 1;
					break;
				}
				cnt++;
			}

			if (i == len - 1 && cnt == 1) {
				Node node = new Node(cur, cnt);
				head.next = node;
				head = head.next;
			}
		}


		while(true) {
			boolean find = false;
			Node pre = root;
			Node cur = root.next;

			while(cur != null) {
				if (cur.count == k) {
					pre.next = cur.next;
					find = true;
					if (cur.next != null && pre.word == cur.next.word) {
						pre.count += cur.next.count;
						pre.next = cur.next.next;
					}

					cur = pre.next;
				} else if (cur.count > k) {
					find = true;
					cur.count -= k;
				}
				else {
					pre = cur;
					cur = cur.next;
				}

			}

			if (!find) break;
		}

		Node cur = root.next;
		String res = "";
		while(cur != null) {
			String temp = "";
			for (int i = 0; i < cur.count; i++) {
				temp += cur.word;
			}

			res += temp;
			cur = cur.next;
		}

		return res;
	}

	class Node {
		char word;
		int count;
		Node next;

		public Node(char word, int count) {
			this.word = word;
			this.count = count;
			this.next = null;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
}
