package beijing;
/*
https://leetcode.cn/problems/largest-plus-sign/
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 自己不会写
public class orderOfLargestPlusSign {
    static class Solution {
        private Map<Integer, Set<Integer>> map;

        public int orderOfLargestPlusSign(int n, int[][] mines) {
            map = new HashMap<>();
            for (int[] mine : mines) {
                if (!map.containsKey(mine[0])) {
                    Set<Integer> set = new HashSet<>();
                    set.add(mine[1]);
                    map.put(mine[0], set);
                } else {
                    map.get(mine[0]).add(mine[1]);
                }
            }
            int[][] dp = new int[n][n];
            for (int[] nums : dp) {
                Arrays.fill(nums, n);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int count = 0;
                // left
                for (int j = 0; j < n; j++) {
                    if (isBan(i, j)) {
                        count = 0;
                    } else {
                        count++;
                    }
                    dp[i][j] = Math.min(dp[i][j], count);
                }
                count = 0;
                // right
                for (int j = n - 1; j >= 0; j--) {
                    if (isBan(i, j)) {
                        count = 0;
                    } else {
                        count++;
                    }
                    dp[i][j] = Math.min(dp[i][j], count);
                }

                // 放在这里是错误的
//                count = 0;
//                // up
//                for (int j = 0; j < n; j++) {
//                    if (isBan(j, i)) {
//                        count = 0;
//                    } else {
//                        count++;
//                    }
//                    dp[j][i] = Math.min(dp[j][i], count);
//                }
//                count = 0;
//                // down
//                for (int j = n - 1; j >= 0; j--) {
//                    if (isBan(j, i)) {
//                        count = 0;
//                    } else {
//                        count++;
//                    }
//                    dp[j][i] = Math.min(dp[j][i], count);
//                    ans = Math.max(ans, dp[j][i]);
//                }
            }
            for (int i = 0; i < n; i++) {
                int count = 0;
                // up
                for (int j = 0; j < n; j++) {
                    if (isBan(j, i)) {
                        count = 0;
                    } else {
                        count++;
                    }
                    dp[j][i] = Math.min(dp[j][i], count);
                }
                count = 0;
                // down
                for (int j = n - 1; j >= 0; j--) {
                    if (isBan(j, i)) {
                        count = 0;
                    } else {
                        count++;
                    }
                    dp[j][i] = Math.min(dp[j][i], count);
                    ans = Math.max(ans, dp[j][i]);
                }
            }
            return ans;
        }

        private boolean isBan(int x, int y) {
            return map.containsKey(x) && map.get(x).contains(y);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] mines = {{4, 2}};
        System.out.println(new Solution().orderOfLargestPlusSign(n, mines));
    }
}
