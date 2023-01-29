package beijing;
/*
https://leetcode.cn/problems/single-number/
 */

public class singleNumber_136 {
    // 第三次写了
    static class Solution {
        public int singleNumber(int[] nums) {
            int ans = nums[0];
            for (int i = 1; i < nums.length; i++) {
                ans ^= nums[i];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(new Solution().singleNumber(nums));
    }
}
