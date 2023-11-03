package beijing;
/*
https://leetcode-cn.com/problems/course-schedule/
 */

import java.util.*;

public class CourseSchedule {

    // 看了解析写的，自己不会
    static class Solution {

        private List<List<Integer>> edg;
        private int[] visited;
        private boolean valid;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edg = new LinkedList<>();
            valid = true;
            for (int i = 0; i < numCourses; i++) {
                edg.add(new ArrayList<>());
            }
            visited = new int[numCourses];
            for (int[] req : prerequisites) {
                edg.get(req[1]).add(req[0]);
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

    // 自己写的超时了
    static class Solution0 {

        private Map<Integer, List<Integer>> map;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            map = new HashMap<>();
            for (int[] req : prerequisites) {
                map.put(req[0], map.getOrDefault(req[0], new LinkedList<>()));
                map.get(req[0]).add(req[1]);
            }
            for (int i = 0; i < numCourses; i++) {
                if (!dfs(i, new HashSet<>())) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(int course, Set<Integer> set) {
            set.add(course);
            if (!map.containsKey(course)) {
                return true;
            }
            for (int i = 0; i < map.get(course).size(); i++) {
                if (set.contains(map.get(course).get(i)) || !dfs(map.get(course).get(i), new HashSet<>(set))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {1, 2}};
        int numCourses = 3;
        System.out.println(new Solution().canFinish(numCourses, prerequisites));
    }
}
