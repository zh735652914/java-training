package Beijing.hot100;
/*
https://leetcode.cn/problems/jump-game/
 */

// 第二次写，自己还是没想出来，这要是面试就完犊子
public class jumpGame_55 {
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
