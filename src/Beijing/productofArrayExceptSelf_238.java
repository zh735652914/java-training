package Beijing;
/*
https://leetcode.cn/problems/product-of-array-except-self/
 */

// 第三次，终于自己会写了，但不是太顺手
public class productofArrayExceptSelf_238 {
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] LtR = new int[nums.length];
            int[] RtL = new int[nums.length];
            int left = 1, right = 1;
            for (int i = 0; i < nums.length; i++) {
                left *= nums[i];
                right *= nums[nums.length - 1 - i];
                LtR[i] = left;
                RtL[nums.length - 1 - i] = right;
            }
            int[] ans = new int[nums.length];
            for (int i = 0; i < ans.length; i++) {
                if (i == 0) {
                    ans[i] = RtL[i + 1];
                } else if (i == ans.length - 1) {
                    ans[i] = LtR[i - 1];
                } else {
                    ans[i] = LtR[i - 1] * RtL[i + 1];
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] ans = new Solution().productExceptSelf(nums);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
