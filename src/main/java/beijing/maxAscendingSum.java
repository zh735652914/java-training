package beijing;
/*
https://leetcode.cn/problems/maximum-ascending-subarray-sum/
 */

public class maxAscendingSum {
    // 的确是简单题
    static class Solution {
        public int maxAscendingSum(int[] nums) {
            int ans = nums[0];
            int sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    sum += nums[i];
                    ans = Math.max(ans, sum);
                } else {
                    sum = nums[i];
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 5, 10, 50};
        System.out.println(new Solution().maxAscendingSum(nums));
    }
}
