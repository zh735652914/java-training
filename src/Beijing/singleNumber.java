package Beijing;
/*
https://leetcode-cn.com/problems/single-number/
 */

// 位运算！自己没想到
public class singleNumber {
    static class Solution {
        public int singleNumber(int[] nums) {
            // 【不需要额外空间的方法，就往位运算上想】
            int ans = 0;
            for (int num : nums) {
                ans ^= num;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(new Solution().singleNumber(nums));
    }
}
