package beijing;
/*
https://leetcode-cn.com/problems/unique-morse-code-words/
 */

import java.util.HashSet;
import java.util.Set;

// 这很简单
public class uniqueMorseRepresentations {
    static class Solution {
        private final String[] map = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        public int uniqueMorseRepresentations(String[] words) {
            Set<String> set = new HashSet<>();
            int count = 0;
            for (String word : words) {
                StringBuilder morse = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    morse.append(map[word.charAt(i) - 'a']);
                }
                if (!set.contains(morse.toString())) {
                    count++;
                    set.add(morse.toString());
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(new Solution().uniqueMorseRepresentations(words));
    }
}
