package beijing;
/*
https://leetcode.cn/problems/possible-bipartition/
 */

import java.util.ArrayList;
import java.util.List;

public class possibleBipartition {
    // 自己不会写
    static class Solution {
        public boolean possibleBipartition(int n, int[][] dislikes) {
            int[] color = new int[n + 1];
            List<Integer>[] g = new List[n + 1];
            for (int i = 0; i < g.length; i++) {
                g[i] = new ArrayList<>();
            }
            for (int[] dislike : dislikes) {
                g[dislike[0]].add(dislike[1]);
                g[dislike[1]].add(dislike[0]);
            }
            for (int i = 1; i <= n; i++) {
                if (color[i] == 0 && !dfs(i, 1, color, g)) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(int curNode, int nowColor, int[] color, List<Integer>[] g) {
            color[curNode] = nowColor;
            for (int nextNode : g[curNode]) {
                if (color[nextNode] != 0 && color[curNode] == color[nextNode]) {
                    return false;
                }
                /*
                这里3^nowcolor进行染色分组，0表示未分组，1表示分组1，2表示分组2 在进行使用时，采用异或，
                 3（11）异或1（01）得到2（10），3（11）异或2（10）得到1（01）
                 */
                if (color[nextNode] == 0 && !dfs(nextNode, 3 ^ nowColor, color, g)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        System.out.println(new Solution().possibleBipartition(n, dislikes));
    }
}
