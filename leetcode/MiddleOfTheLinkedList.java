public class MiddleOfTheLinkedList {

	// 링크드 리스트의 중간을 찾는 문제.
	// 두개의 포인터를 사용해서 하나는 한칸씩(slow), 하나는 두칸씩(fast) 이동한다.
	// fast 가 null 이라면, 그떄의 slow 가 중간 지점이 된다.
	public ListNode middleNode(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode slow = head;
		ListNode fast = head.next;

		while(fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null)
				fast = fast.next;
		}

		return slow;
	}

	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}

}
