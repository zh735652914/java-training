package Beijing;
/*
https://leetcode-cn.com/problems/single-number-iii/
 */

public class singleNumberIII {
    // 自己不会，感觉自己是个傻逼
    static class Solution {
        public int[] singleNumber(int[] nums) {
            /*
            011
            101

            110
             */
            int result = 0;
            for (int num : nums) {
                result = result ^ num;
            }
            int x = 0, y = 0, count = 1;
            while ((result & 1) == 0) {
                result >>= 1;
                count <<= 1;
            }
            for (int num : nums) {
                if ((num & count) == 0) {
                    x ^= num;
                } else {
                    y ^= num;
                }
            }
            return new int[]{x, y};
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] ans = new Solution().singleNumber(nums);
        for (int x : ans) {
            System.out.println(x + ", ");
        }
    }
}
