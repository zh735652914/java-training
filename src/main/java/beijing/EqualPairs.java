package beijing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/6/6 13:00
 */
// hash
public class EqualPairs {
    static class Solution {
        public int equalPairs(int[][] grid) {
            Map<String, Integer> map = new HashMap<>();
            for (int[] row : grid) {
                StringBuilder key = new StringBuilder();
                for (int x : row) {
                    key.append(x);
                    key.append(',');
                }
                map.put(key.toString(), map.getOrDefault(key.toString(), 0) + 1);
            }
            int ans = 0;
            for (int i = 0; i < grid[0].length; i++) {
                StringBuilder key = new StringBuilder();
                for (int j = 0; j < grid.length; j++) {
                    key.append(grid[j][i]);
                    key.append(',');
                }
                if (map.containsKey(key.toString())) {
                    ans += map.get(key.toString());
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
//        int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        int[][] grid = {
                {3, 1, 2, 2},
                {1, 4, 4, 4},
                {2, 4, 2, 2},
                {2, 5, 2, 2}
        };
        System.out.println(new Solution().equalPairs(grid));
    }
}
