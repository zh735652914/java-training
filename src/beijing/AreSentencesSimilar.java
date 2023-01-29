package beijing;
/*
https://leetcode.cn/problems/sentence-similarity-iii/
 */

/**
 * @author zhouhao
 * @date 2023/1/16 13:12
 */
// 自己没写出来
public class AreSentencesSimilar {
    static class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            int left = 0, right = 0;
            String[] words1 = sentence1.split(" ");
            String[] words2 = sentence2.split(" ");
            int len = Math.min(words1.length, words2.length);
            while (left < len && words1[left].equals(words2[left])) {
                left++;
            }
            while (right < (len - left) && words1[words1.length - 1 - right].equals(words2[words2.length - 1 - right])) {
                right++;
            }
            return left + right == len;
        }
    }

    public static void main(String[] args) {
        String sentence1 = "of", sentence2 = "A lot of words";
        System.out.println(new Solution().areSentencesSimilar(sentence1, sentence2));
    }
}
