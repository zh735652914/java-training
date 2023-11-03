package beijing;

/*
https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class longestPalindrome {
    static class Solution {
        private int maxLen;

        public String longestPalindrome(String s) {
            maxLen = 0;
            String ans = "";
            for (int i = 0; i < s.length(); i++) {
                String t1 = expend(s, i, i);
                String t2 = expend(s, i, i + 1);
                if (ans.length() < Math.max(t1.length(), t2.length())) {
                    ans = (t1.length() > t2.length() ? t1 : t2);
                }
            }
            return ans;
        }

        private String expend(String s, int left, int right) {
            String ans = "";
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }
            left++;
            right--;
            if (maxLen < (right - left + 1)) {
                maxLen = right - left + 1;
                ans = s.substring(left, right + 1);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(new Solution().longestPalindrome(s));
    }
}
