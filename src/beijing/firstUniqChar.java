package beijing;
/*
https://leetcode.cn/problems/first-unique-character-in-a-string/
 */

import java.util.HashMap;
import java.util.Map;

// 也不难
public class firstUniqChar {
    static class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (int i = 0; i < len; i++) {
                if (map.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(new Solution().firstUniqChar(s));
    }
}
