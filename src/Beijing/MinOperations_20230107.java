package Beijing;
/*
https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/1/7 12:53
 */
public class MinOperations_20230107 {
    // 自己不会写
    static class Solution {
        public int minOperations(int[] nums, int x) {
            int left = -1, right = 0;
            int sum = Arrays.stream(nums).sum();
            if (sum < x) {
                return -1;
            }
            int lSum = 0, rSum = sum, ans = nums.length + 1;
            while (left < nums.length) {
                if (left != -1) {
                    lSum += nums[left];
                }
                while ((lSum + rSum) > x && right < nums.length) {
                    rSum -= nums[right++];
                }
                if (lSum + rSum == x) {
                    ans = Math.min(ans, (left + 1) + (nums.length - right));
                }
                left++;
            }
            return ans > nums.length ? -1 : ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;
        System.out.println(new Solution().minOperations(nums, x));
    }
}
