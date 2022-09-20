package Beijing;
/*
https://leetcode.cn/problems/jump-game-ii/
 */

public class jumpGameII_45_topInterviewList {
    // 自己还是不会写啊
    static class Solution {
        public int jump(int[] nums) {
            int count = 0;
            int far = 0;
            int end = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                far = Math.max(far, i + nums[i]);
                if (i == end) {
                    end = far;
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
