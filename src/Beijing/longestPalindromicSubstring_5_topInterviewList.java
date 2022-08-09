package Beijing;
/*
https://leetcode.cn/problems/longest-palindromic-substring/
 */

// 第五次写了，还是不太会，这个写法可能都要背下来了
public class longestPalindromicSubstring_5_topInterviewList {
    static class Solution {
        private int start, end;

        public String longestPalindrome(String s) {
            start = 0;
            end = 0;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                i = expend(s, i, i);
            }
            return s.substring(start, end + 1);
        }

        private int expend(String s, int left, int right) {
            int len = s.length();
            while (right < len && s.charAt(left) == s.charAt(right)) {
                right++;
            }
            right--;
            int pos = right;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            if (right - left > end - start) {
                end = right;
                start = left;
            }
            return pos;
        }
    }

    public static void main(String[] args) {
        String s = "bb";
        System.out.println(new Solution().longestPalindrome(s));
    }
}
