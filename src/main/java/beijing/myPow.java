package beijing;
/*
https://leetcode-cn.com/problems/powx-n/
 */

public class myPow {
    static class Solution {
        // 别人写的
        public double myPow(double x, int n) {
            double ans = 1;
            for (int i = n; i != 0; i /= 2) {
                if (i % 2 != 0) {
                    ans *= x;
                }
                x *= x;
            }
            return n < 0 ? 1 / ans : ans;
        }

        // 自己写的
        public double myPow0(double x, int n) {
            if (n == 0) {
                return 1;
            }
            boolean flag = n > 0;
            n = Math.abs(n);
            return flag ? backtrack(x, n) : 1 / backtrack(x, n);
        }

        private double backtrack(double x, int n) {
            if (n == 0) {
                return 1;
            }
            double next = backtrack(x, n / 2);
            return n % 2 == 0 ? next * next : next * next * x;
        }
    }

    public static void main(String[] args) {
        double x = 2.10000;
        int n = 3;
        System.out.println(new Solution().myPow(x, n));
    }
}
