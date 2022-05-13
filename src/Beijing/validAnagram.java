package Beijing;
/*
https://leetcode.cn/problems/valid-anagram/
 */

// 这题也很简单
public class validAnagram {
    static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] map = new int[26];
            int len = s.length();
            for (int i = 0; i < len; i++) {
                map[s.charAt(i) - 'a']++;
                map[t.charAt(i) - 'a']--;
            }
            for (int x : map) {
                if (x != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(new Solution().isAnagram(s, t));
    }
}
