package beijing;
/*
https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/
 */

import java.util.ArrayList;
import java.util.List;

public class areAlmostEqual {
    // 这个简单题我居然没思路
    static class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            int len = s1.length();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (list.size() >= 2) {
                        return false;
                    }
                    list.add(i);
                }
            }
            if (list.size() == 0) {
                return true;
            }
            if (list.size() != 2) {
                return false;
            }
            return s1.charAt(list.get(0)) == s2.charAt(list.get(1)) && s1.charAt(list.get(1)) == s2.charAt(list.get(0));
        }
    }

    public static void main(String[] args) {
        String s1 = "bank", s2 = "kanb";
        System.out.println(new Solution().areAlmostEqual(s1, s2));
    }
}
