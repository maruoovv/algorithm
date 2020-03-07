public class RemoveLinkedListElements {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // LinkedList 에서 특정 원소들을 제거하는 문제
    // head 를 가르키는 노드를 생성하여, 리스트를 순회하며 해당하는 원소를 제거
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        ListNode ret = new ListNode(-1);
        ret.next = head;
        ListNode cur = head;
        ListNode pre = ret;

        while(cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }

            cur = cur.next;
        }

        return ret.next;
    }
}
