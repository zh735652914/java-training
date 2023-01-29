package beijing;
/*
https://leetcode-cn.com/problems/divide-two-integers/submissions/
 */

public class divide {
    static class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == 0) {
                return 0;
            }
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            boolean negative = (dividend ^ divisor) < 0;
            long A = Math.abs((long) dividend);
            long B = Math.abs((long) divisor);
            int res = 0;
            for (int i = 31; i >= 0; i--) {
                if ((A >> i) >= B) {
                    res += 1 << i;
                    A -= B << i;
                }
            }
            return negative ? -res : res;
        }
    }

    public static void main(String[] args) {
        int dividend = 10, divisor = 3;
        System.out.println(new Solution().divide(dividend, divisor));
    }
}
