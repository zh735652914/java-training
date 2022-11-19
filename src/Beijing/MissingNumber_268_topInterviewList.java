package Beijing;
/*
https://leetcode.cn/problems/missing-number/
 */

public class MissingNumber_268_topInterviewList {
    // 的确很简单
    static class Solution {
        public int missingNumber(int[] nums) {
            int target = (1 + nums.length) * nums.length / 2;
            for (int num : nums) {
                target -= num;
            }
            return target;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(new Solution().missingNumber(nums));
    }
}
