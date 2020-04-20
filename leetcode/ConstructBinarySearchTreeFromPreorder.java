public class ConstructBinarySearchTreeFromPreorder {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

	// preorder 순회 배열이 주어지면, 바이너리 서치 트리를 만드는 문제.
	// 그냥 배열을 순회 하면서 bst 를 만들면 된다.
	public TreeNode bstFromPreorder(int[] preorder) {
		TreeNode root = new TreeNode(preorder[0]);

		// O(N * logN)
		for (int i = 1; i < preorder.length; i++) {
			TreeNode cur = root;
			TreeNode find = cur;
			while(find != null) {
				cur = find;
				if (cur.val < preorder[i]) {
					find = cur.right;
				} else {
					find = cur.left;
				}
			}

			if (cur.val < preorder[i]) cur.right = new TreeNode(preorder[i]);
			else cur.left = new TreeNode(preorder[i]);
		}

		return root;
	}
}
