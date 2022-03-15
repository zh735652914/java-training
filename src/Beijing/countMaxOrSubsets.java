package Beijing;
/*
https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/
 */


public class countMaxOrSubsets {
    // 妈的，感觉自己真傻逼
    static class Solution {
        private int MaxSum;
        private int count;

        public int countMaxOrSubsets(int[] nums) {
            MaxSum = Integer.MIN_VALUE;
            count = 0;
            dfs(nums, 0, 0);
            return count;
        }

        private void dfs(int[] nums, int val, int index) {
            if (index >= nums.length) {
                if (val == MaxSum) {
                    count++;
                } else if (val > MaxSum) {
                    MaxSum = val;
                    count = 1;
                }
                return;
            }
            dfs(nums, val, index + 1);
            dfs(nums, val | nums[index], index + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5};
        System.out.println(new Solution().countMaxOrSubsets(nums));
    }
}
