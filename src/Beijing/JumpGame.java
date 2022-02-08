package Beijing;
/*
https://leetcode-cn.com/problems/jump-game/
 */

public class JumpGame {
    static class Solution {
        public boolean canJump(int[] nums) {
            int maxFar = 0;
            for (int i = 0; i < nums.length; i++) {
                // 在上一次跳跃的最远范围内，才开始下一次起跳
                if (i <= maxFar) {
                    maxFar = Math.max(maxFar, i + nums[i]);
                    if (maxFar >= nums.length - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(new Solution().canJump(nums));
    }
}
