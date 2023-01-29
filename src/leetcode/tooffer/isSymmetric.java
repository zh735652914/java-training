package leetcode.tooffer;
/*
面试题28. 对称的二叉树
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3



示例 1：

输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：

输入：root = [1,2,2,null,3,null,3]
输出：false


限制：

0 <= 节点个数 <= 1000

注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/

通过次数3,214提交次数5,490
 */

import java.util.Scanner;

//不会写了。。。
public class isSymmetric {
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return backtrack(root.left, root.right);
        }

        private boolean backtrack(TreeNode left, TreeNode right) {
            if (left == null || right == null) return left == right;
            if (left.val != right.val) return false;
            return backtrack(left.right, right.left) && backtrack(left.left, right.right);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = new buildTree.levelBuild().buildTree(scanner.nextLine().split(","));
        System.out.println(new Solution().isSymmetric(root));
    }
}
