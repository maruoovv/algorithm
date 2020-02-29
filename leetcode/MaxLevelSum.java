import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
    // binary tree 에서 level 의 value 합이 가장 큰 level 을 찾는 문제.
    // bfs 를 사용하여 level 별 합을 구함.
    public int maxLevelSum(TreeNode root) {
        int[] sum = new int[10001];
        boolean[] visit = new boolean[10001];

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.add(new Pair(root, 1));

        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            Integer level = pair.getValue();

            visit[level] = true;
            sum[level] += node.val;

            if (node.left != null) queue.add(new Pair(node.left, level + 1));
            if (node.right != null) queue.add(new Pair(node.right, level + 1));
        }

        int max = Integer.MIN_VALUE;
        int maxIdx = 0;

        for (int i = 0; i < 10001; i++) {
            if (max < sum[i]) {
                max = sum[i];
                maxIdx = i;
            }
        }

        return maxIdx;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
