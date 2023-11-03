package beijing;
/*
https://leetcode.cn/problems/evaluate-boolean-binary-tree/
 */

/**
 * @author zhouhao
 * @date 2023/2/6 12:56
 */
public class EvaluateTree {
    // 的确是简单题
    static class Solution {
        public boolean evaluateTree(TreeNode root) {
            if (root.left == null && root.right == null) {
                return root.val == 1;
            }
            if (root.val == 2) {
                return evaluateTree(root.left) || evaluateTree(root.right);
            } else {
                return evaluateTree(root.left) && evaluateTree(root.right);
            }
        }
    }

    public static void main(String[] args) {
        String nodes = "{2,1,3,null,null,0,1}";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().evaluateTree(root));
    }
}
