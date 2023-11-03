package beijing;
/*
https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 */

import java.util.*;

public class binaryTreeZigzagLevelOrderTraversal_103_topInterviewList {
    // 注意特殊情况
    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null) {
                return ans;
            }
            queue.offer(root);
            int deep = 0;
            Stack<Integer> tmp = new Stack<>();
            while (!queue.isEmpty()) {
                int count = queue.size();
                List<Integer> aLevel = new ArrayList<>();
                boolean reverse = (deep & 1) == 1;
                deep++;
                tmp.clear();
                while (count-- > 0) {
                    TreeNode cur = queue.poll();
                    if (reverse) {
                        tmp.push(cur.val);
                    } else {
                        aLevel.add(cur.val);
                    }
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                if (reverse) {
                    while (!tmp.isEmpty()) {
                        aLevel.add(tmp.pop());
                    }
                }
                ans.add(aLevel);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String nodes = "[3,9,20,null,null,15,7]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        root = null;
        System.out.println(new Solution().zigzagLevelOrder(root));
    }
}
