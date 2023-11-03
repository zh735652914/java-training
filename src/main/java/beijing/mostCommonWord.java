package beijing;
/*
https://leetcode-cn.com/problems/most-common-word/
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 这个简单题也没有那么简单
public class mostCommonWord {
    static class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            Map<String, Integer> map = new HashMap<>();
            Set<String> set = new HashSet<>();
            for (String ban : banned) {
                set.add(ban.toLowerCase());
            }
            int maxCount = 0;
            StringBuilder stringBuilder = new StringBuilder();
            int len = paragraph.length();
            paragraph = paragraph.toLowerCase();
            for (int i = 0; i <= len; i++) {
                if (i < len && Character.isLetter(paragraph.charAt(i))) {
                    stringBuilder.append(paragraph.charAt(i));
                } else if (stringBuilder.length() > 0) {
                    String word = stringBuilder.toString();
                    if (!set.contains(word)) {
                        map.put(word, map.getOrDefault(word, 0) + 1);
                        maxCount = Math.max(maxCount, map.get(word));
                    }
                    stringBuilder.setLength(0);
                }
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxCount) {
                    return entry.getKey();
                }
            }
            return "";
        }
    }

    public static void main(String[] args) {
        String paragraph = "bob";
        String[] banned = {""};
        System.out.println(new Solution().mostCommonWord(paragraph, banned));
    }
}
