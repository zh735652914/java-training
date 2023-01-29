package beijing;
/*
https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */

import java.util.HashSet;
import java.util.Set;

public class longestSubstringWithoutRepeatingCharacters_3 {
    // 有点生疏了
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> windows = new HashSet<>();
            int len = s.length(), left = 0, right = 0;
            int ans = 0;
            while (right < len) {
                char ch = s.charAt(right);
                if (!windows.contains(ch)) {
                    ans = Math.max(ans, right - left + 1);
                } else {
                    while (left < right && s.charAt(left) != ch) {
                        windows.remove(s.charAt(left));
                        left++;
                    }
                    windows.remove(ch);
                    if (left < right) {
                        left++;
                    }
                }
                right++;
                windows.add(ch);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
