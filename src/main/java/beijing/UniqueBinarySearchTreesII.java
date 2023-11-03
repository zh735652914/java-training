package beijing;
/*
https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 */

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    // 一开始题目意思没看懂
    static class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new LinkedList<>();
            }
            return dfs(1, n);
        }

        private List<TreeNode> dfs(int start, int end) {
            List<TreeNode> allTree = new LinkedList<>();
            if (start > end) {
                allTree.add(null);
                return allTree;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> lefts = dfs(start, i - 1);
                List<TreeNode> rights = dfs(i + 1, end);
                for (TreeNode left : lefts) {
                    for (TreeNode right : rights) {
                        TreeNode cur = new TreeNode(i);
                        cur.left = left;
                        cur.right = right;
                        allTree.add(cur);
                    }
                }
            }
            return allTree;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> ans = new Solution().generateTrees(n);
        for (TreeNode an : ans) {
            System.out.print("{ ");
            new PrintTree().LevelPrintTree(an);
            System.out.println(" } ");
        }
    }
}
