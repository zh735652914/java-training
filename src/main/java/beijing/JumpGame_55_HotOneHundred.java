package beijing;
/*
https://leetcode.cn/problems/jump-game/
 */

/**
 * @author zhouhao
 * @date 2023/6/24 17:04
 */
public class JumpGame_55_HotOneHundred {
    // 要背
    static class Solution {
        public boolean canJump(int[] nums) {
            int far = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i <= far) {
                    far = Math.max(far, i + nums[i]);
                    if (far >= nums.length - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new Solution().canJump(nums));
    }
}
