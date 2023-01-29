package beijing;
/*
https://leetcode.cn/problems/reverse-integer/
 */

public class reverseInteger_7 {
    // 怎么说呢，还是要看看
    static class Solution {
        public int reverse(int x) {
            int n = 0;
            while (x != 0) {
                if (n < Integer.MIN_VALUE / 10 || n > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                n *= 10;
                n += x % 10;
                x /= 10;
            }
            return n;
        }
    }

    public static void main(String[] args) {
        int x = -123;
        System.out.println(new Solution().reverse(x));
    }
}
