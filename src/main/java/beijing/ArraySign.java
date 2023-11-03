package beijing;
/*
https://leetcode.cn/problems/sign-of-the-product-of-an-array/
 */

public class ArraySign {
    // 自己想复杂了
    static class Solution {
        public int arraySign(int[] nums) {
            boolean negative = false;
            for (int num : nums) {
                if (num == 0) {
                    return 0;
                }
                if (num < 0) {
                    negative = !negative;
                }
            }
            return negative ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, 3, 2, 1};
        System.out.println(new Solution().arraySign(nums));
    }
}
