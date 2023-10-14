package beijing;
/*
https://leetcode.cn/problems/single-number/?envType=daily-question&envId=2023-10-14
 */

/**
 * @author zhouhao
 * @date 2023/10/14 12:20
 */
public class SingleNumber_136_HotOneHundred {
    static class Solution {
        public int singleNumber(int[] nums) {
            int ans = nums[0];
            for (int i = 1; i < nums.length; i++) {
                ans ^= nums[i];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(new Solution().singleNumber(nums));
    }
}
