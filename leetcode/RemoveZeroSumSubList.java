import java.util.*;
public class RemoveZeroSumSubList {

    // LinkedList 에서, value 의 합이 0 인 노드들을 제거 하는 문제.
    // 아이디어는.. value 들을 더해 나가는데 이전에 나왔던 값이 나온다면 합이 0이 되는 구간이 있는 것이다.
    // 1 2 -1 -2 3
    // 이런 리스트가 주어졌다고 했을 때,
    // sum idx
    //  0   -1
    //  1   0
    //  3   1
    //  2   2
    //  0   3 // 여기서 이전에 나왔던 값이 나오므로, 합이 0이 되는 구간이 있다.
    // 리스트를 순회 하며 value 의 합을 구해 나가며 맵에 현재의 합을 키, 현재의 노드를 밸류로 저장을 한다면,
    // sum idx   nodes
    //  0   -1   dummy 1 2 -1 -2 3
    //  1   0    1 2 -1 -2 3
    //  3   1    2 -1 -2 3
    //  2   2    -1 -2 3
    //  0   3 // 여기서, 이전에 나왔던 sum == 0 의 노드를 가져오고, 그 노드의 head.next 를 현재 노드.next 를 이어주면, 합이 0인 구간을 뺄수 있다.
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return head;

        Map<Integer, ListNode> map = new HashMap<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int sum = 0;
        ListNode cur = dummy;
        while(cur != null) {
            sum += cur.val;
            map.put(sum, cur);
            cur = cur.next;
        }

        sum = 0;
        cur = dummy;
        while(cur != null) {
            sum += cur.val;
            cur.next = map.get(sum).next;
        }

        return dummy.next;

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
