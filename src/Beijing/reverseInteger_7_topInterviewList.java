package Beijing;
/*
https://leetcode.cn/problems/reverse-integer/
 */

public class reverseInteger_7_topInterviewList {
    // 这种写法自己还是没想到
    static class Solution {
        public int reverse(int x) {
            int ans = 0;
            while (x != 0) {
                if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                ans *= 10;
                ans += x % 10;
                x /= 10;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int x = 123;
        System.out.println(new Solution().reverse(x));
    }
}
