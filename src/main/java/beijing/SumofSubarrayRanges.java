package beijing;
/*
https://leetcode-cn.com/problems/sum-of-subarray-ranges/
 */

public class SumofSubarrayRanges {
    static class Solution {
        public long subArrayRanges(int[] nums) {
            long ans = 0;
            for (int i = 0; i < nums.length; i++) {
                // 只能在这里定义，因为每次变换子序列开始，最大和最小值都不一样
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int j = i; j < nums.length; j++) {
                    max = Math.max(max, nums[j]);
                    min = Math.min(min, nums[j]);
                    ans += max - min;
                }
            }
            return ans;
        }
    }

    // 自己写的效率不高
    static class Solution0 {
        public long subArrayRanges(int[] nums) {
            long ans = 0;
            int[][] max = new int[nums.length][nums.length];
            int[][] min = new int[nums.length][nums.length];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    if (i == j) {
                        max[i][j] = nums[i];
                        min[i][j] = nums[i];
                        continue;
                    }
                    max[i][j] = Math.max(max[i][j - 1], nums[j]);
                    min[i][j] = Math.min(min[i][j - 1], nums[j]);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    ans += max[i][j] - min[i][j];
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, -2, -3, 4, 1};
        System.out.println(new Solution().subArrayRanges(nums));
    }
}
