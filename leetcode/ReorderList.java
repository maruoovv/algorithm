public class ReorderList {
	// LinkedList 가 주어지고, 리스트 순서를 바꾸는 문제.
	// pointer 세개를 사용하여 순서를 바꿨는데, 효율성 면에서 매우 떨어진다.
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) return;

		ListNode cur = head;

		while(cur != null && cur.next != null && cur.next.next != null) {
			ListNode pre = null, tail = cur;
			while(tail.next != null) {
				pre = tail;
				tail = tail.next;
			}

			tail.next = cur.next;
			pre.next = null;
			cur.next = tail;
			cur = tail.next;
		}
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
