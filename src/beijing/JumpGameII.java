package beijing;
/*
https://leetcode-cn.com/problems/jump-game-ii/
 */

public class JumpGameII {
    static class Solution {
        // 牛逼，自己想不到
        public int jump(int[] nums) {
            int border = 0;
            int far = 0;
            int count = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                far = Math.max(far, i + nums[i]);
                if (i == border) {
                    border = far;
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new Solution().jump(nums));
    }
}
