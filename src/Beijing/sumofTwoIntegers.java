package Beijing;
/*
https://leetcode.cn/problems/sum-of-two-integers/
 */

// 自己没写出来，牢记：得到进位：(a & b) << 1;  不进位加：a ^ b;
public class sumofTwoIntegers {
    static class Solution {
        public int getSum(int a, int b) {
            int carry = 0;
            while (b != 0) {
                carry = (a & b) << 1;
                a = a ^ b;
                b = carry;
            }
            return a;
        }
    }

    public static void main(String[] args) {
        int a = 1, b = 2;
        System.out.println(new Solution().getSum(a, b));
    }
}
