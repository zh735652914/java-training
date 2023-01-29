package beijing;
/*
https://leetcode-cn.com/problems/remove-palindromic-subsequences/
 */

public class removePalindromeSub {

    // 纯粹是脑筋急转弯
    static class Solution {
        public int removePalindromeSub(String s) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    return 2;
                }
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        String s = "baabb";
        System.out.println(new Solution().removePalindromeSub(s));
    }
}
