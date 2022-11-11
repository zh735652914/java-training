package Beijing;
/*
https://leetcode.cn/problems/determine-if-string-halves-are-alike/
 */

import java.util.HashSet;
import java.util.Set;

public class halvesAreAlike {
    // 这题的确很简单
    static class Solution {
        public boolean halvesAreAlike(String s) {
            Set<Character> set = new HashSet<>();
            char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
            for (char vowel : vowels) {
                set.add(vowel);
            }
            int len = s.length();
            int left = 0, right = 0;
            for (int i = 0; i < len; i++) {
                if (set.contains(s.charAt(i))) {
                    if (i < len / 2) {
                        left++;
                    } else {
                        right++;
                    }
                }
            }
            return left == right;
        }
    }

    public static void main(String[] args) {
        String s = "book";
        System.out.println(new Solution().halvesAreAlike(s));
    }
}
