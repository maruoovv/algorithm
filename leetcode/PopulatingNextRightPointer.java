import java.util.*;

public class PopulatingNextRightPointer {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // binary tree 가 주어지면, 자신의 오른쪽 노드를 가르키는 포인터를 연결해주는 문제.
    // Bfs 를 사용해서 해결.
    public Node connect(Node root) {
        if (root == null) return root;

        Queue<List<Node>> queue = new LinkedList<>();
        queue.add(Arrays.asList(root));

        while(!queue.isEmpty()) {
            List<Node> nodes = queue.poll();

            List<Node> added = new ArrayList<>();
            for (int i = 0; i < nodes.size(); i++) {
                Node cur = nodes.get(i);
                if (i != nodes.size() - 1) {
                    cur.next = nodes.get(i + 1);
                }

                if (cur.left != null) {
                    added.add(cur.left);
                }

                if (cur.right != null) {
                    added.add(cur.right);
                }
            }

            if (!added.isEmpty())
                queue.add(added);
        }

        return root;
    }


}
