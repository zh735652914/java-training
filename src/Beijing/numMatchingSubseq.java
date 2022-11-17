package Beijing;
/*
https://leetcode.cn/problems/number-of-matching-subsequences/
 */

import java.util.HashSet;
import java.util.Set;

public class numMatchingSubseq {
    // 添加去重就行
    static class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            char[] T = s.toCharArray();
            int count = 0;
            Set<String> YSet = new HashSet<>();
            Set<String> NSet = new HashSet<>();
            for (String word : words) {
                if (YSet.contains(word)) {
                    count++;
                    continue;
                }
                if (NSet.contains(word)) {
                    continue;
                }
                if (isInString(T, word)) {
                    count++;
                    YSet.add(word);
                } else {
                    NSet.add(word);
                }
            }
            return count;
        }

        private boolean isInString(char[] T, String word) {
            int len = word.length();
            int pos = 0;
            for (int i = 0; i < T.length && pos < len; i++) {
                if (word.charAt(pos) == T[i]) {
                    pos++;
                }
            }
            return pos >= len;
        }
    }

    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(new Solution().numMatchingSubseq(s, words));
    }
}
