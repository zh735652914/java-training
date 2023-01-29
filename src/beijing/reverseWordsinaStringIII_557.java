package beijing;
/*
https://leetcode.cn/problems/reverse-words-in-a-string-iii/
 */

// 看了评论后写的
public class reverseWordsinaStringIII_557 {
    static class Solution {
        public String reverseWords(String s) {
            char[] CH = s.toCharArray();
            for (int left = 0, right = 0; right < CH.length; right++) {
                if (CH[right] == ' ' || right == CH.length - 1) {
                    reverse(CH, left, right == CH.length - 1 ? right : right - 1);
                    left = right + 1;
                    right = left;
                }
            }
            return new String(CH);
        }

        private void reverse(char[] chars, int left, int right) {
            char tmp;
            while (left < right) {
                tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        String s = "Let's   take LeetCode contest";
//        String s = "   ";
        System.out.println(new Solution().reverseWords(s));
    }
}
