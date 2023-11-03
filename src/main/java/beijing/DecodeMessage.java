package beijing;
/*
https://leetcode.cn/problems/decode-the-message/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/2/1 13:45
 */
public class DecodeMessage {
    // 这的确是简单题
    static class Solution {
        public String decodeMessage(String key, String message) {
            int len = key.length();
            Map<Character, Integer> map = new HashMap<>();
            int index = 0;
            for (int i = 0; i < len; i++) {
                Character x = key.charAt(i);
                if (x == ' ') {
                    continue;
                }
                if (!map.containsKey(x)) {
                    map.put(x, index++);
                }
            }
            int lenB = message.length();
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < lenB; i++) {
                char x = message.charAt(i);
                if (x == ' ') {
                    ans.append(' ');
                    continue;
                }
                if (map.containsKey(x)) {
                    ans.append((char) ('a' + map.get(x)));
                }
            }
            return ans.toString();
        }
    }

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv";
        System.out.println(new Solution().decodeMessage(key, message));
    }
}
