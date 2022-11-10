package Beijing;
/*
https://leetcode.cn/problems/course-schedule/
 */

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule_207_topInterviewList {
    // 自己还是没写出来
    static class Solution {
        private List<List<Integer>> edg;
        private int[] visited;
        private boolean valid;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edg = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                edg.add(new ArrayList<>());
            }
            visited = new int[numCourses];
            valid = true;
            for (int[] prerequisite : prerequisites) {
                edg.get(prerequisite[1]).add(prerequisite[0]);
            }
            for (int i = 0; i < numCourses && valid; i++) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            return valid;
        }

        private void dfs(int u) {
            visited[u] = 1;
            for (int v : edg.get(u)) {
                if (visited[v] == 0) {
                    dfs(v);
                    if (!valid) {
                        return;
                    }
                } else if (visited[v] == 1) {
                    valid = false;
                    return;
                }
            }
            visited[u] = 2;
        }
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(new Solution().canFinish(numCourses, prerequisites));
    }
}
