package leetcode;
/*
Given a non-empty array containing only positive integers,
find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.


Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].


Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 */

//0-1背包问题，一开始自己不会写，只知道是用dp。。。

class PartitionEqualSubsetSumSolution {
    public boolean canPartition(int[] nums) {
        if (nums.length < 1) return false;
        int Nsum = 0;
        for (int x : nums) {
            Nsum += x;
        }
        if (Nsum % 2 == 1) return false;
        int target = Nsum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int x : nums) {
            dp[1][0] = true;
        }
        for (int i = 2; i < nums.length + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                dp[i][j] = j >= nums[i - 1] ? (dp[i - 1][j - nums[i - 1]] || dp[i - 1][j]) : dp[i - 1][j];
            }
        }
        return dp[nums.length][target];
    }
}

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
//        int[] nums = {1, 5, 11, 5};
        int[] nums = {1, 2, 3, 5};
//        int[] nums = {1, 2, 5};
        System.out.println(new PartitionEqualSubsetSumSolution().canPartition(nums));
    }
}
