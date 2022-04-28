package Beijing;
/*
https://leetcode-cn.com/problems/ugly-number/
 */

public class UglyNumber {
    // 简单题
    static class Solution {
        public boolean isUgly(int n) {
            if (n == 0) {
                return false;
            }
            while ((n & 1) == 0) {
                n >>= 1;
            }
            while (n % 3 == 0) {
                n /= 3;
            }
            while (n % 5 == 0) {
                n /= 5;
            }
            return n == 1;
        }
    }

    public static void main(String[] args) {
        int n = 14;
        System.out.println(new Solution().isUgly(n));
    }
}
