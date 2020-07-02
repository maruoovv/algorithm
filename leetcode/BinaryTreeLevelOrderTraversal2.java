import java.util.*;

public class BinaryTreeLevelOrderTraversal2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int maxLevel = 0;
    // binary tree 를 레벨오더 하는데, 맨 아래 레벨의 노드 부터 반환하는 문제.
    // dfs 를 하며 레벨별 노드들을 저장해놓고, 최하 레벨부터 결과값에 넣어준다.
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(map, root, 0);

        while(maxLevel >= 0) {
            res.add(map.get(maxLevel--));
        }

        return res;
    }

    public void dfs(Map<Integer, List<Integer>> map, TreeNode node, int level) {
        if (node == null) return;

        maxLevel = Math.max(maxLevel, level);
        List<Integer> levelValues = map.getOrDefault(level, new ArrayList<>());
        levelValues.add(node.val);
        map.put(level, levelValues);

        dfs(map, node.left, level + 1);
        dfs(map, node.right, level + 1);
    }
}
