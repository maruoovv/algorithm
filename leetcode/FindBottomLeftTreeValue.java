import java.util.*;

public class FindBottomLeftTreeValue {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
     }

    // binary tree 가 주어지면, bottom 의 가장 왼쪽 노드를 찾는 문제.
    // level order 를 하면서 , 각 레벨의 첫번째 노드가 가장 왼쪽 노드이다.
    public int findBottomLeftValue(TreeNode root) {
        Queue<List<TreeNode>> queue = new LinkedList<>();
        int res = 0;

        queue.add(Collections.singletonList(root));

        while(!queue.isEmpty()) {
            List<TreeNode> cur = queue.poll();
            res = cur.get(0).val;
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < cur.size(); i++) {
                TreeNode curNode = cur.get(i);
                if (curNode.left != null)
                    list.add(curNode.left);
                if (curNode.right != null)
                    list.add(curNode.right);
            }

            if (!list.isEmpty())
                queue.add(list);
        }

        return res;
    }
}
