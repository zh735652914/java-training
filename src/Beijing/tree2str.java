package Beijing;
/*
https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 */

public class tree2str {
    // 这题也没什么意思，在前序遍历上修改一下就行了
    static class Solution {
        public StringBuilder stringBuilder;

        public String tree2str(TreeNode root) {
            stringBuilder = new StringBuilder();
            preVisited(root);
            return stringBuilder.substring(1, stringBuilder.length() - 1);
        }

        private void preVisited(TreeNode root) {
            if (root == null) {
                return;
            }
            stringBuilder.append('(');
            stringBuilder.append(root.val);
            if (root.left == null && root.right != null) {
                stringBuilder.append("()");
            }
            preVisited(root.left);
            preVisited(root.right);
            stringBuilder.append(')');
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "2", "3", "4"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().tree2str(root));
    }
}
