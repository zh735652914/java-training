package beijing.hot100;
/*
https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */

import java.util.HashSet;
import java.util.Set;

// 滑动窗口，第三次写了
public class longestSubstringWithoutRepeatingCharacters {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> windows = new HashSet<>();
            int ans = 0, len = s.length();
            int start = 0, end = 0;
            while (end < len) {
                if (!windows.contains(s.charAt(end))) {
                    windows.add(s.charAt(end));
                } else {
                    while (windows.contains(s.charAt(end)) && start < end) {
                        windows.remove(s.charAt(start++));
                    }
                    windows.add(s.charAt(end));
                }
                ans = Math.max(ans, end - start + 1);
                end++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
