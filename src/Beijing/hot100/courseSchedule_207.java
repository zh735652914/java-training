package Beijing.hot100;
/*
https://leetcode.cn/problems/course-schedule/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class courseSchedule_207 {
    // 自己还是不会写，也很重要！
    static class Solution {
        private List<List<Integer>> edge;
        private boolean isValid;
        private int[] visit;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edge = new LinkedList<>();
            isValid = true;
            visit = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                edge.add(new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                edge.get(prerequisite[1]).add(prerequisite[0]);
            }
            for (int i = 0; i < numCourses; i++) {
                if (visit[i] == 0) {
                    dfs(i);
                }
            }
            return isValid;
        }

        private void dfs(int x) {
            visit[x] = 1;
            for (int node : edge.get(x)) {
                if (visit[node] == 0) {
                    dfs(node);
                } else if (visit[node] == 1) {
                    isValid = false;
                }
                if (!isValid) {
                    return;
                }
            }
            visit[x] = 2;
        }
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(new Solution().canFinish(numCourses, prerequisites));
    }
}
