package LeetCode.ToOffer;
/*
面试题27. 二叉树的镜像
请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1



示例 1：

输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]


限制：

0 <= 节点个数 <= 1000

注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/

通过次数4,384提交次数5,504
 */


import java.util.Scanner;

public class mirrorTree {
    static class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) return null;
            TreeNode tmp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(tmp);
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] Arr = scanner.nextLine().split(",");
            int[] nums = new int[Arr.length];
            for (int i = 0; i < Arr.length; i++) {
                nums[i] = Integer.parseInt(Arr[i]);
            }
            TreeNode root = new buildTree.levelBuild().buildTree(nums);
            TreeNode mirror = new Solution().mirrorTree(root);
            System.out.println();
        }
    }
}
