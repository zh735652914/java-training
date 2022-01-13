package Beijing;
/*
https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
 */

public class dominantIndex {
    static class Solution {
        public int dominantIndex(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }
            if (nums.length < 1) {
                return -1;
            }
            int max = 0, last = 0;
            for (int i = 1; i < nums.length; i++) {
                if (max == -1) {
                    if (nums[i] >= 2 * nums[last]) {
                        max = i;
                    }
                    continue;
                }
                if (nums[i] >= 2 * nums[max]) {
                    max = i;
                    continue;
                }
                if (nums[max] < 2 * nums[i]) {
                    last = nums[max] > nums[i] ? max : i;
                    max = -1;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new Solution().dominantIndex(nums));
    }
}
