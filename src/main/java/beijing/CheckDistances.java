package beijing;
/*
https://leetcode.cn/problems/check-distances-between-same-letters/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/4/9 21:18
 */
public class CheckDistances {
    // 的确很简单
    static class Solution {
        public boolean checkDistances(String s, int[] distance) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char x = s.charAt(i);
                if (!map.containsKey(x)) {
                    map.put(s.charAt(i), i);
                } else if (i - map.get(x) - 1 != distance[x - 'a']) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "abaccb";
        int[] distance = {1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(new Solution().checkDistances(s, distance));
    }
}