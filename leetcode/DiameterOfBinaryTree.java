public class DiameterOfBinaryTree {

	// 이진트리에서 거리가 가장 먼 노드들의 거리를 구하는 문제.
	// left subtree 의 depth 와 right subtree 의 뎁스를 더한 값이 가장 큰 것이 가장 먼 노드의 거리이다.
	// 각각의 노드에 대해 left subtree, right subtree 의 depth를 구하고, 이를 더한 값으로 최대값을 검사한다.
	int ans = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		ans = 1;
		find(root);
		return ans - 1;
	}

	public int find(TreeNode cur) {
		if (cur == null) { return 0; }

		int left = find(cur.left);
		int right = find(cur.right);
		ans = Math.max(ans, left + right + 1);
		return Math.max(left, right) + 1;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) { val = x; }
	}

}
