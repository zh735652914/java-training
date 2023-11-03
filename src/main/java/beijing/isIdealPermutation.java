package beijing;
/*
https://leetcode.cn/problems/global-and-local-inversions/
 */

public class isIdealPermutation {
    // 看了解析才写出来
    static class Solution {
        public boolean isIdealPermutation(int[] nums) {
            int min = nums[nums.length - 1];
            for (int i = nums.length - 3; i >= 0; i--) {
                if (nums[i] > min) {
                    return false;
                }
                min = Math.min(min, nums[i + 1]);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 2};
        System.out.println(new Solution().isIdealPermutation(nums));
    }
}
