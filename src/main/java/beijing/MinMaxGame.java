package beijing;
/*
https://leetcode.cn/problems/min-max-game/
 */

/**
 * @author zhouhao
 * @date 2023/1/15 12:57
 */
public class MinMaxGame {
    // 看懂题目就行
    static class Solution {
        public int minMaxGame(int[] nums) {
            int[] nextNums = new int[nums.length];
            int len = nums.length;
            while (len > 1) {
                for (int i = 0; i < len / 2; i++) {
                    nextNums[i] = (i & 1) == 0 ?
                            Math.min(nums[2 * i], nums[2 * i + 1]) : Math.max(nums[2 * i], nums[2 * i + 1]);
                }
                len /= 2;
                nums = nextNums;
            }
            return nums[0];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 4, 8, 2, 2};
        System.out.println(new Solution().minMaxGame(nums));
    }
}
