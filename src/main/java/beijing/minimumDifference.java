package beijing;
/*
https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 */

import java.util.Arrays;

public class minimumDifference {
    static class Solution {
        public int minimumDifference(int[] nums, int k) {
            Arrays.sort(nums);
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - k + 1; i++) {
                ans = Math.min(ans, nums[i + k - 1] - nums[i]);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {9};
        int k = 1;
        System.out.println(new Solution().minimumDifference(nums, k));
    }
}
