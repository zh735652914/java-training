package Beijing;
/*
https://leetcode.cn/problems/strong-password-checker-ii/
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhouhao
 * @date 2023/1/19 16:00
 */
// 很简单
public class StrongPasswordCheckerII {
    static class Solution {
        public boolean strongPasswordCheckerII(String password) {
            if (password.length() < 8) {
                return false;
            }
            Set<Character> specials = new HashSet<Character>() {{
                add('!');
                add('@');
                add('#');
                add('$');
                add('%');
                add('^');
                add('&');
                add('*');
                add('(');
                add(')');
                add('-');
                add('+');
            }};
            int len = password.length();
            boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
            for (int i = 0; i < len; i++) {
                if (i != len - 1 && password.charAt(i) == password.charAt(i + 1)) {
                    return false;
                }
                char ch = password.charAt(i);
                if (Character.isLowerCase(ch)) {
                    hasLower = true;
                } else if (Character.isUpperCase(ch)) {
                    hasUpper = true;
                } else if (Character.isDigit(ch)) {
                    hasDigit = true;
                } else if (specials.contains(ch)) {
                    hasSpecial = true;
                }
            }
            return hasLower && hasUpper && hasDigit && hasSpecial;
        }
    }

    public static void main(String[] args) {
        String password = "IloveLe3tcode!";
        System.out.println(new Solution().strongPasswordCheckerII(password));
    }
}
