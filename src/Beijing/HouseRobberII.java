package Beijing;
/*
https://leetcode-cn.com/problems/house-robber-ii/
 */

public class HouseRobberII {
    // 官方的这个写法，我不太明白
    static class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
        }

        private int robRange(int[] nums, int start, int end) {
            int first = nums[start];
            int second = Math.max(nums[start], nums[start + 1]);
            for (int i = start + 2; i <= end; i++) {
                int tmp = second;
                second = Math.max(second, first + nums[i]);
                first = tmp;
            }
            return second;
        }
    }

    // 自己写的不太好
    static class Solution0 {
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int n = nums.length;
            int[][] dp0 = new int[n][2];
            int[][] dp1 = new int[n][2];
            dp1[0][1] = nums[0];
            for (int i = 1; i < n; i++) {
                dp0[i][0] = Math.max(dp0[i - 1][0], dp0[i - 1][1]);
                dp0[i][1] = dp0[i - 1][0] + nums[i];
                dp1[i][0] = Math.max(dp1[i - 1][0], dp1[i - 1][1]);
                dp1[i][1] = dp1[i - 1][0] + nums[i];
            }
            return Math.max(Math.max(dp0[n - 1][0], dp0[n - 1][1]), dp1[n - 1][0]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new Solution().rob(nums));
    }
}
