package Beijing;
/*
https://leetcode-cn.com/problems/product-of-array-except-self/
 */

public class productExceptSelf {
    // 智力题，看了评论说的思路才会
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] LtoR = new int[n], RtoL = new int[n];
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    LtoR[i] = nums[i];
                    RtoL[n - 1] = nums[n - 1];
                } else {
                    LtoR[i] = LtoR[i - 1] * nums[i];
                    RtoL[n - 1 - i] = RtoL[n - i] * nums[n - i - 1];
                }
            }
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    ans[0] = RtoL[1];
                } else if (i == n - 1) {
                    ans[i] = LtoR[i - 1];
                } else {
                    ans[i] = LtoR[i - 1] * RtoL[i + 1];
                }
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
