package beijing.hot100;
/*
https://leetcode.cn/problems/maximum-subarray/
 */

// 第二次写，我自己还是没思路
public class maximumSubarray_53 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int ans = nums[0], sum = 0;
            for (int num : nums) {
                if (sum > 0) {
                    sum += num;
                } else {
                    sum = num;
                }
                ans = Math.max(ans, sum);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
    }
}
