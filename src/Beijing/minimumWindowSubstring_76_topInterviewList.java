package Beijing;
/*
https://leetcode.cn/problems/minimum-window-substring/
 */

import java.util.HashMap;
import java.util.Map;

public class minimumWindowSubstring_76_topInterviewList {
    // 【重要】这个滑动窗口自己没写出来，需要好好看看，很典型
    static class Solution {
        private Map<Character, Integer> sMap;
        private Map<Character, Integer> tMap;

        public String minWindow(String s, String t) {
            sMap = new HashMap<>();
            tMap = new HashMap<>();
            char[] TChs = t.toCharArray();
            for (char ch : TChs) {
                tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
            }
            int len = Integer.MAX_VALUE, left = -1, right = -1;
            int l = 0, r = -1;
            int sLen = s.length();
            while (r < sLen) {
                r++;
                if (r < sLen && tMap.containsKey(s.charAt(r))) {
                    sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
                }
                while (check() && l <= r) {
                    if (r - l + 1 < len) {
                        len = r - l + 1;
                        right = r + 1;
                        left = l;
                    }
                    if (tMap.containsKey(s.charAt(l))) {
                        sMap.put(s.charAt(l), sMap.getOrDefault(s.charAt(l), 0) - 1);
                    }
                    l++;
                }
            }
            return left == -1 ? "" : s.substring(left, right);
        }

        private boolean check() {
            for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
                if (sMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new Solution().minWindow(s, t));
    }
}
