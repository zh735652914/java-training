package beijing;
/*
https://leetcode-cn.com/problems/longest-nice-substring/
 */

public class longestNiceSubstring {
    static class Solution {
        // 还是别人写的清楚易懂
        public String longestNiceSubstring(String s) {
            if (s.length() < 2) {
                return "";
            }
            for (int i = 0; i < s.length(); i++) {
                String ch = s.substring(i, i + 1);
                if (!s.contains(ch.toUpperCase()) || !s.contains(ch.toLowerCase())) {
                    String s1 = longestNiceSubstring(s.substring(0, i));
                    String s2 = longestNiceSubstring(s.substring(i + 1));
                    return s1.length() >= s2.length() ? s1 : s2;
                }
            }
            return s;
        }
    }

    public static void main(String[] args) {
        String s = "YazaAay";
        System.out.println(new Solution().longestNiceSubstring(s));
    }
}
