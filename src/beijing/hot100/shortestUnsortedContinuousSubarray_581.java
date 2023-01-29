package beijing.hot100;
/*
https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/
 */

// 第二次了，还是不会写
public class shortestUnsortedContinuousSubarray_581 {
    static class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int left = -1, right = -1;
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (max > nums[i]) {
                    right = i;
                } else {
                    max = nums[i];
                }
                if (min < nums[nums.length - 1 - i]) {
                    left = nums.length - 1 - i;
                } else {
                    min = nums[nums.length - 1 - i];
                }
            }
            return right == -1 ? 0 : right - left + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(new Solution().findUnsortedSubarray(nums));
    }
}
