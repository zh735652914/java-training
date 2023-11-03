package beijing;
/*
https://leetcode.cn/problems/course-schedule-iv/?envType=daily-question&envId=2023-09-12
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhouhao
 * @date 2023/9/12 21:48
 */
public class CheckIfPrerequisite {
    // 自己不会
    static class Solution {
        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            List<Integer>[] g = new List[numCourses];
            for (int i = 0; i < g.length; i++) {
                g[i] = new ArrayList<>();
            }
            int[] inDegree = new int[numCourses];
            boolean[][] isPre = new boolean[numCourses][numCourses];
            for (int[] p : prerequisites) {
                inDegree[p[1]]++;
                g[p[0]].add(p[1]);
            }
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int node : g[cur]) {
                    isPre[cur][node] = true;
                    for (int i = 0; i < numCourses; i++) {
                        isPre[i][node] = isPre[i][node] || isPre[i][cur];
                    }
                    if (--inDegree[node] == 0) {
                        queue.offer(node);
                    }
                }
            }
            List<Boolean> ans = new ArrayList<>();
            for (int[] query : queries) {
                ans.add(isPre[query[0]][query[1]]);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = {{1, 2}, {1, 0}, {2, 0}}, queries = {{1, 0}, {1, 2}};
        System.out.println(new Solution().checkIfPrerequisite(numCourses, prerequisites, queries));
    }
}
