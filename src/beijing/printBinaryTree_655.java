package beijing;
/*
https://leetcode.cn/problems/print-binary-tree/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 不太好搞
public class printBinaryTree_655 {
    static class Solution {
        private String[][] matrix;
        private int height;

        public List<List<String>> printTree(TreeNode root) {
            height = getHeight(root);
            int len = (int) Math.pow(2, height) - 1;
            List<List<String>> ans = new ArrayList<>(height);
            matrix = new String[height][len];
            for (int i = 0; i < height; i++) {
                Arrays.fill(matrix[i], "");
            }
            int x = 0, y = (len - 1) / 2;
            placeMatrix(root, x, y);
            for (int i = 0; i < height; i++) {
                List<String> aLevel = new ArrayList<>(len);
                aLevel.addAll(List.of(matrix[i]));
                ans.add(aLevel);
            }
            return ans;
        }

        private void placeMatrix(TreeNode root, int x, int y) {
            matrix[x][y] = String.valueOf(root.val);
            if (root.left != null) {
                placeMatrix(root.left, x + 1, y - (int) Math.pow(2, height - 1 - x - 1));
            }
            if (root.right != null) {
                placeMatrix(root.right, x + 1, y + (int) Math.pow(2, height - 1 - x - 1));
            }
        }

        private int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }

    public static void main(String[] args) {
        String nodes = "[1,2,3,null,4]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().printTree(root));
    }
}
