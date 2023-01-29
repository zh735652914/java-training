package beijing;
/*
https://leetcode-cn.com/problems/strong-password-checker/
 */

public class strongPasswordChecker {
    static class Solution {
        public int strongPasswordChecker(String password) {
            /*
            不会，真的太难了


             */
            if (password.length() <= 4) {
                return 6 - password.length();
            }
            boolean hasDigit = false;
            boolean hasUpperCase = false;
            boolean hasLowerCase = false;
            for (int i = 0; i < password.length(); i++) {
                char x = password.charAt(i);
                if (x >= 'a' && x <= 'z') {
                    hasLowerCase = true;
                } else if (x >= 'A' && x <= 'Z') {
                    hasUpperCase = true;
                } else if (x >= '1' && x <= '9') {
                    hasDigit = true;
                }
            }
            if (hasDigit && hasUpperCase && hasLowerCase) {
                if (password.length() >= 6 && password.length() <= 20) {
                    return 0;
                } else if (password.length() > 20) {
                    return password.length() - 20;
                } else {
                    return 6 - password.length();
                }
            }
            int count = 0;
            if (hasDigit) {
                count++;
            }
            if (hasLowerCase) {
                count++;
            }
            if (hasUpperCase) {
                count++;
            }
            int afterLen = Math.abs(password.length() - 6) < Math.abs(password.length() - 20) ? 6 : 20;
            if (count == 0) {
                return 6;
            } else {
                int changeLen = afterLen - password.length();
                int changeCh = 3 - count;
                return changeLen > 0 ? changeLen + changeLen - (3 - count) : -changeLen + changeCh;
            }
        }
    }

    public static void main(String[] args) {
        String password = "aaa111";
        System.out.println(new Solution().strongPasswordChecker(password));
    }
}
