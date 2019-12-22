package LeetCode;

/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.

 */

//不会写。。。感觉自己智商不在线！！！！！！！！！！！！！！！！
class TargetSumSolution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if (sum < S || (sum + S) % 2 == 1) return 0;
        return find(nums, (sum + S) / 2);
    }

    private int find(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int x : nums) {
            for (int i = target; i >= x; i--) {
                dp[i] += dp[i - x];
            }
        }
        return dp[target];
    }

    public int find2(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }
}

public class TargetSum {
    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 1, 1};
//        int S = 3;
        int[] nums = {1};
        int S = 2;
        System.out.println(new TargetSumSolution().findTargetSumWays(nums, S));
    }
}
