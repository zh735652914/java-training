package next;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * @author zhouhao
 * @date 2025/1/4 12:08
 */
public class leetcode3 {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int left = 0, right = 0;
            int maxLen = 0;
            Set<Character> set = new HashSet<>(s.length());
            while (right < s.length()) {
                char ch = s.charAt(right);
                if (set.contains(ch)) {
                    while (ch != s.charAt(left)) {
                        set.remove(s.charAt(left++));
                    }
                    left++;
                }
                set.add(ch);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
