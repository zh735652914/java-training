package Beijing;
/*
https://leetcode.cn/problems/find-if-path-exists-in-graph/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhouhao
 * @date 2022/12/19 19:02
 */
public class FindifPathExistsinGraph_1971 {
    // 自己一开始不会写了
    static class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            List<Integer>[] adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
            }
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(source);
            visited[source] = true;
            while (!queue.isEmpty()) {
                int u = queue.poll();
                if (u == destination) {
                    break;
                }
                for (int v : adj[u]) {
                    if (!visited[v]) {
                        queue.offer(v);
                        visited[v] = true;
                    }
                }
            }
            return visited[destination];
        }
    }

    public static void main(String[] args) {
        int n = 3, source = 0, destination = 2;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(new Solution().validPath(n, edges, source, destination));
    }
}
