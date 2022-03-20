package Beijing;
/*
https://leetcode-cn.com/problems/the-time-when-the-network-becomes-idle/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 自己不会，看着答案写的
public class networkBecomesIdle {
    static class Solution {
        public int networkBecomesIdle(int[][] edges, int[] patience) {
            int n = patience.length;
            List<Integer>[] adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
            boolean[] visit = new boolean[n];
            for (int[] edge : edges) {
                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            visit[0] = true;
            int dist = 1;
            int ans = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int cur = queue.poll();
                    for (int x : adj[cur]) {
                        if (visit[x]) {
                            continue;
                        }
                        queue.offer(x);
                        int time = patience[x] * ((2 * dist - 1) / patience[x]) + 2 * dist + 1;
                        ans = Math.max(time, ans);
                        visit[x] = true;
                    }
                }
                dist++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}};
        int[] patience = {0, 2, 1};
        System.out.println(new Solution().networkBecomesIdle(edges, patience));
    }
}
