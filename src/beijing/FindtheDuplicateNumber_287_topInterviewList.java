package beijing;
/*
https://leetcode.cn/problems/find-the-duplicate-number/
 */

public class FindtheDuplicateNumber_287_topInterviewList {
    // 这个快慢指针的写法需要记下来
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
        int[] nums = {3, 1, 3, 4, 2};
        System.out.println(new Solution().findDuplicate(nums));
    }
}
