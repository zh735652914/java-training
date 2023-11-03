package beijing;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhouhao
 * @date 2023/3/7 12:58
 */
public class LongestSubstringWithoutRepeatingCharacters_3_HotOneHundred {
    // 很典型的题目
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> windows = new HashSet<>();
            int left = 0, right = 0;
            int ans = 0;
            while (right < s.length()) {
                char x = s.charAt(right);
                if (windows.contains(x)) {
                    while (s.charAt(left) != x) {
                        windows.remove(s.charAt(left++));
                    }
                    left++;
                }
                windows.add(x);
                ans = Math.max(ans, right - left + 1);
                right++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
