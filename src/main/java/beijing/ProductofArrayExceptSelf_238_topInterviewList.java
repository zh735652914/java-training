package beijing;
/*
https://leetcode.cn/problems/product-of-array-except-self/
 */

public class ProductofArrayExceptSelf_238_topInterviewList {
    // 这题不难
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] LtR = new int[nums.length];
            int[] RtL = new int[nums.length];
            int left = 1, right = 1;
            for (int i = 0; i < nums.length; i++) {
                LtR[i] = left;
                left *= nums[i];
                RtL[nums.length - 1 - i] = right;
                right *= nums[nums.length - 1 - i];
            }
            int[] ans = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                ans[i] = LtR[i] * RtL[i];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ans = new Solution().productExceptSelf(nums);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
