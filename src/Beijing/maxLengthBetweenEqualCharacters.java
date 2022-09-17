package Beijing;
/*
https://leetcode.cn/problems/largest-substring-between-two-equal-characters/
 */

import java.util.HashMap;
import java.util.Map;

// 的确很简单
public class maxLengthBetweenEqualCharacters {
    static class Solution {
        public int maxLengthBetweenEqualCharacters(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int ans = -1;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char x = s.charAt(i);
                if (map.containsKey(x)) {
                    ans = Math.max(ans, i - map.get(x) - 1);
                } else {
                    map.put(x, i);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "cbzxy";
        System.out.println(new Solution().maxLengthBetweenEqualCharacters(s));
    }
}
