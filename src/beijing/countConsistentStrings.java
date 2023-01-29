package beijing;
/*
https://leetcode.cn/problems/count-the-number-of-consistent-strings/
 */

import java.util.HashSet;
import java.util.Set;

// 这个写法很简单
public class countConsistentStrings {
    static class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            Set<Character> set = new HashSet<>();
            int len = allowed.length();
            for (int i = 0; i < len; i++) {
                set.add(allowed.charAt(i));
            }
            int ans = 0;
            for (String word : words) {
                int L = word.length();
                boolean flag = false;
                for (int i = 0; i < L; i++) {
                    if (!set.contains(word.charAt(i))) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
                ans++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        System.out.println(new Solution().countConsistentStrings(allowed, words));
    }
}
