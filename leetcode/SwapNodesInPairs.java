public class SwapNodesInPairs {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 링크드 리스트가 주어지면 인접한 두 노드의 순서를 바꾸는 문제
    // recursive 한 방법으로 풀면,
    // 두번째 노드의 next를 첫번째 노드, 첫번째 노드의 next 를 세번째 노드로 바꾸는데, 세번째 노드를 다음 재귀로 넘겨
    // 재귀적으로 리스트의 순서가 바뀔수 있게 한다..
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;

        return swap(head);
    }

    public ListNode swap(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode second = head.next;
        ListNode third = head.next.next;

        second.next = head;
        head.next = swap(third);

        return second;
    }
}
