import java.util.ArrayList;
import java.util.List;

public class NaryTreePostOrder {

	// N개의 노드를 가진 Node 들의 Tree를 postOrder 하는 문제.
	// 단순하게 재귀로 자식노드가 있을경우 postOrder 하는 식으로 구현
	public List<Integer> postorder(Node root) {
		List<Integer> res = new ArrayList<>();

		if (root == null) return res;

		postOrder(root, res);

		return res;
	}

	public void postOrder(Node root, List<Integer> res) {
		if (root.children.isEmpty()) {
			res.add(root.val);
		}

		for (int i = 0; i < root.children.size(); i++) {
			postOrder(root.children.get(i), res);
		}

		if (!root.children.isEmpty()) {
			res.add(root.val);
		}
	}

	class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}
}
