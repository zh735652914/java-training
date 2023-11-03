package nowcoder;
/*
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：4766
本题知识点： 分治 动态规划
 算法知识视频讲解
题目描述
给定一个数组arr，返回子数组的最大累加和
例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
[要求]
时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)

示例1
输入
复制
[1, -2, 3, 5, -2, 6, -1]
输出
复制
12
备注:
1 \leq N \leq 10^51≤N≤10
5

|arr_i| \leq 100∣arr
i
​
 ∣≤100
 */

public class maxsumofSubarray {
    static public class Solution {
        /**
         * max sum of the subarray
         *
         * @param arr int整型一维数组 the array
         * @return int整型
         */
        public int maxsumofSubarray(int[] arr) {
            int[] dp = new int[arr.length];
            dp[0] = arr[0];
            int max = dp[0];
            for (int i = 1; i < arr.length; i++) {
                dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 5, -2, 6, -1};
        System.out.println(new Solution().maxsumofSubarray(nums));
    }
}
