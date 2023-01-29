package beijing;
/*
https://leetcode.cn/problems/permutation-in-string/
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// 自己一开始不会写，需要好好看看
public class permutationinString_567 {
    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> windows = new HashMap<>();
            Map<Character, Integer> target = new HashMap<>();
            for (char x : s1.toCharArray()) {
                target.put(x, target.getOrDefault(x, 0) + 1);
            }
            int valid = 0;
            int left = 0, right = 0, len2 = s2.length(), len1 = s1.length();
            while (right < len2) {
                char ch = s2.charAt(right);
                right++;
                if (target.containsKey(ch)) {
                    windows.put(ch, windows.getOrDefault(ch, 0) + 1);
                    if (Objects.equals(windows.get(ch), target.get(ch))) {
                        valid++;
                    }
                }
                if (right - left >= len1) {
                    if (valid == target.size()) {
                        return true;
                    }
                    ch = s2.charAt(left);
                    left++;
                    if (target.containsKey(ch)) {
                        if (Objects.equals(windows.get(ch), target.get(ch))) {
                            valid--;
                        }
                        windows.put(ch, windows.getOrDefault(ch, 1) - 1);
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbzaooo";
        System.out.println(new Solution().checkInclusion(s1, s2));
    }
}
