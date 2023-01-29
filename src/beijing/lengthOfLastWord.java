package beijing;
/*
https://leetcode-cn.com/problems/length-of-last-word/
 */

public class lengthOfLastWord {
    // 这题没什么意义
    static class Solution {
        public int lengthOfLastWord(String s) {
            int index = s.length() - 1;
            while (index >= 0 && s.charAt(index) == ' ') {
                index--;
            }
            int end = index;
            while (index >= 0 && s.charAt(index) != ' ') {
                index--;
            }
            return end - index;
        }
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(new Solution().lengthOfLastWord(s));
    }
}
