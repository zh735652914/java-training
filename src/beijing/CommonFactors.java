package beijing;
/*
https://leetcode.cn/problems/number-of-common-factors/
 */

/**
 * @author zhouhao
 * @date 2023/4/5 12:57
 */
// gcd函数不会写
public class CommonFactors {
    static class Solution {
        public int commonFactors(int a, int b) {
            int c = gcd(a, b);
            int ans = 0;
            for (int i = 1; i * i <= c; i++) {
                if (c % i == 0) {
                    ans++;
                    if (i * i != c) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        private int gcd(int a, int b) {
            int remainder = a % b;
            while (remainder != 0) {
                a = b;
                b = remainder;
                remainder = a % b;
            }
            return b;
        }
    }

    public static void main(String[] args) {
        int a = 12, b = 6;
        System.out.println(new Solution().commonFactors(a, b));
    }
}
