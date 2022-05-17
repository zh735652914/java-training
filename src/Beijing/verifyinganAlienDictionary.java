package Beijing;
/*
https://leetcode.cn/problems/verifying-an-alien-dictionary/
 */

import java.util.HashMap;
import java.util.Map;

// 看解析看了半天才写出来
public class verifyinganAlienDictionary {
    static class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            int len = order.length();
            Map<Character, Integer> map = new HashMap<>(len);
            for (int i = 0; i < len; i++) {
                map.put(order.charAt(i), i);
            }
            for (int i = 1; i < words.length; i++) {
                boolean valid = false;
                int lC = words[i].length(), lP = words[i - 1].length();
                for (int j = 0; j < lC && j < lP; j++) {
                    int cur = map.get(words[i].charAt(j)), pre = map.get(words[i - 1].charAt(j));
                    if (cur > pre) {
                        valid = true;
                        break;
                    } else if (cur < pre) {
                        return false;
                    }
                }
                if (!valid) {
                    if (words[i].length() < words[i - 1].length()) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(new Solution().isAlienSorted(words, order));
    }
}
