package beijing;
/*
https://leetcode.cn/problems/flower-planting-with-no-adjacent/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/4/15 12:26
 */
// 自己没写出来
public class GardenNoAdj {
    static class Solution {
        public int[] gardenNoAdj(int n, int[][] paths) {
            List<Integer>[] adj = new List[n + 1];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int[] path : paths) {
                adj[path[0]].add(path[1]);
                adj[path[1]].add(path[0]);
            }
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                boolean[] colored = new boolean[5];
                for (int x : adj[i + 1]) {
                    colored[ans[x - 1]] = true;
                }
                for (int j = 1; j <= 4; j++) {
                    if (!colored[j]) {
                        ans[i] = j;
                        break;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] paths = {{1, 2}, {2, 3}, {3, 1}};
        int[] ans = new Solution().gardenNoAdj(n, paths);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
