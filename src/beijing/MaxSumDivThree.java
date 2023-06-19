package beijing;
/*
https://leetcode.cn/problems/greatest-sum-divisible-by-three/
 */

/**
 * @author zhouhao
 * @date 2023/6/19 12:55
 */
public class MaxSumDivThree {
    // 这题dp有点难度
    static class Solution {
        public int maxSumDivThree(int[] nums) {
            /*
            dp[0] 表示余数为0时的最大和，dp[1]表示余数为1的最大和，dp[0]表示余数为2时的最大和
             */
            int[] dp = new int[3];
            dp[1] = Integer.MIN_VALUE;
            dp[2] = Integer.MIN_VALUE;
            for (int num : nums) {
                int[] next = new int[3];
                System.arraycopy(dp, 0, next, 0, 3);
                for (int i = 0; i < 3; i++) {
                    int x = (i + num % 3) % 3;
                    next[x] = Math.max(next[x], dp[i] + num);
                }
                dp = next;
            }
            return dp[0];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 2, 2, 7};
        System.out.println(new Solution().maxSumDivThree(nums));
    }
}
