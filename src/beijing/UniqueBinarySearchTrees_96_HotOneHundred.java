package beijing;
/*
https://leetcode.cn/problems/unique-binary-search-trees/
 */

/**
 * @author zhouhao
 * @date 2023/8/18 12:59
 */
public class UniqueBinarySearchTrees_96_HotOneHundred {
    // 还是不会写
    static class Solution {
        public int numTrees(int n) {
            /*
            dp[i]为i个节点可以组成多少个不同的搜索二叉树
             */
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    /*
                    i个节点以j为根，所获得的不同搜索二叉树个数
                     */
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().numTrees(n));
    }
}
