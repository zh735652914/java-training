package Beijing;
/*
https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderBottom {
    static class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans = new LinkedList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int count = queue.size();
                while (count-- > 0) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                ans.add(0, level);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String nodes = "[3,9,20,null,null,15,7]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().levelOrderBottom(root));
    }
}
