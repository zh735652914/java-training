package Beijing;
/*
https://leetcode-cn.com/problems/longest-word-in-dictionary/
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class longestWord {
    // 这种简单题，我居然没思路
    static class Solution {
        public String longestWord(String[] words) {
            Arrays.sort(words, (word1, word2) -> {
                if (word1.length() != word2.length()) {
                    return word1.length() - word2.length();
                } else {
                    return word2.compareTo(word1);
                }
            });
            String ans = "";
            Set<String> set = new HashSet<>();
            set.add("");
            for (String word : words) {
                if (set.contains(word.substring(0, word.length() - 1))) {
                    ans = word;
                    set.add(word);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(new Solution().longestWord(words));
    }
}
