package beijing;
/*
https://leetcode.cn/problems/insufficient-nodes-in-root-to-leaf-paths/
 */

/**
 * @author zhouhao
 * @date 2023/5/22 12:41
 */
// 自己没写出来
public class SufficientSubset {
    static class Solution {
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            boolean notNULL = checkSufficientLeaf(root, 0, limit);
            return notNULL ? root : null;
        }

        public boolean checkSufficientLeaf(TreeNode node, int sum, int limit) {
            if (node == null) {
                return false;
            }
            if (node.left == null && node.right == null) {
                return node.val + sum >= limit;
            }
            boolean haveSufficientLeft = checkSufficientLeaf(node.left, sum + node.val, limit);
            boolean haveSufficientRight = checkSufficientLeaf(node.right, sum + node.val, limit);
            if (!haveSufficientLeft) {
                node.left = null;
            }
            if (!haveSufficientRight) {
                node.right = null;
            }
            return haveSufficientLeft || haveSufficientRight;
        }
    }

    public static void main(String[] args) {
        String nodes = "[10,5,10]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        int limit = 21;
        TreeNode ans = new Solution().sufficientSubset(root, limit);
        new PrintTree().LevelPrintTree(ans);
    }
}
