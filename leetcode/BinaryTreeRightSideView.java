import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeRightSideView {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) { val = x; }
	}

	// binary 트리를 오른쪽에서 봤을때 보이는 수를 찾는 문제.
	// postorder 로 트리를 순회 하면서, 각 depth 의 값을 업데이트 한다.
	// postorder 이므로, 각 뎁스를 방문 할때마다 업데이트 하면 각 뎁스의 마지막 방문한 노드가 가장 오른쪽 노드가 된다.
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) { return res; }
		Map<Integer, Integer> map = new HashMap<>();

		find(root, map, 1);

		for (int i = 1; i <= map.size(); i++) {
			res.add(map.get(i));
		}

		return res;
	}

	public void find(TreeNode cur, Map<Integer, Integer> map, int depth) {
		if (cur == null) { return; }

		if (cur.left != null) { find(cur.left, map, depth + 1); }
		if (cur.right != null) { find(cur.right, map, depth + 1); }

		map.put(depth, cur.val);
	}

}
