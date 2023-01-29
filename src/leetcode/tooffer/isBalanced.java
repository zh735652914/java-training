package leetcode.tooffer;
/*
面试题55 - II. 平衡二叉树
输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。



示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。



限制：

1 <= 树的结点个数 <= 10000
注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/



通过次数4,474提交次数7,523
 */

import java.util.Scanner;

//一定要记得数的最大深度的算法，真是耻辱。。。。。
public class isBalanced {
    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            if (Math.abs(treeDeep(root.left) - treeDeep(root.right)) > 1) return false;
            return isBalanced(root.left) && isBalanced(root.right);
        }

        private int treeDeep(TreeNode root) {
            if (root == null) return 0;
            return Math.max(treeDeep(root.left), treeDeep(root.right)) + 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] Arr = scanner.nextLine().split(",");
            TreeNode root = new buildTree.levelBuild().buildTree(Arr);
            System.out.println(new Solution().isBalanced(root));
        }
    }
}
