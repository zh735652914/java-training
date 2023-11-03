package beijing;
/*
https://leetcode.cn/problems/first-unique-character-in-a-string/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/2/20 12:52
 */
public class FirstUniqueCharacterinaString_387_topInterviewList {
    // 典型简单题
    static class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (int i = 0; i < s.length(); i++) {
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
