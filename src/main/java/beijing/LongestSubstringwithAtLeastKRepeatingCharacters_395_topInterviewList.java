package beijing;
/*
https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/2/20 12:59
 */
// 这题要看看
public class LongestSubstringwithAtLeastKRepeatingCharacters_395_topInterviewList {
    static class Solution {
        public int longestSubstring(String s, int k) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() < k) {
                    int ans = 0;
                    for (String sub : s.split(String.valueOf(entry.getKey()))) {
                        ans = Math.max(ans, longestSubstring(sub, k));
                    }
                    return ans;
                }
            }
            return s.length();
        }
    }

    public static void main(String[] args) {
        String s = "ababbc";
        int k = 2;
        System.out.println(new Solution().longestSubstring(s, k));
    }
}
