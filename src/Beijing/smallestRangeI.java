package Beijing;
/*
https://leetcode-cn.com/problems/smallest-range-i/
 */

// 简单题，自己没想到思路
public class smallestRangeI {
    static class Solution {
        public int smallestRangeI(int[] nums, int k) {
            if (nums.length == 1) {
                return 0;
            }
            int max = nums[0], min = nums[0];
            for (int x : nums) {
                max = Math.max(x, max);
                min = Math.min(x, min);
            }
            return max - min <= 2 * k ? 0 : max - min - 2 * k;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 10};
        int k = 4;
        System.out.println(new Solution().smallestRangeI(nums, k));
    }
}
