package beijing.hot100;
/*
https://leetcode.cn/problems/single-number/
 */

// 写过就很简单了
public class singleNumber_136 {
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
