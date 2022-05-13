package Beijing;
/*
https://leetcode.cn/problems/missing-number/
 */

// 很简单的简单题
public class missingNumber {
    static class Solution {
        public int missingNumber(int[] nums) {
            int target = nums.length * (nums.length + 1) / 2;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return target - sum;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(new Solution().missingNumber(nums));
    }
}
