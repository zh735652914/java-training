package leetcode;
/*
387. First Unique Character in a String
Easy

1422

98

Add to List

Share
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */


import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class firstUniqChar {
    static class Solution {
        public int firstUniqChar0(String s) {
            Map<Character, Integer> hashMap = new LinkedHashMap<>();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (!set.contains(s.charAt(i)) && !hashMap.containsKey(s.charAt(i))) {
                    hashMap.put(s.charAt(i), i);
                    set.add(s.charAt(i));
                } else {
                    hashMap.remove(s.charAt(i));
                }
            }
            return hashMap.size() == 0 ? -1 : hashMap.entrySet().iterator().next().getValue();
        }

        //牛逼牛逼
        public int firstUniqChar(String s) {
            int[] index = new int[26];
            for (int i = 0; i < s.length(); i++) {
                index[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (index[s.charAt(i) - 'a'] == 1) return i;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "loveleetcode";
        String s = "aadadaad";
        System.out.println(solution.firstUniqChar(s));
    }
}
