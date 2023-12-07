package beijing;
/*
https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/?envType=daily-question&envId=Invalid%20Date
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/12/7 13:06
 */
public class MinReorder {
    // 自己不会
    static class Solution {
        public int minReorder(int n, int[][] connections) {
            List<int[]>[] edges = new List[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int[] connection : connections) {
                edges[connection[0]].add(new int[]{connection[1], 1});
                edges[connection[1]].add(new int[]{connection[0], 0});
            }
            return dfs(0, -1, edges);
        }

        private int dfs(int cur, int pre, List<int[]>[] edges) {
            int count = 0;
            for (int[] e : edges[cur]) {
                if (e[0] == pre) {
                    continue;
                }
                count += e[1] + dfs(e[0], cur, edges);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(new Solution().minReorder(n, connections));
    }
}
