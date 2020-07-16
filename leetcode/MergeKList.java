import java.util.*;
public class MergeKList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 각각의 링크드 리스트는 정렬된 상태로 주어지고,
    // 전체를 다 합쳐서 정렬된 링크드 리스트를 반환하는 문제
    // minHeap 을 사용해서, 전체 원소를 적재하여 정렬된 리스트를 만든다.
    // 시간복잡도는 O(NlogN) 공간복잡도는 O(N)
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o));

        for (ListNode lnode : lists) {
            ListNode cur = lnode;
            while(cur != null) {
                pq.add(cur.val);
                cur = cur.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(!pq.isEmpty()) {
            ListNode cur = new ListNode(pq.poll());
            pre.next = cur;
            pre = pre.next;
        }

        return dummy.next;
    }
}
