package beijing;
/*
https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/
 */

import java.util.LinkedList;
import java.util.Queue;

public class maximumLevelSumofaBinaryTree_1161 {
    // 就很正常的层次遍历
    static class Solution {
        public int maxLevelSum(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int maxSum = Integer.MIN_VALUE;
            int ans = 0, level = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                int sum = 0;
                level++;
                while (size-- > 0) {
                    TreeNode cur = queue.poll();
                    sum += cur.val;
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    ans = level;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new BuildTree().LevelBuildTree("[989,null,10250,98693,-89388,null,null,null,-32127]");
        System.out.println(new Solution().maxLevelSum(root));
    }
}
