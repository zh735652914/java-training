package beijing;
/*
https://leetcode-cn.com/problems/subarray-product-less-than-k/
 */

// 自己不会，看的解析也不是太明白，还要再看看
public class numSubarrayProductLessThanK {
    static class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int sum = 1, count = 0;
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                sum *= nums[right];
                while (left <= right && sum >= k) {
                    sum /= nums[left++];
                }
                count += right - left + 1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {10, 5, 2, 6};
//        int k = 100;
        int[] nums = {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        int k = 19;
        System.out.println(new Solution().numSubarrayProductLessThanK(nums, k));
    }
}
