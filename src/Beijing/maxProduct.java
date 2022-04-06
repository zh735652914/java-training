package Beijing;
/*
https://leetcode-cn.com/problems/maximum-product-subarray/
 */

public class maxProduct {
    // 这个需要看看，dp的滚动数组，自己没写出来
    static class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int MAX = nums[0], MIN = nums[0];
            int ans = nums[0];
            for (int i = 1; i < n; i++) {
                int lastMAX = MAX, lastMIN = MIN;
                MAX = Math.max(lastMAX * nums[i], Math.max(lastMIN * nums[i], nums[i]));
                MIN = Math.min(lastMAX * nums[i], Math.min(lastMIN * nums[i], nums[i]));
                ans = Math.max(ans, MAX);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 3, -4};
        System.out.println(new Solution().maxProduct(nums));
    }
}
