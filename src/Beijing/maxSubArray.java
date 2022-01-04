package Beijing;

import java.util.Arrays;

/*
https://leetcode-cn.com/problems/maximum-subarray/
 */
public class maxSubArray {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int sum = 0, ans = nums[0];
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
