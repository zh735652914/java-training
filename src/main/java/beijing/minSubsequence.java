package beijing;
/*
https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 看了评论才写出来
public class minSubsequence {
    static class Solution {
        public List<Integer> minSubsequence(int[] nums) {
            Arrays.sort(nums);
            int target = 0;
            for (int num : nums) {
                target += num;
            }
            target >>= 1;
            int sum = 0;
            List<Integer> ans = new ArrayList<>();
            for (int i = nums.length - 1; i >= 0; i--) {
                ans.add(nums[i]);
                sum += nums[i];
                if (sum > target) {
                    break;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 10, 9, 8};
        System.out.println(new Solution().minSubsequence(nums));
    }
}
