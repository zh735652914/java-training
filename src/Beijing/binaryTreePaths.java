package Beijing;
/*
https://leetcode-cn.com/problems/binary-tree-paths/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class binaryTreePaths {
    static class Solution {
        private List<String> ans;

        public List<String> binaryTreePaths(TreeNode root) {
            ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            dfs(root, new ArrayList<>());
            return ans;
        }

        private void dfs(TreeNode root, List<String> aPath) {
            aPath.add(String.valueOf(root.val));
            if (root.left == null && root.right == null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < aPath.size(); i++) {
                    stringBuilder.append(aPath.get(i));
                    if (i != aPath.size() - 1) {
                        stringBuilder.append("->");
                    }
                }
                ans.add(stringBuilder.toString());
                return;
            }
            if (root.left != null) {
                dfs(root.left, new ArrayList<>(aPath));
            }
            if (root.right != null) {
                dfs(root.right, new ArrayList<>(aPath));
            }
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "2", "3", "null", "5"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().binaryTreePaths(root));
    }
}
