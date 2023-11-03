package beijing;
/*
https://leetcode.cn/problems/minimum-cost-tree-from-leaf-values/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/5/31 13:15
 */
public class MctFromLeafValues {
    // 看了解析才会
    static class Solution {
        public int mctFromLeafValues(int[] arr) {
            /*
            dp[i][j] 表示数组i到j中，对应子数组所有非叶子节点的最小总和
             */
            int[][] dp = new int[arr.length][arr.length];
            int[][] maxVal = new int[arr.length][arr.length];
            for (int[] row : dp) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            for (int j = 0; j < arr.length; j++) {
                maxVal[j][j] = arr[j];
                dp[j][j] = 0;
                for (int i = j - 1; i >= 0; i--) {
                    maxVal[i][j] = Math.max(arr[i], maxVal[i + 1][j]);
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + maxVal[i][k] * maxVal[k + 1][j]);
                    }
                }
            }
            return dp[0][arr.length - 1];
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 4};
        System.out.println(new Solution().mctFromLeafValues(arr));
    }
}
