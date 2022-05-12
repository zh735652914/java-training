package Beijing;
/*
https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/
 */

import java.util.HashMap;
import java.util.Map;

// 看了评论思路知道了也没写出来，看了校友写的代码才会，为毛自己这么菜？？？？
public class longestSubstring {
    static class Solution {
        public int longestSubstring(String s, int k) {
            if (s.length() < k) {
                return 0;
            }
            int len = s.length();
            Map<Character, Integer> count = new HashMap<>();
            for (int i = 0; i < len; i++) {
                count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (Character x : count.keySet()) {
                if (count.get(x) < k) {
                    int ans = 0;
                    for (String sub : s.split(String.valueOf(x))) {
                        ans = Math.max(ans, longestSubstring(sub, k));
                    }
                    return ans;
                }
            }
            return len;
        }
    }

    public static void main(String[] args) {
        String s = "ababacb";
        int k = 3;
        System.out.println(new Solution().longestSubstring(s, k));
    }
}
