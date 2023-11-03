package leetcode;

/*
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
class PowXNSolution {
    double[][] H = new double[32][2];

    public double myPow(double x, int n) {
        double ans = 1;
//        double[] H = new double[32];
        H[0][0] = 1;
        H[0][1] = x;
        for (int i = 1; i < 32; i++) {
            H[i][0] = 2 * H[i - 1][0];
            H[i][1] = H[i - 1][1] * H[i - 1][1];
        }
        int flag = 0;
        if (n == Integer.MIN_VALUE) {
            flag = 1;
            n = n + 1;
        }
        int m = Math.abs(n);
        ans = backtrack(x, m, ans);
        if (flag == 1) ans *= x;
        if (n < 0) return 1 / ans;
        return ans;
    }

    private double backtrack(double x, int m, double ans) {
        if (m < 1) return ans;
        int p = 0;
        for (int i = 0; i < 32; i++) {
            if (H[i][0] == m) {
                p = i;
                break;
            }
            if (H[i][0] > m) {
                p = i - 1;
                break;
            }
        }
        ans *= H[p][1];
        return backtrack(x, m - (int) H[p][0], ans);
    }
}

public class PowXN {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2147483648;
        PowXNSolution PXN = new PowXNSolution();
        System.out.println(PXN.myPow(x, n));
    }
}
