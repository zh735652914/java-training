package beijing.hot100;
/*
https://leetcode.cn/problems/find-the-duplicate-number/
 */

public class findtheDuplicateNumber_287 {
    // 第二次还是没想到，快慢指针的确很巧妙
    static class Solution {
        public int findDuplicate(int[] nums) {
            int faster = 0, slower = 0;
            while (true) {
                faster = nums[nums[faster]];
                slower = nums[slower];
                if (faster == slower) {
                    break;
                }
            }
            slower = 0;
            while (slower != faster) {
                slower = nums[slower];
                faster = nums[faster];
            }
            return slower;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(new Solution().findDuplicate(nums));
    }
}
