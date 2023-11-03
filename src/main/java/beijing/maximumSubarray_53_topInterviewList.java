package beijing;
/*
https://leetcode.cn/problems/maximum-subarray/
 */

public class maximumSubarray_53_topInterviewList {
    // 第四次了，自己还是不会写
    static class Solution {
        public int maxSubArray(int[] nums) {
            int ans = nums[0];
            int sum = 0;
            for (int num : nums) {
                sum = Math.max(sum + num, num);
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
