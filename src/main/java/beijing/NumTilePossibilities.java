package beijing;
/*
https://leetcode.cn/problems/letter-tile-possibilities/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/5/19 12:41
 */
// 写蒙了
public class NumTilePossibilities {
    static class Solution {
        public int numTilePossibilities(String tiles) {
            Map<Character, Integer> count = new HashMap<>();
            for (int i = 0; i < tiles.length(); i++) {
                count.put(tiles.charAt(i), count.getOrDefault(tiles.charAt(i), 0) + 1);
            }
            return dfs(count);
        }

        private int dfs(Map<Character, Integer> count) {
            int ans = 0;
            for (char ch : count.keySet()) {
                if (count.get(ch) > 0) {
                    ans++;
                    count.put(ch, count.get(ch) - 1);
                    ans += dfs(count);
                    count.put(ch, count.get(ch) + 1);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String tiles = "AAB";
        System.out.println(new Solution().numTilePossibilities(tiles));
    }
}
