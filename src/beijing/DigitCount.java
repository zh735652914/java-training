package beijing;
/*
https://leetcode.cn/problems/check-if-number-has-equal-digit-count-and-digit-value/
 */

/**
 * @author zhouhao
 * @date 2023/1/11 18:43
 */
// 的确很简单
public class DigitCount {
    static class Solution {
        public boolean digitCount(String num) {
            int[] count = new int[num.length()];
            for (int i = 0; i < num.length(); i++) {
                int x = num.charAt(i) - '0';
                if (x < count.length) {
                    count[x]++;
                }
            }
            for (int i = 0; i < num.length(); i++) {
                if (count[i] != (num.charAt(i) - '0')) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String num = "030";
        System.out.println(new Solution().digitCount(num));
    }
}
