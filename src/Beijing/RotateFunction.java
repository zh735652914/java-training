package Beijing;
/*
https://leetcode-cn.com/problems/rotate-function/
 */

public class RotateFunction {
    // 递推公式能想出来就行
    static class Solution {
        public int maxRotateFunction(int[] nums) {
            int last = 0, sum = 0;
            for (int i = 0; i < nums.length; i++) {
                last += i * nums[i];
                sum += nums[i];
            }
            int ans = last;
            int cur = 0;
            for (int i = 1; i < nums.length; i++) {
                cur = last + sum - nums.length * nums[nums.length - i];
                ans = Math.max(ans, cur);
                last = cur;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 6};
        System.out.println(new Solution().maxRotateFunction(nums));
    }
}
