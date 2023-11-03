package beijing;
/*
https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/
 */

import java.util.Arrays;

// 【重要】这题自己不会写，需要认真多看看。
public class canPartitionKSubsets {
    static class Solution {
        private int[] nums;
        private int target;
        boolean[] dp;

        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            target = sum / k;
            if (target * k != sum) {
                return false;
            }
            this.nums = nums;
            Arrays.sort(nums);
            if (nums[nums.length - 1] > target) {
                return false;
            }
            dp = new boolean[1 << nums.length];
            Arrays.fill(dp, true);
            return dfs((1 << nums.length) - 1, 0);
        }

        private boolean dfs(int s, int sum) {
            if (s == 0) {
                return true;
            }
            if (!dp[s]) {
                return dp[s];
            }
            dp[s] = false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] + sum > target) {
                    return false;
                }
                if (((s >> i) & 1) != 0) {
                    if (dfs(s ^ (1 << i), (sum + nums[i]) % target)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(new Solution().canPartitionKSubsets(nums, k));
    }
}
