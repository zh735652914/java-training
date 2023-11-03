package beijing;
/*
https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
 */

public class hasAlternatingBits {
    // 官方的位运算还是快
    static class Solution {
        public boolean hasAlternatingBits(int n) {
            int x = n ^ (n >> 1);
            return (x & (x + 1)) == 0;
        }
    }

    static class Solution0 {
        public boolean hasAlternatingBits(int n) {
            boolean isOdd = n % 2 == 1;
            n >>= 1;
            while (n > 0) {
                if (isOdd == (n % 2 == 1)) {
                    return false;
                }
                isOdd = !isOdd;
                n >>= 1;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Solution().hasAlternatingBits(n));
    }
}
