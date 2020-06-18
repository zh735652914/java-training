package LeetCode.ProgrammerInterview;
/*
面试题 04.02. 最小高度树
给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

示例:
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0
         / \
       -3   9
       /   /
     -10  5
通过次数5,925提交次数7,480
在真实的面试中遇到过这道题？


 */

import java.util.Arrays;

public class sortedArrayToBST {
    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums.length == 0) {
                return null;
            }
            if (nums.length == 1) {
                return new TreeNode(nums[0]);
            }
            if (nums.length == 2) {
                TreeNode root = new TreeNode(nums[1]);
                root.left = new TreeNode(nums[0]);
                return root;
            }
            int pos = (nums.length + 1) / 2 - 1;
            TreeNode root = new TreeNode(nums[pos]);
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, pos));
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, pos + 1, nums.length));
            return root;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = new Solution().sortedArrayToBST(nums);
        new sortedArrayToBST().per_visit_tree(root);
    }

    private void per_visit_tree(TreeNode root) {
        if (root == null) {
            System.out.print("null , ");
            return;
        }
        System.out.print(root.val + ",");
        per_visit_tree(root.left);
        per_visit_tree(root.right);
    }
}
