package Beijing;
/*
https://leetcode.cn/problems/maximum-product-subarray/
 */

public class maximumProductSubarray_152_topInterviewList {
    // 第三次了，自己还是不会写
    static class Solution {
        public int maxProduct(int[] nums) {
            int ans = nums[0], max = nums[0], min = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int lastMax = max, lastMin = min;
                max = Math.max(nums[i], Math.max(lastMin * nums[i], lastMax * nums[i]));
                min = Math.min(nums[i], Math.min(lastMin * nums[i], lastMax * nums[i]));
                ans = Math.max(ans, max);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-4, -3, -2};
        System.out.println(new Solution().maxProduct(nums));
    }
}
