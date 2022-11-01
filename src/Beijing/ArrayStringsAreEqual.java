package Beijing;
/*
https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/
 */

import java.util.Objects;

// 的确很简单
public class ArrayStringsAreEqual {
    static class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            StringBuilder stringBuilder1 = new StringBuilder();
            for (String word : word1) {
                stringBuilder1.append(word);
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            for (String word : word2) {
                stringBuilder2.append(word);
            }
            return Objects.equals(stringBuilder1.toString(), stringBuilder2.toString());
        }
    }

    public static void main(String[] args) {
        String[] word1 = {"ab", "c"}, word2 = {"a", "bc"};
        System.out.println(new Solution().arrayStringsAreEqual(word1, word2));
    }
}
