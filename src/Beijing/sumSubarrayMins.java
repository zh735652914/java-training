package Beijing;
/*
https://leetcode.cn/problems/sum-of-subarray-minimums/
 */

import java.util.Stack;

public class sumSubarrayMins {
    // 不是自己写的
    static class Solution {
        public int sumSubarrayMins(int[] arr) {
            /*
            dp[i]=dp[i−k]+k×arr[i]  // dp[i]是0到i的最小值
             */
            Stack<Integer> stack = new Stack<>();
            final int mod = 1000000007;
            long ans = 0;
            int[] dp = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
                int k = stack.isEmpty() ? (i + 1) : (i - stack.peek());
                dp[i] = k * arr[i] + (stack.isEmpty() ? 0 : dp[i - k]);
                ans = (ans + dp[i]) % mod;
                stack.push(i);
            }
            return (int) ans;
        }
    }

    // 自己写的效率不高
    static class Solution0 {
        public int sumSubarrayMins(int[] arr) {
            int[] dp = new int[arr.length];
            dp[arr.length - 1] = arr[arr.length - 1];
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] >= arr[i + 1]) {
                    dp[i] = arr[i] + dp[i + 1];
                } else {
                    int right = i + 1;
                    while (right < arr.length && arr[i] < arr[right]) {
                        right++;
                    }
                    if (right >= arr.length) {
                        dp[i] = (arr.length - i) * arr[i];
                    } else {
                        dp[i] = (right - i) * arr[i] + dp[right];
                    }
                }
                if (dp[i] >= 1000000007) {
                    dp[i] %= 1000000007;
                }
            }
            int sum = 0;
            for (int num : dp) {
                sum += num;
                if (sum >= 1000000007) {
                    sum %= 1000000007;
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};// 6,3,4,4
        System.out.println(new Solution().sumSubarrayMins(arr));
    }
}
