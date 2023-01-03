package Beijing;
/*
https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/
 */

/**
 * @author zhouhao
 * @date 2023/1/3 12:29
 */
public class AreNumbersAscending {
    // 的确很简单
    static class Solution {
        public boolean areNumbersAscending(String s) {
            String[] words = s.split(" ");
            int right = -1;
            for (String word : words) {
                int index = 0;
                while (index < word.length() && Character.isDigit(word.charAt(index))) {
                    index++;
                }
                if (index >= word.length()) {
                    if (Integer.parseInt(word) > right) {
                        right = Integer.parseInt(word);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        System.out.println(new Solution().areNumbersAscending(s));
    }
}
