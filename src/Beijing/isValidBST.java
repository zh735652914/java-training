package Beijing;
/*
https://leetcode-cn.com/problems/validate-binary-search-tree/
 */

public class isValidBST {

    // 二叉搜索树的中序遍历为升序！
    static class Solution {
        long pre = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isValidBST(root.left)) {
                return false;
            }
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            return isValidBST(root.right);
        }
    }

    public static void main(String[] args) {
//        String[] nodes = {"2", "1", "3"};
//        String[] nodes={"5","1","4","null","null","3","6"};
        String[] nodes = {"5", "4", "6", "null", "null", "3", "7"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().isValidBST(root));
    }
}
