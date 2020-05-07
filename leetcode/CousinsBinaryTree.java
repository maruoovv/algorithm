
class CousinsBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // binary tree 에서 2개의 노드가 동일 레벨, 다른 부모를 갖고 있는지 검사하는 문제.
    // 재귀를 돌면서 대상을 찾을 경우 해당 노드의 레벨, 부모 노드의 값을 가지는 배열을 반환한다.
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] xfind = find(root, root, x, 0);
        int[] yfind = find(root, root, y, 0);

        return xfind[0] == yfind[0] && xfind[1] != yfind[1];
    }

    public int[] find(TreeNode parent, TreeNode root, int target, int level) {
        if (root == null) return null;

        if (root.val == target) {
            return new int[]{level, parent.val};
        }

        if (root.left != null) {
            int[] ans =  find(root, root.left, target, level + 1);
            if (ans != null) return ans;
        }

        if (root.right != null) {
            int[] ans =  find(root, root.right, target, level + 1);
            if (ans != null) return ans;
        }

        return null;
    }
}