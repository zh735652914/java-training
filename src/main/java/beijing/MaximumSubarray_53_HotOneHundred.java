package beijing;
/*
https://leetcode.cn/problems/maximum-subarray/
 */

/**
 * @author zhouhao
 * @date 2023/6/12 12:43
 */
public class MaximumSubarray_53_HotOneHundred {
    // 第五次了，自己还是不会
    static class Solution {
        public int maxSubArray(int[] nums) {
            int sum = 0, ans = Integer.MIN_VALUE;
            for (int num : nums) {
                sum = Math.max(sum + num, num);
                ans = Math.max(sum, ans);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
    }
}
