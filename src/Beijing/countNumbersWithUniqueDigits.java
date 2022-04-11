package Beijing;
/*
https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 */

public class countNumbersWithUniqueDigits {
    // 自己没写出来，没想到这个写法
    static class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return 10;
            }
            int cur = 9;
            int ans = 10;
            for (int i = 0; i < n - 1; i++) {
                cur *= 9 - i;
                ans += cur;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(new Solution().countNumbersWithUniqueDigits(n));
    }
}
