package Beijing.hot100;
/*
https://leetcode.cn/problems/product-of-array-except-self/
 */

// 第二次写还是不会，这个智力题还是要多回忆一下
public class productofArrayExceptSelf_238 {
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] lToR = new int[nums.length];
            int[] rToL = new int[nums.length];
            int x = 1;
            for (int i = 0; i < nums.length; i++) {
                x *= nums[i];
                lToR[i] = x;
            }
            x = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                x *= nums[i];
                rToL[i] = x;
            }
            int[] ans = new int[nums.length];
            ans[0] = rToL[1];
            ans[nums.length - 1] = lToR[nums.length - 2];
            for (int i = 1; i < nums.length - 1; i++) {
                ans[i] = lToR[i - 1] * rToL[i + 1];
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
