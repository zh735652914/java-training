package beijing;
/*
https://leetcode-cn.com/problems/base-7/
 */

public class convertToBase7 {
    // 进制转化记得就行
    static class Solution {
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }
            boolean negative = num < 0;
            StringBuilder ans = new StringBuilder();
            num = Math.abs(num);
            while (num > 0) {
                ans.append(num % 7);
                num /= 7;
            }
            if (negative) {
                ans.append('-');
            }
            return ans.reverse().toString();
        }
    }

    public static void main(String[] args) {
        int num = 100;
        System.out.println(new Solution().convertToBase7(num));
    }
}
