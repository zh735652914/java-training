package Beijing;
/*
https://leetcode-cn.com/problems/valid-palindrome/
 */

// 这题很简单
public class ValidPalindrome {
    static class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            int n = s.length();
            int L = 0, R = n - 1;
            while (L < n && R >= 0) {
                if (!isValid(s.charAt(L))) {
                    L++;
                    continue;
                }
                if (!isValid(s.charAt(R))) {
                    R--;
                    continue;
                }
                if (s.charAt(L) != s.charAt(R)) {
                    return false;
                }
                L++;
                R--;
            }
            return true;
        }

        private boolean isValid(char x) {
            return (x >= 'a' && x <= 'z') || (x >= '0' && x <= '9');
        }
    }

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "0P";
        System.out.println(new Solution().isPalindrome(s));
    }
}
