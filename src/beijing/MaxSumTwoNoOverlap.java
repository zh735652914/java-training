package beijing;
/*
https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays/
 */

/**
 * @author zhouhao
 * @date 2023/4/26 12:52
 */
// 有难度，自己不会
public class MaxSumTwoNoOverlap {
    static class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            /*
            dp[i] 为 nums[0,i+1] 中长度为 firstLen 的最大子数组和
             */
            return Math.max(help(nums, firstLen, secondLen), help(nums, secondLen, firstLen));
        }

        private int help(int[] nums, int leftLen, int rightLen) {
            int sumL = 0, sumR = 0, maxSum = 0;
            for (int i = 0; i < leftLen; i++) {
                sumL += nums[i];
            }
            for (int i = leftLen; i < leftLen + rightLen; i++) {
                sumR += nums[i];
            }
            maxSum = sumL + sumR;
            int maxLeft = sumL;
            for (int i = leftLen, j = leftLen + rightLen; i < nums.length && j < nums.length; i++, j++) {
                sumL += nums[i] - nums[i - leftLen];// 左边的子数组每次都向右移动，但是记录最大的值；
                maxLeft = Math.max(sumL, maxLeft);
                sumR += nums[j] - nums[j - rightLen];// 右边的子数组必须右移
                maxSum = Math.max(maxSum, maxLeft + sumR);// maxSum实际上包含了右边子数组的最大值
            }
            return maxSum;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        int firstLen = 1, secondLen = 2;
        System.out.println(new Solution().maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }
}
