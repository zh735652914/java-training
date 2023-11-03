package beijing;
/*
https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */

import java.util.*;

public class zigzagLevelOrder {
    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            boolean count = true;
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> level = new ArrayList<>(size);
                stack.clear();
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    if (count) {
                        level.add(node.val);
                    } else {
                        stack.push(node);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                while (!stack.isEmpty()) {
                    level.add(stack.pop().val);
                }
                ans.add(level);
                count = !count;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"3", "9", "20", "null", "null", "15", "7"};
//        String[] nodes = {"1", "2", "3", "4", "null", "null", "5"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().zigzagLevelOrder(root));
    }
}
