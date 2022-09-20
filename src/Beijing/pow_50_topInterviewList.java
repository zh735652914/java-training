package Beijing;
/*
https://leetcode.cn/problems/powx-n/
 */

public class pow_50_topInterviewList {
    // 【重要】自己还是不会写
    static class Solution {
        public double myPow(double x, int n) {
            double ans = 1;
            for (int i = n; i != 0; i /= 2) {
                if ((i & 1) != 0) {
                    ans *= x;
                }
                x *= x;
            }
            return n > 0 ? ans : 1 / ans;
        }
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2;
        System.out.println(new Solution().myPow(x, n));
    }
}
