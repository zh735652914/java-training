package beijing;
/*
https://leetcode.cn/problems/check-permutation-lcci/
 */

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
    // 的确很简单
    static class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            if (len1 != len2) {
                return false;
            }
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < len1; i++) {
                map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
            }
            for (int i = 0; i < len2; i++) {
                if (map.getOrDefault(s2.charAt(i), 0) <= 0) {
                    return false;
                }
                map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s1 = "dbc", s2 = "bca";
        System.out.println(new Solution().CheckPermutation(s1, s2));
    }
}
