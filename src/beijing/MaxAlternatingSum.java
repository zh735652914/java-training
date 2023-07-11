package beijing;
/*
https://leetcode.cn/problems/maximum-alternating-subsequence-sum/
 */

/**
 * @author zhouhao
 * @date 2023/7/11 11:03
 */
public class MaxAlternatingSum {
    // 这题自己一点思路都没有
    static class Solution {
        public long maxAlternatingSum(int[] nums) {
            long even = nums[0], odd = 0;
            for (int i = 1; i < nums.length; i++) {
                even = Math.max(even, odd + nums[i]);
                odd = Math.max(odd, even - nums[i]);
            }
            return even;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 3};
        System.out.println(new Solution().maxAlternatingSum(nums));
    }
}
