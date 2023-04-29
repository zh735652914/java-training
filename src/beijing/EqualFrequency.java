package beijing;
/*
https://leetcode.cn/problems/remove-letter-to-equalize-frequency/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/4/29 13:05
 */
// 这个简单题可不简单
public class EqualFrequency {
    static class Solution {
        public boolean equalFrequency(String word) {
            int[] counts = new int[26];
            for (char x : word.toCharArray()) {
                counts[x - 'a']++;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int count : counts) {
                if (count > 0) {
                    map.put(count, map.getOrDefault(count, 0) + 1);
                }
            }
            for (int count : counts) {
                if (count == 0) {
                    continue;
                }
                map.put(count, map.get(count) - 1);
                if (map.get(count) == 0) {
                    map.remove(count);
                }
                if (count > 1) {
                    map.put(count - 1, map.getOrDefault(count - 1, 0) + 1);
                }
                if (map.size() == 1) {
                    return true;
                }
                if (count > 1) {
                    map.put(count - 1, map.getOrDefault(count - 1, 0) - 1);
                    if (map.get(count - 1) == 0) {
                        map.remove(count - 1);
                    }
                }
                map.put(count, map.getOrDefault(count, 0) + 1);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String word = "abcc";
        System.out.println(new Solution().equalFrequency(word));
    }
}
