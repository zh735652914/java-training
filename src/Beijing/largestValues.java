package Beijing;
/*
https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 很典型的层次遍历
public class largestValues {
    static class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int len = queue.size();
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < len; i++) {
                    TreeNode node = queue.poll();
                    max = Math.max(max, node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                ans.add(max);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "3", "2", "5", "3", "null", "9"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().largestValues(root));
    }
}
