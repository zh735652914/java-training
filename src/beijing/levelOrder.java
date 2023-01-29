package beijing;
/*
https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            queue.add(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                List<Integer> aLevel = new ArrayList<>(count);
                for (int i = 0; i < count; i++) {
                    TreeNode node = queue.poll();
                    aLevel.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                ans.add(aLevel);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"3", "9", "20", "null", "null", "15", "7"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().levelOrder(root));
    }
}
