package beijing;
/*
https://leetcode.cn/problems/jump-game/
 */

public class jumpGame_55_topInterviewList {
    // 第三次写，自己还是不会
    static class Solution {
        public boolean canJump(int[] nums) {
            int far = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i <= far) {
                    far = Math.max(far, nums[i] + i);
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
