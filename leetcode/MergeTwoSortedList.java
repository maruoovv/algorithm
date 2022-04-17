public class MergeTwoSortedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
        두개의 정렬된 링크드 리스트가 주어지면 하나의 정렬된 링크드 리스트를 만드는 문제
        단순히 각 리스트를 순회할 포인터를 만들어서, 작은걸 먼저 결과 리스트에 넣어주면 된다
        시간복잡도 O(N) 공간복잡도 O(N)
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode head = result;
        ListNode list1Head = list1;
        ListNode list2Head = list2;

        while (list1Head != null && list2Head != null) {
            if (list1Head.val < list2Head.val) {
                result.next = list1Head;
                list1Head = list1Head.next;
            } else {
                result.next = list2Head;
                list2Head = list2Head.next;
            }

            result = result.next;
        }

        while (list1Head != null) {
            result.next = list1Head;
            list1Head = list1Head.next;
            result = result.next;
        }

        while (list2Head != null) {
            result.next = list2Head;
            list2Head = list2Head.next;
            result = result.next;
        }

        return head.next;
    }
}
