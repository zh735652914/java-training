package leetcode.tooffer;
/*
面试题54. 二叉搜索树的第k大节点
给定一棵二叉搜索树，请找出其中第k大的节点。



示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4


限制：

1 ≤ k ≤ 二叉搜索树元素个数

通过次数5,451提交次数7,530
 */

import java.util.ArrayList;
import java.util.List;

public class kthLargest {
    static class Solution {
        private List<Integer> list;

        public int kthLargest(TreeNode root, int k) {
            list = new ArrayList<>();
            inorder(root);
            return list.get(list.size() - k);
        }

        private void inorder(TreeNode root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"5", "3", "6", "2", "4", "null", "null", "1"};
        TreeNode root = new buildTree.levelBuild().buildTree(nodes);
        int k = 3;
        System.out.println(new Solution().kthLargest(root, k));
    }
}
