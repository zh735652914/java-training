package beijing;
/*
https://leetcode.cn/problems/maximum-binary-tree-ii/
 */

// 题目意思不太好理解
public class insertIntoMaxTree {
    static class Solution {
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (root.val < val) {
                TreeNode preRoot = new TreeNode(val);
                preRoot.left = root;
                return preRoot;
            }
            root.right = insertIntoMaxTree(root.right, val);
            // 由于val 是新添加的位于数组末尾的元素，那么在构造的结果中，\textit{val}val 一定出现在该节点的右子树中
            // 下面一行需要注释掉
//            root.left = insertIntoMaxTree(root.left, val);
            return root;
        }
    }

    public static void main(String[] args) {
        String nodes = "[5,2,4,null,1]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        int val = 3;
        TreeNode ans = new Solution().insertIntoMaxTree(root, val);
        new PrintTree().LevelPrintTree(ans);
    }
}
