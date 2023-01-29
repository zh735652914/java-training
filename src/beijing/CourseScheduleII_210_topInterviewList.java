package beijing;
/*
https://leetcode.cn/problems/course-schedule-ii/
 */

import java.util.ArrayList;
import java.util.List;

// 自己还是不会写，很重要的题目
public class CourseScheduleII_210_topInterviewList {
    static class Solution {
        private int[] visited;
        private List<List<Integer>> edg;
        private boolean valid;
        private int[] ans;
        private int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            edg = new ArrayList<>();
            visited = new int[numCourses];
            valid = true;
            for (int i = 0; i < numCourses; i++) {
                edg.add(new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                edg.get(prerequisite[1]).add(prerequisite[0]);
            }
            ans = new int[numCourses];
            index = numCourses - 1;
            for (int i = 0; i < numCourses && valid; i++) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            if (!valid) {
                return new int[0];
            }
            return ans;
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
            ans[index--] = u;
        }
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] ans = new Solution().findOrder(numCourses, prerequisites);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
