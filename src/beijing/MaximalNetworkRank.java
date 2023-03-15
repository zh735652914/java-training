package beijing;
/*
https://leetcode.cn/problems/maximal-network-rank/
 */

/**
 * @author zhouhao
 * @date 2023/3/15 12:34
 */
// 自己还是不会写
public class MaximalNetworkRank {
    static class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            boolean[][] connected = new boolean[n][n];
            int[] degree = new int[n];
            for (int[] road : roads) {
                connected[road[0]][road[1]] = true;
                connected[road[1]][road[0]] = true;
                degree[road[0]]++;
                degree[road[1]]++;
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int deg = degree[i] + degree[j] + (connected[i][j] ? -1 : 0);
                    ans = Math.max(ans, deg);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{0, 1}, {0, 3}, {1, 2}, {1, 3}};
        System.out.println(new Solution().maximalNetworkRank(n, roads));
    }
}
