package beijing;
/*
https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */

public class reverseWords {
    // 这就是比较典型的双指针
    static class Solution {
        public String reverseWords(String s) {
            int n = s.length();
            StringBuilder stringBuilder = new StringBuilder();
            int right = n - 1, left = n - 1;
            while (left >= 0 && right >= 0) {
                while (right >= 0 && s.charAt(right) == ' ') {
                    right--;
                }
                if (right < 0) {
                    break;
                }
                left = right;
                while (left >= 0 && s.charAt(left) != ' ') {
                    left--;
                }
                stringBuilder.append(s, left + 1, right + 1);
                stringBuilder.append(' ');
                right = left;
            }
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        String s = "   the   sky is blue   ";
        System.out.println(new Solution().reverseWords(s));
    }
}
