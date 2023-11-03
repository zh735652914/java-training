package beijing;
/*
https://leetcode.cn/problems/circular-sentence/
 */

/**
 * @author zhouhao
 * @date 2023/6/30 12:28
 */
public class IsCircularSentence {
    // 自己写的不够简洁
    static class Solution0 {
        public boolean isCircularSentence(String sentence) {
            if (sentence.charAt(0) == ' ' || sentence.charAt(sentence.length() - 1) == ' ') {
                return false;
            }
            String[] words = sentence.split(" ");
            char last = words[words.length - 1].charAt(words[words.length - 1].length() - 1);
            for (String word : words) {
                if (last != word.charAt(0)) {
                    return false;
                }
                for (int i = 0; i < word.length(); i++) {
                    if (!Character.isLetter(word.charAt(i))) {
                        return false;
                    }
                }
                last = word.charAt(word.length() - 1);
            }
            return true;
        }
    }

    // 官方解析好要一些
    static class Solution {
        public boolean isCircularSentence(String sentence) {
            if (sentence.charAt(sentence.length() - 1) != sentence.charAt(0)) {
                return false;
            }
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ' && sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String sentence = "leetcodl";
        System.out.println(new Solution().isCircularSentence(sentence));
    }
}
