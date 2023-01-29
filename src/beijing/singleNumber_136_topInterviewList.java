package beijing;
/*
https://leetcode.cn/problems/single-number/
 */

public class singleNumber_136_topInterviewList {
    // 知道用位运算就很简单
    static class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int num : nums) {
                ans ^= num;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(new Solution().singleNumber(nums));
    }
}
