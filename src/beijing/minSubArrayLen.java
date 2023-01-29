package beijing;
/*
https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */

public class minSubArrayLen {
    // 官方写的滑动窗口，比自己写的好多了
    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int ans = Integer.MAX_VALUE;
            int sum = 0, left = 0, right = 0, n = nums.length;
            while (right < n) {
                sum += nums[right];
                while (sum >= target) {
                    ans = Math.min(ans, right - left + 1);
                    sum -= nums[left];
                    left++;
                }
                right++;
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }

    // 自己写的滑动窗口
    static class Solution0 {
        public int minSubArrayLen(int target, int[] nums) {
            int ans = Integer.MAX_VALUE;
            int sum = 0, left = 0, right = 0, n = nums.length;
            while (right < n) {
                sum += nums[right];
                if (sum >= target) {
                    ans = Math.min(ans, right - left + 1);
                    sum = 0;
                    left++;
                    right = left;
                } else {
                    right++;
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(new Solution().minSubArrayLen(target, nums));
    }
}
