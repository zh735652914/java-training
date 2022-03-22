package Beijing;
/*
https://leetcode-cn.com/problems/unique-binary-search-trees/
 */

// 自己没想道，分为左右子树的数量来dp
public class UniqueBinarySearchTrees {
    static class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[i - j] * dp[j - 1];
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
