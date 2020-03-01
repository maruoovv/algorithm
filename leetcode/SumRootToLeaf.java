public class SumRootToLeaf {

    // binary tree의 root 에서부터 leaf 까지의 숫자의 합을 구하는 문제.
    // preOrder 로 순회하며 각 값들을 더해나가고, 합친다.
    // 처음엔 더하는걸 스트링으로 더하는걸로 했다가.. 그냥 *10 씩 하며 숫자를 더하면 되니 변경.
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        int[] sum = new int[1];
        preOrder(root, root.val, sum);

        return sum[0];
    }

    public void preOrder(TreeNode node, int temp, int[] sum) {
        if (node.left == null && node.right == null) {
            sum[0] += temp;

            return;
        }

        if (node.left != null) {
            preOrder(node.left, temp * 10 + node.left.val, sum);
        }

        if (node.right != null) {
            preOrder(node.right, temp * 10 + node.right.val, sum);
        }
    }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

}
