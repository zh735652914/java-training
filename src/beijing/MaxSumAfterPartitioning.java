package beijing;
/*
https://leetcode.cn/problems/partition-array-for-maximum-sum/
 */

/**
 * @author zhouhao
 * @date 2023/4/19 13:00
 */
// 自己没有思路
public class MaxSumAfterPartitioning {
    static class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int[] dp = new int[arr.length + 1];
            for (int i = 1; i <= arr.length; i++) {
                int maxValue = arr[i - 1];
                for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                    dp[i] = Math.max(dp[i], dp[j] + maxValue * (i - j));
                    if (j > 0) {
                        maxValue = Math.max(maxValue, arr[j - 1]);
                    }
                }
            }
            return dp[arr.length];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        System.out.println(new Solution().maxSumAfterPartitioning(arr, k));
    }
}
