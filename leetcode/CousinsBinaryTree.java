import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsBinaryTree {

    // binary tree 안에서 부모가 다르면서 레벨이 같은 노드인지 판단하는 문제.
    // 간단하게 bfs 를 사용해서 각 노드의 레벨과 부모 노드 정보를 저장했다.
    // javafx 의 pair 를 쓴게 좀 찝찝
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        int[] levels = new int[101];
        int[] parents = new int[101];
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();

            TreeNode node = pair.getKey();
            Integer level = pair.getValue();
            levels[node.val] = level;

            if (node.left != null) {
                queue.add(new Pair(node.left, level + 1));
                parents[node.left.val] = node.val;
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, level + 1));
                parents[node.right.val] = node.val;
            }
        }

        if (levels[x] == levels[y] && parents[x] != parents[y]) return true;

        return false;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

