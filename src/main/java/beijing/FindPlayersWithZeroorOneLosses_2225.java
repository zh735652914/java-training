package beijing;
/*
https://leetcode.cn/problems/find-players-with-zero-or-one-losses/description/?envType=daily-question&envId=2024-05-22
 */

import java.util.*;

/**
 * @author zhouhao
 * @date 2024/5/22 08:35
 */
public class FindPlayersWithZeroorOneLosses_2225 {
    static class Solution {
        public List<List<Integer>> findWinners(int[][] matches) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] match : matches) {
                map.putIfAbsent(match[0], 0);
                map.put(match[1], map.getOrDefault(match[1], 0) + 1);
            }
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < 2; ++i) {
                ans.add(new ArrayList<>());
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 0) {
                    ans.get(0).add(entry.getKey());
                } else if (entry.getValue() == 1) {
                    ans.get(1).add(entry.getKey());
                }
            }
            Collections.sort(ans.get(0));
            Collections.sort(ans.get(1));
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        System.out.println(new Solution().findWinners(matches));
    }
}
