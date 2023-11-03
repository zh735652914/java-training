package beijing.hot100;
/*
https://leetcode.cn/problems/maximum-product-subarray/
 */

// 第二次写还是不会
public class maximumProductSubarray_152 {
    static class Solution {
        public int maxProduct(int[] nums) {
            int max = nums[0], min = nums[0], ans = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int lastMax = max, lastMin = min;
                max = Math.max(nums[i], Math.max(lastMax * nums[i], lastMin * nums[i]));
                min = Math.min(nums[i], Math.min(lastMax * nums[i], lastMin * nums[i]));
                ans = Math.max(ans, max);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(new Solution().maxProduct(nums));
    }
}
