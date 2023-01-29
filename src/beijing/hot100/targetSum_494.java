package beijing.hot100;
/*
https://leetcode.cn/problems/target-sum/
 */

public class targetSum_494 {
    // 第二次这种方法还是不会
    static class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int diff = sum - target;
            if (diff < 0 || (diff & 1) == 1) {
                return 0;
            }
            diff >>= 1;
            int[][] dp = new int[nums.length + 1][diff + 1];
            dp[0][0] = 1;
            /*
            前i个数可以组成和为j的方案数dp[i][j]
            dp[i][j]=dp[i-1][j]  j<num[i]
            dp[i][j]=dp[i-1][j]+dp[i][j-num[i]]  j>=num[i]
             */
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 0; j <= diff; j++) {
                    if (j < nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            return dp[nums.length][diff];
        }
    }

    // 纯dfs有点慢
    static class Solution0 {
        private int count;

        public int findTargetSumWays(int[] nums, int target) {
            count = 0;
            dfs(nums, target, 0, 0);
            return count;
        }

        private void dfs(int[] nums, int target, int index, int sum) {
            if (index == nums.length && sum == target) {
                count++;
                return;
            }
            if (index >= nums.length) {
                return;
            }
            dfs(nums, target, index + 1, sum + nums[index]);
            dfs(nums, target, index + 1, sum - nums[index]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(new Solution().findTargetSumWays(nums, target));
    }
}
