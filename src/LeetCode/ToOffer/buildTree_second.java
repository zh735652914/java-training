package LeetCode.ToOffer;
/*
剑指 Offer 07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。



例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7


限制：

0 <= 节点个数 <= 5000



注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

通过次数61,337提交次数88,998
 */

public class buildTree_second {
    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length != inorder.length) {
                return null;
            }
            return backtrack(preorder, inorder, 0, preorder.length - 1, 0);
        }

        private TreeNode backtrack(int[] preorder, int[] inorder, int start, int end, int pos) {
            if (start > end) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[pos]);
            if (start == end) {
                return root;
            }
            int index = start;
            while (index <= end) {
                if (inorder[index++] == preorder[pos]) {
                    break;
                }
            }
            index--;
            root.left = backtrack(preorder, inorder, start, index - 1, pos + 1);
            root.right = backtrack(preorder, inorder, index + 1, end, pos + 1 + index - start);
            return root;
        }


        public static void main(String[] args) {
            int[] preorder = {3, 9, 20, 15, 7};
            int[] inorder = {9, 3, 15, 20, 7};
            TreeNode root = new Solution().buildTree(preorder, inorder);
            new travelTree().levelTree(root);
        }
    }
}
