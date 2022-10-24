package Beijing;
/*
https://leetcode.cn/problems/partition-array-into-disjoint-intervals/
 */

public class PartitionDisjoint {
    // 题目不难
    static class Solution {
        public int partitionDisjoint(int[] nums) {
            int[] rightToLeftMin = new int[nums.length];
            int min = Integer.MAX_VALUE;
            for (int i = nums.length - 1; i >= 0; i--) {
                min = Math.min(min, nums[i]);
                rightToLeftMin[i] = min;
            }
            int max = Integer.MIN_VALUE;
            int[] leftToRightMax = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
                leftToRightMax[i] = max;
            }
            for (int i = 0; i < nums.length - 1; i++) {
                if (leftToRightMax[i] <= rightToLeftMin[i + 1]) {
                    return i + 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 0, 3, 8, 6};
        System.out.println(new Solution().partitionDisjoint(nums));
    }
}
