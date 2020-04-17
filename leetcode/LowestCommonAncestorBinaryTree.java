public class LowestCommonAncestorBinaryTree {

	// BinaryTree 에서 두 노드의 최소 공통 조상을 찾는 문제.
	// Tree 를 순회하며 왼쪽 서브트리, 오른쪽 서브트리를 검사한다.
	// 순회시에 p 나 q 와 일치하면 cur 을 반환하고, 아닐시엔 null을 반환하게 되는데,
	// left, right 가 둘다 null 이 아니라면 현재 노드가 최소 공통 조상이다.
	// 만약 하나만 null 이 아니라면, null이 아닌 노드를 반환하여 뒤의 검사를 이어가도록 한다.
	// 이 문제와 비슷한 문제로 235. Lowest Common Ancestor of a Binary Search Tree 가 있는데,
	// 이문제는 binary search tree 의 특성을 이용하여 풀 수 있다.
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return find(root, p,  q);
	}

	public TreeNode find(TreeNode cur, TreeNode p, TreeNode q) {
		if (cur == null || cur == p || cur == q) return cur;

		TreeNode left = find(cur.left, p, q);
		TreeNode right = find(cur.right, p, q);

		if (left != null && right != null) return cur;
		else if(left == null && right != null) return right;
		else if(left != null && right == null) return left;
		else return null;

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
