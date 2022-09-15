package Beijing;
/*
https://leetcode.cn/problems/divide-two-integers/
 */

public class divideTwoIntegers_29_topInterviewList {
    static class Solution {
        // 位运算，自己没想到
        public int divide(int dividend, int divisor) {
            /*
            A=B*2^n;
            A/2^n=B
             */
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            boolean negative = (dividend ^ divisor) < 0;
            long A = Math.abs((long) dividend);
            long B = Math.abs((long) divisor);
            int ans = 0;
            for (int i = 32; i >= 0; i--) {
                if ((A >> i) >= B) {
                    ans += 1 << i;
                    A -= B << i;
                }
            }
            return negative ? -ans : ans;
        }
    }

    public static void main(String[] args) {
        int dividend = 7, divisor = -3;
        System.out.println(new Solution().divide(dividend, divisor));
    }
}
