public class CheckValidStringSequenceBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // binary tree, 정수 배열이 주어진다.
    // 정수 배열이 binary tree 의 root -> leaf node 의 순서로 만들어 질수 있다면 true 반환 하는 문제.
    // 간단하게 재귀를 이용하여,
    // 각 노드에서 왼쪽 서브 트리, 오른쪽 서브 트리로 재귀를 하며 조건에 맞는지 검사한다.
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValid(root, arr, 0);
    }

    public boolean isValid(TreeNode root, int[] arr, int index) {
        if (root == null || index >= arr.length || root.val != arr[index]) return false;

        if (root.val == arr[index] && index == arr.length - 1 && root.left == null && root.right == null) return true;

        return isValid(root.left, arr, index + 1) || isValid(root.right, arr, index + 1);
    }
}