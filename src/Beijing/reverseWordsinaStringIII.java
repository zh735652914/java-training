package Beijing;
/*
https://leetcode.cn/problems/reverse-words-in-a-string-iii/
 */

public class reverseWordsinaStringIII {
    // 自己写的
    static class Solution {
        public String reverseWords(String s) {
            StringBuilder ans = new StringBuilder();
            StringBuilder word = new StringBuilder();
            int len = s.length();
            for (int i = 0; i < len; ) {
                while (i < len && s.charAt(i) == ' ') {
                    i++;
                    ans.append(' ');
                }
                int right = i;
                while (right < len && s.charAt(right) != ' ') {
                    right++;
                }
                word.append(s, i, right);
                ans.append(word.reverse());
                word.delete(0, word.length());
                i = right;
            }
            return ans.toString();
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(new Solution().reverseWords(s));
    }
}
