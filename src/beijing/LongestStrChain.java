package beijing;
/*
https://leetcode.cn/problems/longest-string-chain/
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/4/27 12:43
 */
// 看了解析才会写
public class LongestStrChain {
    static class Solution {
        public int longestStrChain(String[] words) {
            Arrays.sort(words, (a, b) -> a.length() - b.length());
            Map<String, Integer> map = new HashMap<>();
            int ans = 0;
            for (String word : words) {
                map.put(word, 1);
                for (int i = 0; i < word.length(); i++) {
                    String pre = word.substring(0, i) + word.substring(i + 1);
                    if (map.containsKey(pre)) {
                        map.put(word, Math.max(map.get(pre) + 1, map.get(word)));
                    }
                }
                ans = Math.max(ans, map.get(word));
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println(new Solution().longestStrChain(words));
    }
}
