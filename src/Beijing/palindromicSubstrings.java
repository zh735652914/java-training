package Beijing;
/*
https://leetcode.cn/problems/palindromic-substrings/
 */

public class palindromicSubstrings {
    // 自己写的
    static class Solution {
        public int countSubstrings(String s) {
            int ans = 0;
            int n = s.length();
            for (int i = 0; i < n; i++) {
                ans += isPalindromic(i, i, s);
                ans += isPalindromic(i, i + 1, s);
            }
            return ans;
        }

        private int isPalindromic(int left, int right, String s) {
            int count = 0;
            int n = s.length();
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new Solution().countSubstrings(s));
    }
}
