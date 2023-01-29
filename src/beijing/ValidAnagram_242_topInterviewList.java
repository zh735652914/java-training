package beijing;
/*
https://leetcode.cn/problems/valid-anagram/
 */

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242_topInterviewList {
    // 这个算法简单一些
    static class Solution {
        public boolean isAnagram(String s, String t) {
            int[] count = new int[26];
            int len = t.length();
            if (s.length() != len) {
                return false;
            }
            for (int i = 0; i < len; i++) {
                count[s.charAt(i) - 'a']++;
                count[t.charAt(i) - 'a']--;
            }
            for (int num : count) {
                if (num != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // 这个方法太慢了
    static class Solution0 {
        public boolean isAnagram(String s, String t) {
            Map<Character, Integer> map = new HashMap<>();
            int len1 = s.length();
            for (int i = 0; i < len1; i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            int len2 = t.length();
            for (int i = 0; i < len2; i++) {
                if (!map.containsKey(t.charAt(i))) {
                    return false;
                }
                if (map.get(t.charAt(i)) == 1) {
                    map.remove(t.charAt(i));
                } else {
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                }
            }
            return map.isEmpty();
        }
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(new Solution().isAnagram(s, t));
    }
}
