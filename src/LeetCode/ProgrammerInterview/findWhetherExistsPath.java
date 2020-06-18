package LeetCode.ProgrammerInterview;
/*
面试题 04.01. 节点间通路
节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。

示例1:

 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 输出：true
示例2:

 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 输出 true
提示：

节点数量n在[0, 1e5]范围内。
节点编号大于等于 0 小于 n。
图中可能存在自环和平行边。
通过次数2,449提交次数4,602
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//这题需要引起重视，不是有多难，是很多知识点都忘了
public class findWhetherExistsPath {
    static class Solution {
        public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
            List<Integer>[] adj = new ArrayList[n];
            for (int[] edg : graph) {
                int from = edg[0];
                int to = edg[1];
                if (adj[from] == null) {
                    adj[from] = new ArrayList<>();
                }
                adj[from].add(to);
            }
            return hasPath_BFS(n, adj, start, target);
        }

        private boolean hasPath_BFS(int n, List<Integer>[] adj, int start, int target) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visit = new boolean[n];
            visit[start] = true;
            queue.offer(start);
            while (!queue.isEmpty()) {
                int nums = queue.size();
                while (nums-- > 0) {
                    List<Integer> next = adj[queue.poll()];
                    if (next == null) continue;
                    for (int i = 0; i < next.size(); i++) {
                        int node = next.get(i);
                        if (node == target) return true;
                        if (visit[node]) continue;
                        queue.offer(node);
                        visit[node] = true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] graph = {{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}};
        int start = 0, target = 4;
        System.out.println(new Solution().findWhetherExistsPath(n, graph, start, target));
    }
}
