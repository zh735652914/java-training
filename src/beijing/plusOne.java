package beijing;
/*
https://leetcode-cn.com/problems/plus-one/
 */

public class plusOne {
    // 这题也没什么意思
    static class Solution {
        public int[] plusOne(int[] digits) {
            int index = digits.length - 1;
            int carry = 1;
            while (index >= 0 && carry > 0) {
                int sum = digits[index] + carry;
                digits[index] = sum % 10;
                carry = sum / 10;
                index--;
            }
            if (carry != 0) {
                int[] Ndigits = new int[digits.length + 1];
                System.arraycopy(digits, 0, Ndigits, 1, Ndigits.length - 1);
                Ndigits[0] = carry;
                return Ndigits;
            }
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] digits = {9};
        int[] ans = new Solution().plusOne(digits);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
